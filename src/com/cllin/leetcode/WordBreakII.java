package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a string s and a dictionary of words dictionary, 
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 * 
 * Return all such possible sentences.
 * 
 * For example, given
 * s = "catsanddog",
 * dictionary = ["cat", "cats", "and", "sand", "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * Source: http://oj.leetcode.com/problems/word-break-ii/
 */

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
		
//		CASE 3
		string = "aaaaaaa";
		dictionary = new HashSet<String>();
		dictionary.add("aaaa");
		dictionary.add("aaa");
		
		testSuite.add(new TestCase(string, dictionary));
		
//		CASE 4
		string = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
		dictionary = new HashSet<String>();
		
		dictionary.add("aaaaaaaaaa");
		dictionary.add("aaaaaaaaa");
		dictionary.add("aaaaaaaa");
		dictionary.add("aaaaaaa");
		dictionary.add("aaaaaa");
		dictionary.add("aaaaa");
		dictionary.add("aaaa");
		dictionary.add("aaa");
		dictionary.add("aa");
		dictionary.add("a");
		
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
	
//	Modified version of Word Break I
	private ArrayList<String> wordBreak(String string, Set<String> dictionary) {
		ArrayList<String> solutions = new ArrayList<String>();
		if (string == null || string.length() == 0 || dictionary == null || dictionary.isEmpty()) {
			return solutions;
		}
		
		int length = string.length();
		ArrayList<ArrayList<String>> words = new ArrayList<ArrayList<String>>(length + 1);
		
		for (int i = 0; i < length + 1; i++) {
			words.add(new ArrayList<String>());
		}
		
		for (int i = length - 1; i >= 0; i--) {
			for (int j = i; j < length; j++) {
				String subString = string.substring(i, j + 1);

				if (dictionary.contains(subString)) {
					if (j == length - 1 || words.get(j + 1).size() != 0) {
						words.get(i).add(subString);
					}
				}
			}
		}
		
		return buildString(string, 0, words);
    }
	
	private ArrayList<String> buildString(String string, int index, ArrayList<ArrayList<String>> words) {
		ArrayList<String> solutions = new ArrayList<String>();

		for (String word : words.get(index)) {
			if (index + word.length() == string.length()) {
				solutions.add(word);
			} else {
				ArrayList<String> wd = buildString(string, index + word.length(), words);
				
				for (int i = 0; i < wd.size(); i++) {
					wd.set(i, word + " " + wd.get(i));
				}
				
				solutions.addAll(wd);
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
