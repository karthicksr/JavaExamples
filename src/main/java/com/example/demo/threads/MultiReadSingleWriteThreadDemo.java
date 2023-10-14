package com.example.demo.threads;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

//Ref link:  https://www.java-success.com/java-scenarios-based-interview-questions-answers/?gclid=CjwKCAiA-8SdBhBGEiwAWdgtcIDQtJoB3S9DAyAF8OVun_lUdHerPZDOJBbB9N8g2wMwYxt4yTeXjhoCSiUQAvD_BwE

/*Scenario: You need to load stock exchange security codes from a database and cache them for performance. 
The security codes need to be refreshed say every 30 minutes. This cached data needs to be populated and 
refreshed by a single writer thread and read by several reader threads. 
How will you ensure that your read/write solution is scalable and thread safe?*/

/*Solution: The java.util.concurrent.locks package provides classes that implement read/write locks where the read lock can be executed in parallel 
by multiple threads and the write lock can be held by only a single thread. 
The ReadWriteLock interface maintains a pair of associated locks, one for read-only and one for writing. 
The readLock( ) may be held simultaneously by multiple reader threads, while the writeLock( ) is exclusive*/

public class MultiReadSingleWriteThreadDemo {

	public static void main(String args[]) {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		Map<String, BigDecimal> map = new HashMap<>();
		ReadWriteLock lock = new ReentrantReadWriteLock();

		executor.submit(() -> {
			lock.writeLock().lock();
			System.out.println("Writing .....");
			try {
				try {
					TimeUnit.SECONDS.sleep(3); // emulating update
				} catch (Exception e) {
					e.printStackTrace();
				}
				map.put("stock-ABC", BigDecimal.valueOf(12.35));
			} finally {
				lock.writeLock().unlock();
			}
		});

		Runnable readTask = () -> {
			lock.readLock().lock();
			try {
				System.out.println("Reading ....." + map.get("stock-ABC"));
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} finally {
				lock.readLock().unlock();
			}
		};

		// multiple reads
		executor.submit(readTask);
		executor.submit(readTask);

		// ...............other code. As it keeps running.
		// executor.shutdown();
	}

}
