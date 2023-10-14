package com.example.demo.java8.iq;

import java.util.Arrays;
import java.util.List;

public class LimitandSkipMethodDemo {

	public static void main(String[] args) {

		List<Integer> numbers = Arrays.asList(1, 4, 5, 6, 8, 10, 20, 35, 46, 58);

		// limit method return a stream not longer than requested size. The n parameter
		// cant be negative.
		//numbers.stream().limit(5).forEach(System.out::println);

		// skip method discards the first n elements and returns remaining as a stream.
		// If n is higher than size of stream, it return empty
		numbers.stream().skip(5).forEach(System.out::println);
	}

}
