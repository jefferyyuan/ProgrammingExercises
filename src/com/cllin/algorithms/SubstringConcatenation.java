package com.cllin.algorithms;

import java.util.ArrayList;

import com.cllin.main.Exercise;

/*
 * Given a list of words, L, that are all the same length, and a string, S. 
 * Find the starting position of the substring of S,
 * which is a concatenation of each word in L exactly once, without any intervening characters.
 * 
 * This substring will occur exactly once in S.
 * 
 * Example:
 * L: "fooo", "barr", "wing", "ding", "wing"
 * S: "lingmindraboofooowingdingbarrwingmonkeypoundcake"
 * 
 * Solution: fooowingdingbarrwing.
 * 
 * Source: http://www.careercup.com/question?id=12332722
 */

public class SubstringConcatenation implements Exercise {

    private final TestCase[] testSuite = new TestCase[]{
            new TestCase("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo", "barr", "wing", "ding", "wing"})
    };
    
    private int index;
    private String substring;
    
    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            substring = getSubstring(testSuite[index].S, testSuite[index].L);
            test();
        }
    }
    
    private String getSubstring(String string, String[] list) {
        if (list == null || list.length == 0) return new String();
        
        ArrayList<String> dictionary = new ArrayList<String>();
        for (String word : list) {
            dictionary.add(word);
        }
        
        ArrayList<ArrayList<String>> partitions = new ArrayList<ArrayList<String>>(list[0].length());
        for (int i = 0; i < list[0].length(); i++) {
            ArrayList<String> partition = new ArrayList<String>();
            
            int index = i;
            while (index < string.length()) {
                if (index + list[0].length() > string.length()) {
                    partition.add(string.substring(index));
                } else {
                    partition.add(string.substring(index, index + list[0].length()));
                }
                index += list[0].length();
            }
            
            partitions.add(partition);
        }
        
        for (ArrayList<String> partition : partitions) {
            int count = 0;
            int size = dictionary.size();
            ArrayList<String> d = new ArrayList<String>(dictionary);
            
            for (int i = 0; i < partition.size(); i++) {
                int index = d.indexOf(partition.get(i));
                if (index != -1) {
                    d.remove(index);
                    count++;
                    
                    if (count == size) {
                        StringBuffer buffer = new StringBuffer();
                        for (int j = i; j > i - count; j--) {
                            buffer.insert(0, partition.get(j));
                        }
                        
                        return buffer.toString();
                    }
                } else {
                    if (count != size) {
                        count = 0;
                        d = new ArrayList<String>(dictionary);
                    }
                }
            }
        }
        
        return "Substring not found";
    }
    
    private void test() {
        System.out.printf("S = %s%n", testSuite[index].S);
        
        System.out.print("L = { ");
        for (String word : testSuite[index].L) {
            System.out.printf("%s ", word);
        }
        System.out.printf("}%n");
        
        System.out.printf("Substring = %s%n", substring);
        
        System.out.println("------------------------------");
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