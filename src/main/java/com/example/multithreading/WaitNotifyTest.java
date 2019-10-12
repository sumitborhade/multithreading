package com.example.multithreading;

public class WaitNotifyTest {

	public static void main(String[] args) throws InterruptedException {
		
		WaitNotify wn = new WaitNotify();
		Thread t1 = new Thread(() -> wn.performCalculations());
		Thread t2 = new Thread(() -> wn.performCalculations());

		t1.setName("T1");
		t2.setName("T2");

		t1.start();
		t2.start();

		t1.join();
		t2.join();
	}
}

class WaitNotify {

	volatile int i = 1;
	
	public void performCalculations () {
		synchronized (this) {
			while(true) {
				try {
					System.out.println(Thread.currentThread().getName() + " i :: "+ i);
					i++;
					notify();
					wait();
					sleep(1000);
//					System.out.println("Completed producer :: " + Thread.currentThread().getName() + "\n\n");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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