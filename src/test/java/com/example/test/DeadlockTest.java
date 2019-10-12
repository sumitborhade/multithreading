package com.example.test;

import org.junit.Test;

import com.example.multithreading.Deadlock;

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