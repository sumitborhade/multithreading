package com.test.multithreading;

import org.junit.Test;

public class DeadlockTest {

	@Test
	public void test() throws InterruptedException {
		Deadlock obj = new Deadlock();
		Thread t1 = new Thread(() -> obj.producer(), "T1");
		Thread t2 = new Thread(() -> obj.consumer(), "T2");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}

class Deadlock {
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	public void producer() {
		synchronized (lock1) {
			System.out.println(threadName() + " has acquired lock1.");
			sleep(2000);
			synchronized (lock2) {
				System.out.println(threadName() + " has acquired lock2.");
				System.out.println("In P");
			}
		}
	}
	
	public void consumer() {
		synchronized (lock1) {
			System.out.println(threadName() + " has acquired lock2.");
			synchronized (lock2) {
				System.out.println(threadName() + " has acquired lock1.");
				System.out.println("In C");
			}
		}
	}
	
	private static void sleep(int wait) {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static String threadName() {
		return Thread.currentThread().getName();
	}
}