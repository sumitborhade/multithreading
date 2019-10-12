package com.example.multithreading;

import java.util.Random;

import com.example.multithreading.util.CommonUtils;

public class ProducerConsumerWaitAndNotify {

	volatile int number = -9;

	public synchronized void producer() {
		while(true) {
			try {
				Random random = new Random();
				number = random.nextInt(11);
				System.out.println(number + " has been assigned.");
				notify(); // Notifies another thread to acquire the lock
				wait(); // Current thread goes in to waiting state
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
					CommonUtils.sleep(2000);
				}
				notify(); // Notifies another thread to acquire the lock
				wait(); // Current thread goes in to waiting state
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}