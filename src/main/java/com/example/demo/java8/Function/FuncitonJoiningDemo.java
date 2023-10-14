package com.example.demo.java8.Function;

import java.util.function.Function;

public class FuncitonJoiningDemo {

	public static void main(String[] args) {

		Function<Integer, Integer> doubleIt = x -> 2 * x;

		System.out.println("Double of value 5 is : " + doubleIt.apply(2));

		Function<Integer, Integer> cubeIt = x -> x * x * x;

		System.out.println("Cube of value 5 is : " + cubeIt.apply(2));

		System.out.println("First double and then cube of 2 is : " + doubleIt.andThen(cubeIt).apply(2));

		System.out.println("First cube and then double of 2 is : " + doubleIt.compose(cubeIt).apply(2));

	}
}
