package com.example.demo.java8.Function;

import java.util.function.Predicate;

public class PredicateJoiningDemo {

	public static void main(String[] args) {
		Predicate<String> checkLength = s -> s.length() > 5;
		System.out.println("Is my String is greater than 5 : " + checkLength.test("Welcome"));

		Predicate<String> checkEvenLength = s -> s.length() % 2 == 0;
		System.out.println("Is my String is even: " + checkEvenLength.test("Welcome"));

		// it can be joined with and
		System.out.println("after merging with and : " + checkLength.and(checkEvenLength).test("welcome"));

		// it can be joined with or
		System.out.println("after merging with or : " + checkLength.or(checkEvenLength).test("welcome"));

		// it can be joined with negate
		System.out.println("test with negate : " + checkLength.negate().test("welcome"));
		
	

	}
}
