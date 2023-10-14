package com.example.demo.java8.stream;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ReduceDemo {
	public static void main(String args[]) {

		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);

		System.out.println("Summation of Integers :" + numbers.reduce((a, b) -> a + b).get());

		
	}
}
