package com.cllin.algorithms;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Given a string consisting of A, B and C's, we can perform the following operation: 
 * Take any two adjacent distinct characters and replace it with the third character. 
 * 
 * For example, if 'A' and 'C' are adjacent, they can replaced with 'B'. 
 * What is the smallest string which can result by applying this operation repeatedly? 
 *
 * Source: http://www.careercup.com/question?id=12718665
 */

public class StringReduction extends Exercise {

    private final String[] testSuite = new String[]{
            "ABA",
            "ABCCCCCCC",
            "CAB",
            "BCAB",
            "CCCCC"
    };
    
    private int index;
    private String output;
    
    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            output = reduceString(testSuite[index]);
            test();
        }
    }
    
    private String reduceString(String input) {
        String minimum = new String(input);
        LinkedList<String> queue = new LinkedList<String>();
        queue.add(input);
        
        while (!queue.isEmpty()) {
            String string = queue.pollFirst();
            if (string.length() < minimum.length()) minimum = string;
            if (minimum.length() <= 1) return minimum;
            
            for (int start = 0; start <= string.length() - 2; start++) {
                char[] prefix = string.substring(start, start + 2).toCharArray();
                if ((prefix[0] == 'A' && prefix[1] == 'B') || (prefix[0] == 'B' && prefix[1] == 'A')) {
                    queue.add(string.substring(0, start) + "C" + string.substring(start + 2));
                } else if ((prefix[0] == 'A' && prefix[1] == 'C') || (prefix[0] == 'C' && prefix[1] == 'A')) {
                    queue.add(string.substring(0, start) + "B" + string.substring(start + 2));
                } else if ((prefix[0] == 'B' && prefix[1] == 'C') || (prefix[0] == 'C' && prefix[1] == 'B')) {
                    queue.add(string.substring(0, start) + "A" + string.substring(start + 2));
                }
            }
        }
        
        return minimum;
    }
    
    protected void test() {
        System.out.printf("Input = %s%n", testSuite[index]);
        System.out.printf("Output = %s%n", output);
        
        System.out.println("------------------------------");
    }

}
