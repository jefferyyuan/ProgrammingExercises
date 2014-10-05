package com.cllin.algorithms;

import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Given a dictionary, in the form of a file that contains one word per line. 
 * For example: 
 * 	{abacus, deltoid, gaff, giraffe, microphone, reef, qar}
 * 
 * You are also given a collection of letters. for example:
 * 	{a, e, f, f, g, i, r, q}
 * 
 *  The task is to find the longest word in the dictionary that can be spelled with the collection of letters.
 *  
 *  For example, the correct answer for the example values above is "giraffe".
 *  Note that "reef" is not a possible answer, because the set of letters contains only one "e".
 *  
 *  Source: http://www.careercup.com/question?id=16148684
 */

public class WordsFromLetterCollection implements Exercise {

	private final TestCase[] testSuite = new TestCase[]{
			new TestCase(
					new String[]{"abacus", "deltoid", "gaff", "giraffe", "microphone", "reef", "qar"}, 
					new char[]{'a', 'e', 'f', 'f', 'g', 'i', 'r', 'q'})
	};
	
	private int index;
	private String longestWord;
	
	@Override
	public void run() {
		for (index = 0; index < testSuite.length; index++) {
			longestWord = getLongestWordFromDictionary(testSuite[index].dictionary, testSuite[index].characters);
			test();
		}
	}
	
	private String getLongestWordFromDictionary(String[] dictionary, char[] characters) {
		HashMap<Character, Integer> characterCounts = new HashMap<Character, Integer>();
		String longestWork = new String();
		
		for (char character : characters) {
			int count = (characterCounts.containsKey(character))? characterCounts.get(character) : 0;
			characterCounts.put(character, count + 1);
		}
		
		for (String word : dictionary) {
			boolean canBeSpelledWithCharacters = true;
			HashMap<Character, Integer> counts = new HashMap<Character, Integer>(characterCounts);
			for (char character : word.toCharArray()) {
				if (counts.containsKey(character)) {
					counts.put(character, counts.get(character) - 1);
					if (counts.get(character) == 0) counts.remove(character);
				} else {
					canBeSpelledWithCharacters = false;
					break;
				}
			}
			
			if (canBeSpelledWithCharacters && word.length() > longestWork.length()) {
				longestWork = word;
			}
		}
		
		return (longestWork.length() == 0)? "Cannot found word that can be spelled with the collection of letters" : longestWork;
	}

	private void test() {
        System.out.print("Dictionary = { ");
        for (String word : testSuite[index].dictionary) {
            System.out.printf("%s ", word);
        }
        System.out.printf("}%n");
        
        System.out.print("Characters = { ");
        for (char character : testSuite[index].characters) {
            System.out.printf("%c ", character);
        }
        System.out.printf("}%n");
        
        System.out.printf("Longest word that can spelled with the collection of letters is %s%n", longestWord);
        System.out.println("------------------------------");
	}
	
	private class TestCase {
		String[] dictionary;
		char[] characters;
		
		TestCase(String[] dictionary, char[] characters) {
			this.dictionary = dictionary;
			this.characters = characters;
		}
	}
}
