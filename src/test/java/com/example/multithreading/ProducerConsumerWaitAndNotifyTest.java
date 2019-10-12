package com.example.multithreading;

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
