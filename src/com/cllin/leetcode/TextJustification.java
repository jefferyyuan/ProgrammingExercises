package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given an array of words and a length L, 
 * format the text such that each line has exactly L characters and is fully (left and right) justified.
 * 
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. 
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * 
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * 
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * 
 * Source: http://oj.leetcode.com/problems/text-justification/
 */

public class TextJustification implements LeetCodeExercise {

	private final TestCase[] testSuite = {
			new TestCase(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16),
			new TestCase(new String[]{"a"}, 1),
			new TestCase(new String[]{"What", "must", "be", "shall", "be."}, 12),
			new TestCase(new String[]{"Here", "is", "an", "example", "of", "text", "justification."}, 14),
			new TestCase(new String[]{"My", "momma", "always", "said,", "'Life", "was", "like", "a", "box", "of", "chocolates.", "You", "never", "know", "what" ,"you're", "gonna", "get."}, 20),
	};
	
	private int index;
	private ArrayList<String> result;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			TestCase test = testSuite[index];
			result = fullJustify(test.words, test.L);
			
			test();
		}
	}
	
	private ArrayList<String> fullJustify(String[] words, int L) {
		ArrayList<String> result = new ArrayList<String>();
		if (words == null || words.length == 0 || L == 0) {
			result.add(new String());
			return result;
		}
		
		int index = 0;
		while (index < words.length) {
			int start = index;
			int currentLength = -1;
			
//			Count how many words can fit in this line
			while (index < words.length && currentLength + 1 + words[index].length() <= L) {
				currentLength += (currentLength == 0)? words[index].length() : 1 + words[index].length();
				index++;
			}

//			Count how long the space in this line should be 
			index--;
			StringBuffer buffer = new StringBuffer();
			int count = index - start + 1;
			int left = L - (currentLength - (count - 1));
			
			StringBuffer space = new StringBuffer();
			int nSpace = (count == 1)? 0 : left / (count - 1);
			if (index == words.length - 1) nSpace = 1;
			
			for (int p = 0; p < nSpace; p++) {
				space.append(' ');
			}

//			Build line
			int i = start;
			ArrayList<StringBuffer> buf = new ArrayList<StringBuffer>();
			
			while (i < index) {
				buf.add(new StringBuffer(words[i]));
				buf.add(space);
				i++;
			}
			
			buf.add(new StringBuffer(words[i]));
			
//			Adjust spaces between word if needed
			if (count != 1 && left % (count - 1) != 0 && index != words.length - 1) {
				int remain = left % (count - 1);
				for (int p = 0; p < buf.size(); p++) {
					if (buf.get(p).equals(space) && remain > 0) {
						buffer.append(' ');
						remain--;
					}
					
					buffer.append(buf.get(p));
				}
			} else {
				buffer.append(buf);
			}
			
//			Fill the line with spaces if needed
			while (buffer.length() < L) {
				buffer.append(' ');
			}
			
			result.add(buffer.toString());
			index++;
		}
		
    	return result;
    }

	@Override
	public boolean test() {
		TestCase test = testSuite[index];
		System.out.printf("For L = %d,%nwords = { ", test.L);
		for (String word : test.words) {
			System.out.printf("%s ", word);	
		}
		System.out.print("}, the justified string is:\n");
		
		for (String line : result) {
			System.out.println("\t" + line);
		}
		
		System.out.println("------------------");
		return true;
	}

	private class TestCase {
		int L;
		String[] words;

		TestCase(String[] words, int L) {
			this.L = L;
			this.words = words;
		}
	}
}
