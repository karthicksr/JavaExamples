package com.example.demo.java8;

import java.util.function.BiConsumer;

public class LambdaDemo implements BiConsumer<Integer, Integer> {

	@Override
	public void accept(Integer a, Integer b) {
		System.out.println(a + b);
	}

	public static void main(String[] args) {

		// Using Lambda Expression below 2 lines of codes achieve the desired output
		BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println(a + b);
		biConsumer.accept(10, 5);

		// Normal operation call before Java 8
		LambdaDemo demo = new LambdaDemo();
		demo.accept(10, 5);
	}
}
