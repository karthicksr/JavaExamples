package com.example.demo.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ArrayListDemo {
	public static void main(String args[]) {
		
		//List with default size
		List<String> strings=new ArrayList<>(20);
		strings.add("one");strings.add("two");strings.add("three");strings.add("four");strings.add("five");strings.add("six");
		//displaying the size of the list
		System.out.println("Size of the String list-->"+strings.size());
		//displaying the elements one by one
		strings.stream().forEach(System.out::println);

		//Constructor accepting Collection
		Collection<Integer> numbers = IntStream.range(0, 10).boxed().collect(Collectors.toSet());
		List<Integer> list = new ArrayList<>(numbers);
		list.stream().forEach(System.out::print);
		
		//To make list as read only by calling unmodifableList method in Collections class. 
		list = Collections.unmodifiableList(list);
		list.add(11);
		list.stream().forEach(System.out::print);
		
	}
}
