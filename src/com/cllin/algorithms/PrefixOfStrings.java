package com.cllin.algorithms;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Given a word W and a list of strings L. Find the shortest prefix of W that is not prefix for any string from L.
 * 
 * Source: http://www.careercup.com/question?id=16074662
 */

public class PrefixOfStrings extends Exercise {

    private final TestCase[] testSuite = new TestCase[]{
            new TestCase("cat", new String[]{"alpha", "beta", "cotton", "delta", "camera"}),
            new TestCase("cat", new String[]{"alpha", "beta", "cotton", "delta", "cattle"}),
            new TestCase("elephant", new String[]{"alpha", "beta", "cotton", "delta", "cattle"}),
    };
    
    private int index;
    private String shortestPrefix;
    
    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            TestCase test = testSuite[index];
            
            shortestPrefix = getShortestPrefix(test.word, Arrays.copyOf(test.list, test.list.length));
            test();
        }
    }
    
    private String getShortestPrefix(String word, String[] list) {
        int index = 0;
        int size = list.length;
        String prefix = new String(word);
        
        while (size > 0 && prefix.length() > 0) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].length() == 0) continue;
                
                if (prefix.charAt(0) != list[i].charAt(0)) {
                    list[i] = new String();
                    size--;
                } else {
                    list[i] = list[i].substring(1);
                }
            }
            
            prefix = prefix.substring(1);
            index++;
        }
        
        return (size == 0)? word.substring(0, index - 1) : "No valid prefix";
    }
    
    protected void test() {
        System.out.printf("Word = %s%nList = { ", testSuite[index].word);
        for (String string : testSuite[index].list) {
            System.out.printf("%s ", string);
        }
        System.out.printf("}%n");
        
        System.out.printf("The shortest prefix is: '%s'%n", shortestPrefix);
        System.out.println("------------------------------");
    }

    private class TestCase {
        String word;
        String[] list;
        
        TestCase(String word, String[] list) {
            this.word = word;
            this.list = list;
        }
    }
}
