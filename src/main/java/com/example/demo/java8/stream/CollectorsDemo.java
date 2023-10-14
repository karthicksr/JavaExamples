package com.example.demo.java8.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

	public static void main(String args[]) {

		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);

		// Collectors class joining method
		String joiningString = numbers.map(i -> i.toString()).collect(Collectors.joining(",", "{", "}"));
		System.out.println("Joining string :" + joiningString);
	}

}
