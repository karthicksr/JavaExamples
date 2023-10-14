package com.example.demo.threads;

import java.util.concurrent.CountDownLatch;

//Helper class
class MyThreadDemo implements Runnable {

	// Class data members
	String name;
	CountDownLatch latch;

	// Constructor
	MyThreadDemo(CountDownLatch latch, String name) {

		// this keyword refers to current instance itself
		this.name = name;
		this.latch = latch;

		new Thread(this);
	}

	// Method
	// Called automatically when thread is started
	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + i);
			latch.countDown();
		}
	}
}