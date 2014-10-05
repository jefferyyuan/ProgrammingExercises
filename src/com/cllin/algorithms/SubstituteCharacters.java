package com.cllin.algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Given a hashmap M which is a mapping of characters to arrays of substitute characters, 
 * and an input string S, return an array of all possible mutations of S 
 * (where any character in S can be substituted with one of its substitutes in M, if it exists). 
 * 
 * What is the time complexity? What is the space complexity? Can you optimize either?
 * 
 * Example input:
 * 		M = { f: [F, 4], b: [B, 8] }
 * 		S = fab
 * 
 * Expected output:
 * 		[fab, Fab, 4ab, faB, FaB, 4aB, fa8, Fa8, 4a8]
 * 
 * Source: http://www.careercup.com/question?id=15419952
 */

public class SubstituteCharacters implements Exercise {

	private int index;
	private ArrayList<TestCase> testSuite;
	private ArrayList<String> output;
	
	@Override
	public void run() {
		initialize();
		for (index = 0; index < testSuite.size(); index++) {
			output = getSubstitute(testSuite.get(index).map, testSuite.get(index).string);
			test();
		}
	}
	
	private ArrayList<String> getSubstitute(HashMap<Character, ArrayList<Character>> map, String string) {
		ArrayList<String> queue = new ArrayList<String>();
		ArrayList<String> next = new ArrayList<String>();
		queue.add(new String());
		
		for (int i = 0; i < string.length(); i++) {
			for (String s : queue) {
				next.add(new String(s + string.charAt(i)));
				if (map.containsKey(string.charAt(i))) {
					for (char c : map.get(string.charAt(i))) {
						next.add(new String(s + c));
					}
				}
			}
			
			queue = next;
			next = new ArrayList<String>();
		}
		
		return queue;
	}

	private void initialize() {
		testSuite = new ArrayList<TestCase>();
		
//		Case 1
		TestCase case1 = new TestCase("fab");
		case1.buildMap('f', new char[]{'F', '4'});
		case1.buildMap('b', new char[]{'B', '8'});
		testSuite.add(case1);
		
	}
	
	private void test() {
		TestCase test = testSuite.get(index);
		
		System.out.print("Map = { ");
		for (char key : test.map.keySet()) {
			System.out.printf("%c: [ ", key);
			
			for (char substitude : test.map.get(key)) {
				System.out.printf("%c ", substitude);
			}
			System.out.print("] ");
		}
		System.out.printf("}%n");
		
		System.out.print("Output = { ");
		for (String string : output) {
			System.out.printf("%s ", string);
		}
		System.out.printf("}%n");
	}
	
	private class TestCase {
		HashMap<Character, ArrayList<Character>> map;
		String string;
		
		TestCase(String string) {
			map = new HashMap<Character, ArrayList<Character>>();
			this.string = string;
		}
		
		void buildMap(char c, char[] substitutes) {
			ArrayList<Character> s = new ArrayList<Character>();
			for (char substitute : substitutes) {
				s.add(substitute);
			}
			
			this.map.put(c, s);
		}
	}
}
