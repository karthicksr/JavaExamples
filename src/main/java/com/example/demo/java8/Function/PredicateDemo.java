package com.example.demo.java8.Function;

import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {

		//We implemented predicate test method here. Now we can use this variable anywhere needed and call the test method with diff arguments. 
		Predicate<String> checkLength = s -> s.length() > 5;

		System.out.println("Is my String is greater than 5 : " + checkLength.test("Welcome"));
	}

}
