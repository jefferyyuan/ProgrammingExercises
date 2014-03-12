package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.cllin.main.LeetCodeExercise;

public class Anagrams implements LeetCodeExercise {
	
	private final String[][] testSuite = {
			{"army", "apple", "mary"},
			{"ape", "and", "cat"}
	};
	
	private int index;
	ArrayList<String> anagrams;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			anagrams = anagrams(testSuite[index]);
			test();
		}
	}
	
	private ArrayList<String> anagrams(String[] strings) {
		ArrayList<String> anagrams = new ArrayList<String>();
		HashMap<String, ArrayList<Integer>> counts = new HashMap<String, ArrayList<Integer>>();
		
		if (strings == null || strings.length == 0) return anagrams;
		
		int length = strings.length;
		for (int i = 0; i < length; i++) {
			String sorted = sort(strings[i]);
			ArrayList<Integer> list = counts.get(sorted);
			
			if (list == null)
				list = new ArrayList<Integer>();
			
			list.add(i);
			counts.put(sorted, list);
		}
		
		for (String key : counts.keySet()) {
			ArrayList<Integer> list = counts.get(key);
			
			if (list.size() > 1) {
				for (int index : counts.get(key)) {
					anagrams.add(strings[index]);
				}
			}
		}
		
    	return anagrams;
    }
	
	private String sort(String string) {
		if (string == null) return null;
		
		char[] array = string.toCharArray();
		Arrays.sort(array);
		
		return new String(array);
	}

	@Override
	public boolean test() {
		System.out.print("For the strings { ");
		for (String string : testSuite[index]) System.out.printf("%s ", string);
		System.out.print("}, the anagram sets are:\n");
		
		for (String string : anagrams) {
			System.out.printf("%s ", string);
		}
		
		System.out.println();
		
		return true;
	}
}
