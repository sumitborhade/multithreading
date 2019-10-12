package com.example.multithreading;

import org.junit.Test;

public class EvenOddNumbersUsingWaitNotifyTest {

	@Test
	public void test() throws InterruptedException {
		EvenOddNumbersUsingWaitNotify wn = new EvenOddNumbersUsingWaitNotify();
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
