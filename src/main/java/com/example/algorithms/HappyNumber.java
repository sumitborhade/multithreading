package com.example.algorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static boolean isHappyNumber(int number) {
		Set<Integer> nonRepeatingValueSet = new HashSet<Integer>();

		while (nonRepeatingValueSet.add(number)) {
			int value = 0;
			while (number > 0) {
				value += Math.pow(number % 10, 2);
				number /= 10;
			}
			number = value;
		}

		return number == 1;
	}

	public static void main(String[] args) throws IOException {
	    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
	    BufferedReader in = new BufferedReader(reader);
	    String line;
	    while ((line = in.readLine()) != null) {
	      int number = Integer.parseInt(line);
	      isHappyNumber(number);
	      
	      System.out.println(isHappyNumber(number) ? "1" : "0");
	      
	    }
	  }
}
