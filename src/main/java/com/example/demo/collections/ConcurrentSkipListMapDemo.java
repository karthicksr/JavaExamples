package com.example.demo.collections;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentSkipListMapDemo {

	public record Transaction(long customerId, BigDecimal amount, Instant timestamp, String category) {
	}

	private final static BigDecimal BUCKET_SIZE = BigDecimal.valueOf(1000);

	private final NavigableMap<BigDecimal, List<Transaction>> buckets = new ConcurrentSkipListMap<>();

	/**
	 * Calculates the bucket key using BigDecimal floor division. Example: $350.75 /
	 * 100 -> Floor = 3 -> 3 * 100 = $300 key
	 */
	private BigDecimal getBucketKey(BigDecimal amount) {
		return amount.divide(BUCKET_SIZE, 0, RoundingMode.FLOOR).multiply(BUCKET_SIZE);
	}

	public void ingest(Transaction tx) {
		BigDecimal bucket = getBucketKey(tx.amount);
		buckets.computeIfAbsent(bucket, k -> new ArrayList<Transaction>()).add(tx);
	}

	public void ingestAll(List<Transaction> transactions) {
		transactions.parallelStream().forEach(this::ingest);
	}

	Comparator<Transaction> comparator = Comparator.comparing(Transaction::amount, Comparator.reverseOrder())
			.thenComparing(Transaction::timestamp, Comparator.reverseOrder());

	// Query Logic
	public List<Transaction> queryAboveThreashold(BigDecimal threashold) {
		if (threashold == null || threashold.compareTo(BigDecimal.ZERO) < 0) {
			return Collections.emptyList();
		}
		
		BigDecimal startBucket = getBucketKey(threashold);
		return buckets.tailMap(startBucket, true).values().stream().flatMap(List::stream)
				.filter(t -> t.amount.compareTo(threashold) > 0).sorted(comparator).toList();

	}

	/**
	 * Generates 100 random transaction records with amounts up to $1,000.00 and
	 * timestamps spread over the last 24 hours.
	 */
	private static List<Transaction> generate100Transactions() {
		List<Transaction> list = new ArrayList<>();
		String[] categories = { "Electronics", "Clothing", "Home", "Books", "Beauty" };
		Random random = new Random(42); // Seeded for repeatable test runs
		Instant now = Instant.now();

		for (int i = 1; i <= 100; i++) {
			long customerId = 1000 + i;

			// Random price between $10.00 and $1,000.00 rounded to 2 decimal places
			double rawAmount = 10.0 + (random.nextDouble() * 990.0);
			BigDecimal amount = BigDecimal.valueOf(rawAmount).setScale(2, RoundingMode.HALF_UP);

			// Random timestamp within the last 24 hours (0 to 86,400 seconds ago)
			long secondsAgo = random.nextInt(86_400);
			Instant timestamp = now.minusSeconds(secondsAgo);

			String category = categories[random.nextInt(categories.length)];

			list.add(new Transaction(customerId, amount, timestamp, category));
		}
		BigDecimal amount = BigDecimal.valueOf(500).setScale(2, RoundingMode.HALF_UP);
		Instant timestamp = now.minusSeconds(500);
		Instant timestamp1 = now.minusSeconds(5000);
		list.add(new Transaction(1100, amount, timestamp, "Electronics"));
		list.add(new Transaction(1110, amount, timestamp1, "Electronics"));

		return list;
	}

	public static void main(String[] args) {
		ConcurrentSkipListMapDemo demo = new ConcurrentSkipListMapDemo();
		List<Transaction> transactions = generate100Transactions();
		System.out.println("Total List Size -->" + transactions.size());
		// Step1: Inject all in to the map
		demo.ingestAll(transactions);

		BigDecimal threashold = new BigDecimal("400");
		// Ste2: Call queryAboveThreashold method
		List<Transaction> filterList = demo.queryAboveThreashold(threashold);
		filterList.forEach(System.out::println);
		System.out.println("Filtered List Size -->" + filterList.size());
	}
}
