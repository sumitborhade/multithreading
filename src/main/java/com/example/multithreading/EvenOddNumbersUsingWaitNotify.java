package com.example.multithreading;

import com.example.multithreading.util.CommonUtils;

public class EvenOddNumbersUsingWaitNotify {

	//It is used to read directly from memory and not from cache
	private volatile int i = 1;
	
	public void performCalculations () {
		synchronized (this) {
			while(true) {
				try {
					System.out.println(Thread.currentThread().getName() + " i :: "+ i);
					i++;
					notify();
					wait();
					CommonUtils.sleep(1000);
//					System.out.println("Completed producer :: " + Thread.currentThread().getName() + "\n\n");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

