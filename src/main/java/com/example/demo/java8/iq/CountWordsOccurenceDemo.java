package com.example.demo.java8.iq;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWordsOccurenceDemo {

	public static void main(String[] args) {

		String text = "Welcome to Code Decode. Code decode welcome you";
		List<String> list = Arrays.asList(text.split(" "));

		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting() ));
		System.out.println(map);

		list.stream().filter(i -> Collections.frequency(list, i) > 1).forEach(System.out::println);

	}

}
