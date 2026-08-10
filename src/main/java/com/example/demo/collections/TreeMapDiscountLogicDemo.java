package com.example.demo.collections;


import java.util.Map;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDiscountLogicDemo {

	private static double getDiscount(NavigableMap<Double, Double> tiers, double cartTotal) {
		// floorEntry(7350) looks at keys (0, 1000, 5000, 10000, 20000) and finds 5000
		// as the
		// closest lower match.
		Map.Entry<Double, Double> matchingTier = tiers.floorEntry(cartTotal);

		return (matchingTier != null) ? matchingTier.getValue() : 0.0;

	}

	public static void getTailMap(NavigableMap<Double, Double> tiers, double cartTotal) {
		SortedMap<Double, Double> tailMap = tiers.tailMap(cartTotal);
		int tailMapSize = tailMap.entrySet().size();
		System.out.println("tail map size -->" + tailMapSize);
		for (Map.Entry<Double, Double> entry : tailMap.entrySet()) {
			System.out.println(
					"Key (Tier Start): ₹" + entry.getKey() + " -> Value (Discount): " + (entry.getValue() * 100) + "%");
		}

	}

	public static void getHeadMap(NavigableMap<Double, Double> tiers, double cartTotal) {
		SortedMap<Double, Double> tailMap = tiers.headMap(cartTotal);
		int tailMapSize = tailMap.entrySet().size();
		System.out.println("head map size -->" + tailMapSize);
		for (Map.Entry<Double, Double> entry : tailMap.entrySet()) {
			System.out.println(
					"Key (Tier Start): ₹" + entry.getKey() + " -> Value (Discount): " + (entry.getValue() * 100) + "%");
		}

	}

	public static void getSubMap(NavigableMap<Double, Double> tiers, double fromKey, double toKey) {
		SortedMap<Double, Double> tailMap = tiers.subMap(fromKey, false, toKey, false);
		int tailMapSize = tailMap.entrySet().size();
		System.out.println("sub map size -->" + tailMapSize);
		for (Map.Entry<Double, Double> entry : tailMap.entrySet()) {
			System.out.println(
					"Key (Tier Start): ₹" + entry.getKey() + " -> Value (Discount): " + (entry.getValue() * 100) + "%");
		}

	}

	public static void main(String[] args) {

		// Step 1: Initialize the NavigableMap using TreeMap
		// We store the Lower Bound of the price tier as the Key, and the Discount as
		// the Value.
		NavigableMap<Double, Double> discountTiers = new TreeMap<>();

		discountTiers.put(0.0, 0.0); // >= 0 gets 0%
		discountTiers.put(1000.0, 0.05); // >= 1000 gets 5%
		discountTiers.put(5000.0, 0.10); // >= 5000 gets 10%
		discountTiers.put(10000.0, 0.15); // >= 10000 gets 15%
		discountTiers.put(20000.0, 0.20); // >= 20000 gets 20%

		// Step 2: Define dynamic user cart totals
		double cartTotal1 = 7350.0;
		double cartTotal2 = 1000.0;
		double cartTotal3 = 12500.0;
		double cartTotal4 = 20500.0;

		// Step 3: Use floorEntry to find the matching tier instantly in O(log N) time
		System.out
				.println("Discount for ₹" + cartTotal1 + " is: " + getDiscount(discountTiers, cartTotal1) * 100 + "%");
		System.out
				.println("Discount for ₹" + cartTotal2 + " is: " + getDiscount(discountTiers, cartTotal2) * 100 + "%");
		System.out
				.println("Discount for ₹" + cartTotal3 + " is: " + getDiscount(discountTiers, cartTotal3) * 100 + "%");
		System.out
				.println("Discount for ₹" + cartTotal4 + " is: " + getDiscount(discountTiers, cartTotal4) * 100 + "%");

		getTailMap(discountTiers, cartTotal1);

		getHeadMap(discountTiers, cartTotal1);
		
		getSubMap(discountTiers, cartTotal1, cartTotal4);
	}

}

