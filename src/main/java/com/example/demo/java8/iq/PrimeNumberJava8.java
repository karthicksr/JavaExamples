package com.example.demo.java8.iq;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimeNumberJava8 {

	public static void main(String[] args) {
		System.out.println(isPrime(7));
		System.out.println(isPrimeLatest(7));

		List<Double> sqrtof10Prime = new ArrayList<>(10);

		int index = 1;
		while (sqrtof10Prime.size() < 10) {
			if (isPrime(index)) {
				sqrtof10Prime.add(Math.sqrt(index));
			}
			index++;
		}
		System.out.println(sqrtof10Prime);

		List<Double> sqlrof10PrimeNumbers = Stream.iterate(1, i -> i + 1).filter(PrimeNumberJava8::isPrimeLatest)
				.map(Math::sqrt).limit(10).collect(Collectors.toList());
		System.out.println(sqlrof10PrimeNumbers);
	}

	public static boolean isPrime(int number) {
		boolean isDivisible = false;

		for (int i = 2; i < number; i++) {
			if (i % number == 0) {
				isDivisible = true;
			}
		}
		return number > 1 && !isDivisible;
	}

	public static boolean isPrimeLatest(int number) {
		return number > 1 && IntStream.range(2, number).noneMatch(n -> n % number == 0);
	}

}
