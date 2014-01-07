package com.cllin.chap9;

import java.util.Arrays;
import java.util.Comparator;

import com.cllin.main.Exercise;

public class Exercise09_02 implements Exercise {
	private final String[] strings = {"abc", "pas", "ddj", "jbd", "sap", "cab"};

	@Override
	public void runExercise() {
		System.out.println("Before sorting:");
		printStrings();
		
		AnagramComparator comparator = new AnagramComparator();
		int length = strings.length;
		for(int i = 0; i < length; i++){
			int numAnagrams = 0;
			for(int j = i + 1; j < length; j++){
				if(comparator.compare(strings[i], strings[j]) == 0){
					numAnagrams++;
					swap(i + numAnagrams, j);
				}
			}
		}
		
		System.out.println("After sorting:");
		printStrings();
	}
	
	private void swap(int i, int j){
		String tmp = strings[j];
		strings[j] = strings[i];
		strings[i] = tmp;
	}
	
	private void printStrings(){
		int length = strings.length;
		for(int i = 0; i < length; i++){
			System.out.println("\t" + strings[i]);
		}
	}
	
	private class AnagramComparator implements Comparator<String>{
		
		private String toSortedCharacters(String input){
			char[] output = input.toCharArray();
			Arrays.sort(output);
			return new String(output);
		}

		@Override
		public int compare(String o1, String o2) {
			String s1 = toSortedCharacters(o1);
			String s2 = toSortedCharacters(o2);
			return s1.compareTo(s2);
		}
		
	}

}
