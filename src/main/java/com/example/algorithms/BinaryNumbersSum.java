package com.example.algorithms;

public class BinaryNumbersSum {

	public static void main(String[] args) {
		String binaryNumberStringOne = "10101010";
		String binaryNumberStringTwo = "11001100";
		
		Long binaryNumberOne = Long.parseLong(binaryNumberStringOne, 2);
		Long binaryNumberTwo = Long.parseLong(binaryNumberStringTwo, 2);
		
		Long sum = binaryNumberOne + binaryNumberTwo;
		
		String stringBinarySum = Long.toBinaryString(sum);
		
		System.out.println("String Binary Sum : " + stringBinarySum);
		
	}
}
