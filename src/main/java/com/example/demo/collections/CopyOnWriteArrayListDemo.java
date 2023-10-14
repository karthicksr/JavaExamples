package com.example.demo.collections;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

	public static void main(String[] args) {
		List<String> list = new CopyOnWriteArrayList<>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");

		Iterator<String> iterator = list.iterator();
		// After iterator creation if we add element and then iterate list then new
		// items will not be displayed due to immutable list taken by iterator
		list.add("five");
		list.remove(0);
		while (iterator.hasNext()) {
			System.out.print(iterator.next()+"  ");
		}
		System.out.println("\n--------------------------");
		//While iterating if we try to add or set or remove operation the iterator wont take the change because of immutable. 
		for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
			String string = (String) iterator2.next();
			//list.add("six");
			
			System.out.print(string+"   ");
		}
		System.out.println("\n--------------------------");
		//If we try to use remove method while iterating the list we can get UnsupportedOperationException. 
		for (Iterator iterator2 = list.iterator(); iterator2.hasNext();) {
			String string = (String) iterator2.next();
			if(string.equals("two")) {
				iterator2.remove();
			}
			System.out.print(string+"   ");
		}
	}
}
