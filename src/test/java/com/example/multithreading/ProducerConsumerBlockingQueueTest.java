package com.example.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import org.junit.Test;

public class ProducerConsumerBlockingQueueTest {

	@Test
	public void test() throws InterruptedException {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		ProducerConsumerBlockingQueue obj = new ProducerConsumerBlockingQueue(queue);
		
		Thread t1 = new Thread(() -> obj.producer());
		Thread t2 = new Thread(() -> obj.consumer());
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
	}
}
