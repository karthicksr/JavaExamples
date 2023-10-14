package com.example.demo.java8.iq;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.HashSet;

public class FindDuplicateElementDemo {

	public static void main(String[] args) {
		List<Integer> numbersList = Arrays.asList(10, 20, 30, 40, 10, 20, 88, 100, 88, 88, 90, 30);
		Set<Integer> numbersSet = new HashSet<>();
		// numbersList.stream().filter(x -> numbersSet.add(x))
		// .forEach(x -> System.out.println("Distinct elements of List :" + x));

		// To display the duplicate elements in the given List
		numbersList.stream().filter(x -> !numbersSet.add(x)).collect(Collectors.toSet())
				.forEach(x -> System.out.println("Duplicate elements in List:" + x));

		// Display duplicate words in the given string
		String words = "Hello Welcome to Java. Java is OO language. Java also support functional programming. Welcome again. Hello Karthick";
		String[] arrayWords = words.split(" ");
		Set<String> uniqueword = new HashSet<>();
		Stream<String> word = Stream.of(arrayWords);
		word.filter(x -> !uniqueword.add(x)).collect(Collectors.toSet())
				.forEach(x -> System.out.println("Duplicate words in String " + x));

	}
}
