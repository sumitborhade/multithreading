package com.example.algorithms;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.Test;

public class StreamClass {

	public void method1() {
		String value = IntStream.range(1, 10)
			.mapToObj( n -> String.valueOf(n))
			.collect(Collectors.joining(", "));
		System.out.println(value);
	}
	
	@Test
	public void test() {
		StreamClass test = new StreamClass();
		test.method1();
	}
}