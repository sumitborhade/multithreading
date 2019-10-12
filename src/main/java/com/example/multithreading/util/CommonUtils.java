package com.example.multithreading.util;

public class CommonUtils {

	public static void sleep(int wait) {
		try {
			Thread.sleep(wait);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
