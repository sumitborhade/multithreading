package com.example.algorithms;

public class Pangram {

	public static void main(String[] args) {
		String input = "The quick brown fox jumps over the lazy dog";
		String output = pangramOutput(input);
		System.out.println(output);
	}
	
	public static String pangramOutput(String input) {
		String alphabets = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder rawOutput = new StringBuilder("");
		
		if(input != null) {
			for (int i = 0; i < alphabets.length(); i++) {
				char character = alphabets.charAt(i);
				
				if(!input.toLowerCase().contains(String.valueOf(character))) {
					rawOutput.append(character);
				}
			}
		}
		
		if(rawOutput.toString().equals("")) {
			rawOutput = new StringBuilder("NULL");
		}
		
		return rawOutput.toString();
	}
}
