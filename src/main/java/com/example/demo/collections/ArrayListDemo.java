package com.example.demo.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");

		Iterator<String> iterator = list.iterator();
		// After iterator creation if we add element and then iterate list then
		// ConcurrentModificationException will be thrown.
		// list.add("five");

		while (iterator.hasNext()) {
			String s = iterator.next();
			if (s.equals("four")) {
				iterator.remove();
			}
		}
		System.out.println(list);
	}
}
