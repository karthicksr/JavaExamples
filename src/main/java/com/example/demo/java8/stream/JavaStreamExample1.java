package com.example.demo.java8.stream;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.demo.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class JavaStreamExample1 {

	public static void main(String args[]) {

		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 29000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		productsList.add(new Product(6, "HP Laptop", 25500f));

		// Filters data with condition and return the filtered data
		// Using lambda to filter data
		Stream<Product> filtered_data = productsList.stream().filter(p -> p.price > 25000);

		// Iterate using Lambda
		filtered_data.forEach(product -> System.out.println(product.name + ":" + product.price));

		List<Float> productPriceList = productsList.stream().filter(p -> p.price > 25000).map(p -> p.price)
				.collect(Collectors.toList());
		productPriceList.forEach(p -> System.out.print("Price is " + p));

		// Remove duplicates using Stream
		System.out.println("\nDistinct elements of name in the list ");
		productsList.stream().map(x -> x.name).distinct().forEach(System.out::print);

		// Collectors Summingup
		Double sumPrices = productsList.stream().collect(Collectors.summingDouble(x -> x.price)); // collecting as list
		System.out.println("\nSum of prices: " + sumPrices);

		Integer sumId = productsList.stream().collect(Collectors.summingInt(x -> x.id));
		System.out.println("Sum of id's: " + sumId);

		// To find out average in the given list
		System.out.println(
				"Average of Price -->" + productsList.stream().collect(Collectors.averagingDouble(p -> p.price)));

		// To find out min of value from the list using maxBy method in Collectors class
		System.out.println("Minimum Price-->"
				+ productsList.stream().map(p -> p.price).collect(Collectors.minBy(Comparator.reverseOrder())).get());

		// To find out max of value from the list using maxBy method in Collectors class
		System.out.println("Maximum Price-->"
				+ productsList.stream().map(p -> p.price).collect(Collectors.maxBy(Comparator.naturalOrder())).get());

		// To find out min of value from the list using min method of stream
		System.out.println(
				"Minimum Price-->" + productsList.stream().map(x -> x.price).min((i1, i2) -> i1.compareTo(i2)).get());

		// To find out max of value from the list using max method of stream
		System.out.println(
				"Maximum Price-->" + productsList.stream().map(x -> x.price).max((i1, i2) -> i1.compareTo(i2)).get());
		
		

		// Sorting the elements in natural order
		System.out.println("Sorting elements in natural order");
		productsList.stream().map(p -> p.name).sorted().collect(Collectors.toList()).forEach(System.out::print);

		// Sorting the elements in Descending order
		System.out.println("\nSorting elements in descending order");
		productsList.stream().map(p -> p.name).sorted((i1, i2) -> i2.compareTo(i1)).collect(Collectors.toList())
				.forEach(System.out::print);

		// Grouping by name using groupingby method in Collectors class
		Map<String, Long> result = productsList.stream().map(p -> p.name)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(result);

		// Intermediate and Terminal operations
		Stream<Float> intermediateStream = productsList.stream().map(x -> x.price).filter(x -> x > 25000).map(x -> {
			System.out.println("Inside map method");
			return x;
		});

		// Terminal operation which will return nothing. If we comment below line then
		// above message wont be called.
		intermediateStream.forEach(x -> System.out.println(" at end :" + x));

		// Intermediate short circuit opeations. limit() method
		System.out.println("Short circuit operation Limit method: " + productsList.stream().limit(5).count());
		
		//Terminal short circuit operations. findFirst(), findAny(), allMatch(), anyMatch(), noneMatch()
		//findFirst() method
		System.out.println("Terminal Short circuit operation findFirst method :"+productsList.stream().map(x -> x.name).filter(x -> x.contains("Laptop")).findFirst().get());
		
		//findAny() method
		System.out.println("Terminal Short circuit operation findAny method :"+productsList.parallelStream().map(x -> x.name).filter(x -> x.contains("Laptop")).findAny().get());
		
		//allMatch() method
		System.out.println("Terminal Short circuit operation allMatch method :"+productsList.stream().map(x -> x.name).allMatch(x -> x.contains("Laptop")));
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
		String commaSeparatedNumbers = numbers.stream().map(i -> i.toString())
				.collect(Collectors.joining(",", "{", "}"));
		System.out.println("Joining String-->" + commaSeparatedNumbers);

		StringJoiner joiner = new StringJoiner(",", "[", "]");
		joiner.add("Hello");
		joiner.add("Welcome");
		joiner.add("to Learn Java");
		System.out.println("String joiner example -->" + joiner);

		String s1 = "xxx ", s2 = "abc ", s3 = "xyz ";
		System.out.println(s1.trim() + s2.trim() + s3.trim());
	}
}