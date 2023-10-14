package com.example.demo.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HashSetDemo {
	public static void main(String args[]) {
		Set<String> set=new HashSet<>();
		set.add(null);
		set.add("one");
		set.add("two");
		set.add("three");
		set.add("four");
		set.add("five");
		set.add("five");
		
		//Iterate elements using for-each 
		for (String string : set) {
			System.out.print(""+string+" ");
		}
		System.out.println("");
		//Iterate elements using Iterator
		for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.print(""+string+" ");
			//if we try to add element while iterating it throws ConcurrentModificationException at runtime. 
			//set.add("ten");
		}
		System.out.println("");
		//Iterate elements using foreach method
		set.forEach(System.out::print);
		
		System.out.println("");
		//contains method in set
		if(set.contains("two")) {
			System.out.println("set contain operations work");
		}
		
		
		//remove method in set
		Predicate<String> predicate=a->(a=="one");
		set.removeIf(predicate);
		System.out.println("");
		set.forEach(System.out::print);
		System.out.println("");
		System.out.println("Stream method on Set class");
		
		//Use stream method to convert into stream and then apply filter logic to filter contents and display the elements
		set.stream().filter(a->a!="two").collect(Collectors.toSet()).forEach(System.out::print);
		
	}

}
