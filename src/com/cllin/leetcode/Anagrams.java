package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

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
		
		if (strings == null || strings.length == 0) return anagrams;
		
		int length = strings.length;
		for (int i = 0; i < length; i++) {
			boolean existAnagram = false;
			
			for (int j = i + 1; j < length; j++) {
				if (isAnagram(strings[i], strings[j])) {
					anagrams.add(strings[j]);
					
					if (!existAnagram) {
						anagrams.add(strings[i]);
						existAnagram = true;
					}
				}
			}
		}
		
    	return anagrams;
    }
	
	private boolean isAnagram(String s1, String s2) {
		if (s1 == null || s2 == null) return false;
		if (s1.length() != s2.length()) return false;
		
		int length = s1.length();
		HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
		
		for (int i = 0; i < length; i++) {
			char key = s1.charAt(i);
			if (counts.containsKey(key)) counts.put(key, counts.get(key) + 1);
			else counts.put(key, 1);
		}
		
		for (int i = 0; i < length; i++) {
			char key = s2.charAt(i);
			
			if (counts.containsKey(key)) counts.put(key, counts.get(key) - 1);
			else return false;
			
			if (counts.get(key) == 0) counts.remove(key);
		}
		
		return (counts.size() == 0);
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
