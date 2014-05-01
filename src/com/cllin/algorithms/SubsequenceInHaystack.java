package com.cllin.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Given two strings, a haystack and a needle, 
 * return the number of subsequences of haystack that is in the same order as the needle.
 */

public class SubsequenceInHaystack implements Exercise {

	private String haystack = "cciatatcgatctta";
	private String needle = "cat";
	
	@Override
	public void runExercise() {
		int numValid = getCount(haystack, needle);
		
		System.out.printf("There are %d valid subsequences for:%nH = %s%nN = %s", numValid, haystack, needle);
	}

	private int getCount(String haystack, String needle) {
		HashMap<Character, ArrayList<Integer>> indices = new HashMap<Character, ArrayList<Integer>>();
		HashSet<Character> characters = new HashSet<Character>();
		
		for (char c : needle.toCharArray()) {
			characters.add(c);
		}
		
		for (int i = 0; i < haystack.length(); i++) {
			char c = haystack.charAt(i);
			if (characters.contains(c)) {
				ArrayList<Integer> count = (indices.containsKey(c))? indices.get(c) : new ArrayList<Integer>();
				count.add(i);
				indices.put(c, count);
			}
		}
		
		return count(indices, haystack, needle, 0, -1);
	}

	private int count(HashMap<Character, ArrayList<Integer>> indices, String haystack, String needle, int i, int last) {
		int numValid = 0;
		char c = needle.charAt(i);
		
		if (i == needle.length() - 1) {
			for (int index : indices.get(c)) {
				if (index > last) {
					numValid++;
				}
			}
			
			return numValid;
		}

		for (int index : indices.get(c)) {
			if (index > last) {
				numValid += count(indices, haystack, needle, i + 1, index);
			}
		}
		
		return numValid;
	} 
	
}
