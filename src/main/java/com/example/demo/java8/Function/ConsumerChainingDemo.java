package com.example.demo.java8.Function;

import java.util.function.Consumer;

public class ConsumerChainingDemo {

	public static void main(String[] args) {

		// By using Consumer Functional interface achieve the functionality with two
		// lines of code.
		Consumer<Integer> squareMe = i -> System.out
				.println("Taking an input and performing square operation and do not return :" + i * i);
		squareMe.accept(5);

		Consumer<Integer> doubleMe = i -> System.out
				.println("Taking an input and performing double operation and do not return :" + 2 * i);
		doubleMe.accept(5);

		squareMe.andThen(doubleMe).accept(5);

	}

}
