package com.example.demo.java8.Function;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		// Using Supplier interface supply the data to the caller. It wont take any
		// input but return data only. Chaining is not possible since we dont have any
		// input
		Supplier<Date> currentDate = () -> new Date();
		System.out.println("Current date is : " + currentDate.get());

	}
}
