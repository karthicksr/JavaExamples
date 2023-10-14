package com.example.demo.java8.Function;

import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {

		//By using Consumer Functional interface achieve the functionality with two lines of code. 
		Consumer<Integer> squareMe = i -> System.out
				.println("Taking an input and performing operation and do not return :" + i * i);
		squareMe.accept(5);
		
		//Without Consumer Functional interface achieve the functionality 
		ConsumerDemo consumer = new ConsumerDemo();
		consumer.square(5);
	}

	public void square(int i) {
		System.out.println("Taking an input and performing operation and do not return :" + i * i);
	}

}
