package com.example.demo.collections;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentArrayListDemo {
	static List<String> l = new CopyOnWriteArrayList<String>();

	public void run() {
		// Child thread trying to
		// add new element in the
		// Collection object
		l.add("D");
	}

	public static void main(String[] args) throws InterruptedException {
		l.add("A");
		l.add("B");
		l.add("c");

		// We create a child thread
		// that is going to modify
		// ArrayList l.
		ConcurrentArrayListDemo t = new ConcurrentArrayListDemo();
		t.run();

		Thread.sleep(1000);

		
		Iterator<String> itr = l.iterator();
		while (itr.hasNext()) {
			String s = itr.next();
			System.out.println(s);
			//Thread.sleep(1000);
		}
		System.out.println(l);
	}
}
