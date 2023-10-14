package com.example.demo.java8.Function;

import java.util.function.Function;

public class FunctionDemo {

	public static void main(String[] args) {

		Function<Integer, Integer> isSquare = x -> x * x;

		System.out.println("The square of 5 is : " + isSquare.apply(5));
	}
}
