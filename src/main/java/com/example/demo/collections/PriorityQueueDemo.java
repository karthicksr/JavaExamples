package com.example.demo.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class PriorityQueueDemo {

	/**
	 * Record definition matching the model.
	 */
	public record Product(String id, String category, double price, long salesVolume) {
	}

	/**
	 * Generates a dataset of 105 products including edge cases for unit testing.
	 */
	public static List<Product> generateTestData() {
		List<Product> products = new ArrayList<>();

		// ------------------------------------------------------------------
		// 1. HARDCODED EDGE CASES (To verify tie-breaker logic specifically)
		// ------------------------------------------------------------------
		// Case A: Identical sales volume (5,000), different prices ($999.99 vs $499.99)
		products.add(new Product("PROD-001", "Electronics", 999.99, 5000));
		products.add(new Product("PROD-002", "Electronics", 499.99, 5000)); // Should rank higher if Price ASC
																			// tie-breaker

		// Case B: Identical sales volume (5,000) AND price ($499.99) -> Test ID
		// tie-breaker
		products.add(new Product("PROD-003", "Home & Kitchen", 499.99, 5000));

		// Case C: Minimum / Maximum price boundaries
		products.add(new Product("PROD-004", "Books", 0.99, 12000)); // Very cheap
		products.add(new Product("PROD-005", "Beauty", 4999.99, 8500)); // High price

		// Case D: Zero sales volume items
		products.add(new Product("PROD-006", "Clothing", 25.00, 0));
		products.add(new Product("PROD-007", "Sports", 45.00, 0));

		// ------------------------------------------------------------------
		// 2. PROGRAMMATIC DATA GENERATION (Generates remaining 98 items)
		// ------------------------------------------------------------------
		String[] categories = { "Electronics", "Clothing", "Home & Kitchen", "Books", "Sports", "Beauty", "Toys",
				"Automotive" };

		// Seeded random (seed 42) ensures identical data generated on every test run
		Random random = new Random(42);

		for (int i = 8; i <= 105; i++) {
			String id = String.format("PROD-%03d", i);
			String category = categories[random.nextInt(categories.length)];

			// Random price between $5.00 and $1,500.00 rounded to 2 decimal places
			double rawPrice = 5.00 + (random.nextDouble() * 1495.00);
			double price = Math.round(rawPrice * 100.0) / 100.0;

			// Varied sales volumes between 50 and 80,000 units
			long salesVolume = (random.nextInt(800) + 1) * 100L;

			products.add(new Product(id, category, price, salesVolume));
		}

		return products;
	}

	public static final Comparator<Product> PRODUCT_PRIMARY_COMPARATOR = Comparator.comparingLong(Product::salesVolume)
			.reversed().thenComparingDouble(Product::price).thenComparing(Product::id);

	public static final Comparator<Product> MIN_HEAP_COMPARATOR = PRODUCT_PRIMARY_COMPARATOR.reversed();

	public static List<Product> getProducts(List<Product> products, double minPrice, double maxPrice,
			Set<String> allowedCategories, int top) {
		if (products.isEmpty() || minPrice <= 0.0 || maxPrice <= 0.0 || allowedCategories.isEmpty() || top <= 0)
			return Collections.emptyList();

		PriorityQueue<Product> minHeap = new PriorityQueue<>(top + 1, MIN_HEAP_COMPARATOR);

		products.stream().filter(p -> p.price >= minPrice).filter(p -> p.price <= maxPrice)
				.filter(p -> allowedCategories.contains(p.category)).forEach(p -> {
					if (minHeap.size() <= top) {
						minHeap.offer(p);
					} else {
						minHeap.poll();
					}
				});
		return minHeap.stream().sorted(PRODUCT_PRIMARY_COMPARATOR).collect(Collectors.toList());
	}

	// Quick runner to print sample dataset
	public static void main(String[] args) {
		List<Product> testData = generateTestData();
		System.out.println("Generated " + testData.size() + " test products.");

	
		String[] allowedCategories = { "Electronics", "Clothing", "Home & Kitchen", "Books", "Sports", "Beauty", "Toys",
				"Automotive" };
		Set<String> categories = Set.of(allowedCategories);
		List<Product> products = getProducts(testData, 0.5, 10000, categories, 90);
		products.forEach(p -> System.out.printf("ID: %-8s | Cat: %-15s | Price: $%7.2f | Sales: %,6d\n", p.id(),
				p.category(), p.price(), p.salesVolume()));
	}
}
