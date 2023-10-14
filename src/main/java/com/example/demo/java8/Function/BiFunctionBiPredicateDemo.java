package com.example.demo.java8.Function;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class BiFunctionBiPredicateDemo {

	public static void main(String args[]) {

		BiPredicate<Integer, Integer> sum = (a, b) -> a + b > 5;
		System.out.println("Bi Predicate demo : " + sum.test(2, 5));

		BiFunction<Integer, Integer, Integer> multiplyBoth = (a, b) -> a * b;
		System.out.println("Bi Function demo :" + multiplyBoth.apply(2, 5));
	}
}
