package com.example.multithreading;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

import com.example.multithreading.util.CommonUtils;

public class ProducerConsumerBlockingQueue {
	
	Random random = new Random();
	BlockingQueue<Integer> queue;
	
	public ProducerConsumerBlockingQueue(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	public void producer() {
		while(true) {
			int number = random.nextInt(100);
			queue.add(number);
			System.out.println(number + " has been added.");
			CommonUtils.sleep(1000);
		}
		
	}
	
	public void consumer() {
		while(true) {
			if (queue.isEmpty()) {
				try {
					System.out.println(queue.take() + " has been read.");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
