package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

import com.cllin.main.LeetCodeExercise;

public class WordBreakII implements LeetCodeExercise {

	private int index;
	private ArrayList<TestCase> testSuite;
	
	private ArrayList<String> solutions;
	
	@Override
	public void initialize() {
		testSuite = new ArrayList<TestCase>();
		String string;
		HashSet<String> dictionary;
		
//		CASE 0
		string = "catsanddog";
		dictionary = new HashSet<String>();
		dictionary.add("cat");
		dictionary.add("cats");
		dictionary.add("and");
		dictionary.add("sand");
		dictionary.add("dog");
		
		testSuite.add(new TestCase(string, dictionary));
		
//		CASE 1
		string = "aaaaaaa";
		dictionary = new HashSet<String>();
		dictionary.add("aaaa");
		dictionary.add("aa");
		
		testSuite.add(new TestCase(string, dictionary));

//		CASE 2
		string = "bb";
		dictionary = new HashSet<String>();
		dictionary.add("a");
		dictionary.add("b");
		dictionary.add("bbb");
		dictionary.add("bbbb");
		
		testSuite.add(new TestCase(string, dictionary));
	}

	@Override
	public void runExercise() {
		initialize();
		for (index = 0; index < testSuite.size(); index++) {
			TestCase test = testSuite.get(index);
			solutions = wordBreak(test.string, test.dictionary);
			
			test();
		}
	}
	
	private ArrayList<String> wordBreak(String string, Set<String> dictionary) {
		ArrayList<String> solutions = new ArrayList<String>();
		if (string == null || string.length() == 0 || dictionary == null || dictionary.isEmpty()) {
			return solutions;
		}
		
		Hashtable<String, Integer> queue = new Hashtable<String, Integer>();
		Hashtable<String, String> solution = new Hashtable<String, String>();
		
		int index = 0;
		while (index <= string.length()) {
			String word = string.substring(0, index);
			if (dictionary.contains(word)) {
				queue.put(word, index);
				solution.put(word, word);
			}
			
			Set<String> keys = queue.keySet();
			for (String key : keys) {
				int start = queue.get(key);
				String candidate = word.substring(start, index);
				
				if (dictionary.contains(candidate)) {
					solution.put(key, solution.get(key) + " " + candidate);
					queue.put(key, index);
				}
			}
			
			index++;
		}
		
		Set<String> keys = solution.keySet();
		for (String key : keys) {
			String s = solution.get(key);
			if (s.replaceAll(" ", "").equals(string)) {
				solutions.add(solution.get(key));
			}
		}
		
		return solutions;
    }

	@Override
	public boolean test() {
		TestCase test = testSuite.get(index);
		
		System.out.printf("S = %s%n", test.string);
		System.out.print("Dictionary = { ");
		for (String word : test.dictionary) {
			System.out.printf("%s ", word);
		}
		System.out.print("}\n");
		

		System.out.print("Solution = {\n");
		for (String solution : solutions) {
			System.out.printf("    %s%n", solution);
		}
		System.out.print("}\n");
		System.out.println("------------------");
		
		return true;
	}
	
	private class TestCase {
		private String string;
		private Set<String> dictionary;
		
		TestCase (String string, Set<String> dictionary) {
			this.string = string;
			this.dictionary = dictionary;
		}
	}

}
