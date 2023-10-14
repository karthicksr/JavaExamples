package com.example.demo.threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutor {

	// Main driver method
	public static void main(String[] args) {
		// Creating objects of CountDownLatch class
		CountDownLatch cd1 = new CountDownLatch(5);
		CountDownLatch cd2 = new CountDownLatch(5);
		CountDownLatch cd3 = new CountDownLatch(5);
		CountDownLatch cd4 = new CountDownLatch(5);

		// Creating objects of ExecutorService class
		ExecutorService es = Executors.newFixedThreadPool(2);

		// Display message only for better readability
		System.out.println("Starting");

		// Executing the tasks
		es.execute(new MyThreadDemo(cd1, "A"));
		es.execute(new MyThreadDemo(cd2, "B"));
		es.execute(new MyThreadDemo(cd3, "C"));
		es.execute(new MyThreadDemo(cd4, "D"));

		// Try block to check for exceptions
		try {

			// Waiting for tasks to complete
			cd1.await();
			cd2.await();
			cd3.await();
			cd4.await();
		}

		// Catch block to handle exceptions
		catch (InterruptedException e) {

			System.out.println(e);
		}

		// Making all current executing threads to terminate
		es.shutdown();

		// Display message only for better readability
		System.out.println("Done");
	}
}

