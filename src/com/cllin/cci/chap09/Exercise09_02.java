package com.cllin.cci.chap09;

import java.util.Arrays;
import java.util.Comparator;

import com.cllin.main.Exercise;

/*
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */

public class Exercise09_02 implements Exercise {
	private final String[][] testSuite = {
			{"abc", "pas", "ddj", "jbd", "sap", "cab", "bac"}
	};

	@Override
	public void runExercise() {
		for (String[] strings : testSuite) {
			System.out.println("Before sorting:");
			printStrings(strings);
			
			String[] sorted = sortByAnagrams(strings);
			
			System.out.println("After sorting:");
			printStrings(sorted);
		}
	}
	
	private static String[] sortByAnagrams(String[] strings) {
		AnagramComparator comparator = new AnagramComparator();
		
		for (int i = 0; i < strings.length; i++) {
			int numAnagrams = 0;
			for (int j = i + 1; j < strings.length; j++) {
				if (comparator.compare(strings[i], strings[j]) == 0) {
					numAnagrams++;
					swap(strings, i + numAnagrams, j);
				}
			}
		}
		
		return strings;
	}
	
	private static class AnagramComparator implements Comparator<String> {
		@Override
		public int compare(String o1, String o2) {
			String s1 = toSortedCharacters(o1);
			String s2 = toSortedCharacters(o2);
			return s1.compareTo(s2);
		}
		
		private static String toSortedCharacters(String input) {
			char[] output = input.toCharArray();
			Arrays.sort(output);
			return new String(output);
		}
	}
	
	private static void swap(String[] strings, int i, int j) {
		String tmp = strings[j];
		strings[j] = strings[i];
		strings[i] = tmp;
	}
	
	private static void printStrings(String[] strings){
		for (int i = 0; i < strings.length; i++) {
			System.out.println("\t" + strings[i]);
		}
		System.out.println("------------------------------");
	}
}
