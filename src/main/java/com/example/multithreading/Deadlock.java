package com.example.multithreading;

import com.example.multithreading.util.CommonUtils;

/**<b>Situation</b>:<br/>
 * Deadlock occurs when Thread-A holds lock 1 and waits for lock 2.<br/>
 * At the same time, Thread-B holds lock 2 and waits for lock 1.<br/>
 * <br/><br/>
 * <b>Detection</b>:<br/>
 * 1. For windows, go to task bar and find the process id of the program <br/>
 * 2. For unix, ps -ef | grep {process description} or lsof -i:{port} to get the pid<br/>
 * 3. {JAVA_HOME}\bin\jstack {pid}<br/>
 * 4. Console will print the details <br/>
 * <br/><br/>
 * <b>Solution</b>:<br/>
 * Ordering of the locks is important.<br/>
 * 
 */
public class Deadlock {
	Object lock1 = new Object();
	Object lock2 = new Object();
	
	public void producer() {
		synchronized (lock1) {
			System.out.println(threadName() + " has acquired lock1.");
			CommonUtils.sleep(2000);
			synchronized (lock2) {
				System.out.println(threadName() + " has acquired lock2.");
				System.out.println("In P");
			}
		}
	}
	
	public void consumer() {
		synchronized (lock2) {
			System.out.println(threadName() + " has acquired lock2.");
			synchronized (lock1) {
				System.out.println(threadName() + " has acquired lock1.");
				System.out.println("In C");
			}
		}
	}
	
	private static String threadName() {
		return Thread.currentThread().getName();
	}
}