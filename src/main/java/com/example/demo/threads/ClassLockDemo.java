package com.example.demo.threads;

public class ClassLockDemo implements Runnable {
	// Method 1
	// @Override
	public void run() {
		Lock();
	}

	// Method 2
	// Method is static
	public static synchronized void Lock() {
		// Getting the name of current thread by using
		// getName() method to get name of the thread and
		// currentThread() to get the current thread
		System.out.println(Thread.currentThread().getName());

		// class level lock
		synchronized (ClassLockDemo.class) {
			System.out.println("in block " + Thread.currentThread().getName());
			System.out.println("in block " + Thread.currentThread().getName() + " end");
		}
	}

	// Method 3
	// Main driver method
	public static void main(String[] args) {
		// Creating an object of above class
		// in the main() method
		ClassLockDemo g1 = new ClassLockDemo();

		// Sharing the same object across two Threads

		// Creating an object of thread class where
		// t1 takes g1
		Thread t1 = new Thread(g1);

		// Creating an object of thread class where
		// t2 takes g1
		Thread t2 = new Thread(g1);

		// Creating second object of above class
		// in the main() method
		ClassLockDemo g2 = new ClassLockDemo();

		// Creating an object of thread class where
		// t3 takes g2
		Thread t3 = new Thread(g2);

		// setName() method is used to set name to the
		// thread
		t1.setName("t1");
		t2.setName("t2");
		t3.setName("t3");

		// start() method is used for initiating the current
		// thread
		t1.start();
		t2.start();
		t3.start();
	}
}
