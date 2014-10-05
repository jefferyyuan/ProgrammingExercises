package com.cllin.cci.chap11;

import java.util.ArrayList;
import java.util.HashSet;

import com.cllin.main.Exercise;

public class Exercise11_03 implements Exercise {

	private final int SIZE = 1000;
	private int[] numbers;

	private HashSet<Integer> reference;
	private ArrayList<Integer> missingIntegers;
	
	@Override
	public void run() {
		initizalize();
		missingIntegers = findMissingIntegers(numbers);
		
		test();
	}
	
	private static ArrayList<Integer> findMissingIntegers(int[] numbers) {
		ArrayList<Integer> missing = new ArrayList<Integer>();
		byte[] map = new byte[1000];
		
		for (int i = 0; i < numbers.length; i++) {
			map[numbers[i]] = 1;
		}
		
		for (int i = 0; i < map.length; i++) {
			if (map[i] == 0) {
				missing.add(i);
			}
		}
		
		return missing;
	}
	
	private void initizalize() {
		numbers = new int[SIZE];
		reference = new HashSet<Integer>();
		
		HashSet<Integer> contains = new HashSet<Integer>();
		
		for (int i = 0; i < SIZE; i++) {
			int n = (int) (Math.random() * SIZE);
			numbers[i] = n;
			contains.add(n);
			reference.add(i);
		}
		
		reference.removeAll(contains);
	}
	
	private void test() {
		if (reference.size() != missingIntegers.size()) {
			System.out.println("Failed");
			return;
		}
		
		for (int n : missingIntegers) {
			if (!reference.contains(n)) {
				System.out.println("Failed");
				return;	
			}
		}
		
		System.out.println("Missing integers:");
		for (int n : missingIntegers) {
			System.out.printf("    %d%n", n);
		}
		
		System.out.println("Success!");
	}

}
