package com.example.demo.collections;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		Map<Integer, String> treemap= new TreeMap<>();
		treemap.put(2, "two");
		treemap.put(1, "one");
		treemap.put(4, "four");
		treemap.put(5, "five");
		treemap.put(3, "three");
		treemap.put(6, "six");
		
		treemap.entrySet();
		for(Map.Entry<Integer, String> entry: treemap.entrySet()) {
			System.out.println("key -->"+entry.getKey()+"--- value-->"+entry.getValue());
		}
		
		Map<String, String> map= new TreeMap<>();
		map.put("one", "one");
		map.put("two", "two");
		map.put("three", "three");
		map.put("four", "four");
		map.put("five", "five");
		
		for(Map.Entry<String, String> entry: map.entrySet()) {
			System.out.println("key -->"+entry.getKey()+"--- value-->"+entry.getValue());
		}
	}
}
