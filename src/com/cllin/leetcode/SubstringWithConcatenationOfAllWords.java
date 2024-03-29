package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Hashtable;

import com.cllin.main.Exercise;

/*
 * You are given a string, S, and a list of words, L, that are all of the same length. 
 * Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once 
 * and without any intervening characters.
 * 
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9]. (order does not matter).
 * 
 * Source: http://oj.leetcode.com/problems/substring-with-concatenation-of-all-words/
 */

public class SubstringWithConcatenationOfAllWords extends Exercise {

    private TestCase[] testSuite = {
            new TestCase("a", new String[]{"a"}),
            new TestCase("aaa", new String[]{"a", "a"}),
            new TestCase("barfoothefoobarman", new String[]{"foo", "bar"}),
            new TestCase("cccbcacaa", new String[]{"cc", "bc"}),
            new TestCase("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"}),
    };
    
    @Override
    public void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }

    private ArrayList<Integer> findSubstring(String S, String[] L) {
        if (S == null || S.length() == 0 || L == null || L.length == 0) return new ArrayList<Integer>();
        
        int wordLength = L[0].length();
        ArrayList<Integer> startingIndicesOfSubstring = new ArrayList<Integer>();
        Hashtable<String, Integer> occurances = new Hashtable<String, Integer>();
        
        for (String word : L) {
            int count = (occurances.containsKey(word))? occurances.get(word) + 1 : 1;
            occurances.put(word, count);
        }
        
        int index = 0;
        while (index + L.length * wordLength - 1 < S.length()) {
            String substring = S.substring(index, index + L.length * wordLength);
            
            boolean isValidSubstring = true;
            Hashtable<String, Integer> localOccurances = new Hashtable<String, Integer>(); 
            
            while (substring.length() > 0 && isValidSubstring) {
                String word = (substring.length() == wordLength)? new String(substring) : substring.substring(0, wordLength);
                
                if (occurances.containsKey(word)) {
                    int count = (localOccurances.containsKey(word))? localOccurances.get(word) + 1 : 1;
                    localOccurances.put(word, count);
                    
                    if (localOccurances.get(word) > occurances.get(word)) isValidSubstring = false;
                    
                    if (substring.length() == wordLength) {
                        isValidSubstring = localOccurances.get(word) == occurances.get(word);
                    }
                    
                    substring = substring.substring(wordLength);
                } else {
                    isValidSubstring = false;
                }
            }
            
            if (isValidSubstring) {
                startingIndicesOfSubstring.add(index);
            }
            
            index++;
        }
        
        return startingIndicesOfSubstring;
    }
    
    @Override
    public boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            TestCase test = testSuite[index];
            ArrayList<Integer> startingIndices = findSubstring(test.S, test.L);

            System.out.printf("S = %s%n", test.S);
            System.out.print("L = ");
            for (String string : test.L) {
                System.out.printf("%s ", string);
            }

            System.out.print("\nIndices = ");
            for (int i : startingIndices) {
                System.out.printf("%d ", i);
            }

            System.out.println("\n------------------");
        }
        
        return true;
    }
    
    private class TestCase {
        String S;
        String[] L;
        
        TestCase(String S, String[] L) {
            this.S = S;
            this.L = L;
        }
    }

}
