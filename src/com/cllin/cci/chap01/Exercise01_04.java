package com.cllin.cci.chap01;

import java.util.HashMap;
import java.util.Map;

import com.cllin.main.Exercise;

public class Exercise01_04 implements Exercise {

	@Override
	public void runExercise() {
		String mary = "mary";
		String army = "army";
		String on = "on";
		String no = "no";
		
		printResult(areAnagrams(army, mary), army, mary);
		printResult(areAnagrams(on, no), on, no);
	}
	
	private boolean areAnagrams(String s1, String s2){
		if (s1.length() != s2.length()) return false;
		
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		
		HashMap<Character, Integer> count1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> count2 = new HashMap<Character, Integer>();

		int length = s1.length();
		for(int i = 0; i < length; i++){
			char char1 = s1.charAt(i);
			char char2 = s2.charAt(i);
			
			if(count1.containsKey(char1)){
				count1.put(char1, count1.get(char1) + 1);
			}else{
				count1.put(char1, 1);
			}
			
			if(count2.containsKey(char2)){
				count2.put(char2, count2.get(char2) + 1);
			}else{
				count2.put(char2, 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry : count1.entrySet()){
			if (!count2.containsKey(entry.getKey())) return false;
			if (count2.get(entry.getKey()) != entry.getValue()) return false;
		}	
		
		return true;
	}
	
	private void printResult(boolean result, String s1, String s2){
		if(result) System.out.printf("%s and %s are anagrams%n", s1, s2);
		else System.out.printf("%s and %s are not anagrams%n", s1, s2);
	}

}
