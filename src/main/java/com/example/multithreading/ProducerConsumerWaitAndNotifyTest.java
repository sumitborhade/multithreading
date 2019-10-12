package com.example.multithreading;

import java.util.Random;

import org.junit.Test;

public class ProducerConsumerWaitAndNotifyTest {

	@Test
	public void test() throws InterruptedException {
		ProducerConsumerWaitAndNotify obj = new ProducerConsumerWaitAndNotify();
		
		Thread t1 = new Thread(() -> obj.producer(), "T1");
		Thread t2 = new Thread(() -> obj.consumer(), "T2");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}

class ProducerConsumerWaitAndNotify {

	volatile int number = -9;

	public synchronized void producer() {
		while(true) {
			try {
				Random random = new Random();
				number = random.nextInt(11);
				System.out.println(number + " has been assigned.");
				notify();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void consumer() {
		while (true) {
			try {
				if(number != -9) {
					System.out.println(number + " has been read");
					sleep(2000);
				}
				notify();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
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
}