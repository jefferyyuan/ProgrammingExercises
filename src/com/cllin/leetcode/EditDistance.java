package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * 
 * You have the following 3 operations permitted on a word:
 *         a) Insert a character
 *         b) Delete a character
 *         c) Replace a character
 * 
 * Source: http://oj.leetcode.com/problems/edit-distance/
 */

public class EditDistance extends Exercise {
    private final TestCase[] testSuite = {
            new TestCase("", ""),
            new TestCase("a", "a"),
            new TestCase("mike", "bike"),
            new TestCase("kitten", "sitting")
    };

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void runExercise() {
        for (TestCase test : testSuite) {
            int distance = minDistance(test.word1, test.word2);
            System.out.printf("The edit distance between '%s' and '%s' is %d%n", test.word1, test.word2, distance);
        }
    }
    
    /*
     * Say, we want to edit word1, changing it to word2
     * D(i, j) = Distance from word1(0, i) to word2(0, j)
     *         1) If word1(i) == word2(j), 
     *                 D(i, j) = D(i - 1, j - 1)        ------ Need not to edit
     * 
     *         2) Else, D(i, j) = Minimum(D(i - 1, j - 1), D(i, j - 1), D(i - 1, j)) + 1
     *                 D(i - 1, j - 1) + 1                ------ word1(0, i - 1) is edited to word2(0, j - 1), 
     *                                                             REPLACE word1(i) with word2(j)
     *                 D(i, j - 1) + 1                    ------ word1(0, i) is edited to word2(0, j - 1),
     *                                                             DELETE word2(j)
     *                 D(i - 1, j) + 1                    ------ word1(0, i - 1) is edited to word2(0, j),
     *                                                             INSERT word1(i) to the edited word
     */
    private int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            if (word1 == null && word2 == null) return 0;
            else if (word1 == null) return word2.length();
            else if (word2 == null) return word1.length();
        }
        
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] distanceMap = new int[length1 + 1][length2 + 1];
        
        for (int i = 0; i <= length1; i++) distanceMap[i][0] = i;
        for (int j = 0; j <= length2; j++) distanceMap[0][j] = j;
        
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    distanceMap[i][j] = distanceMap[i - 1][j - 1];
                } else {
                    int min = Math.min(distanceMap[i - 1][j], distanceMap[i][j - 1]);
                    min = Math.min(min, distanceMap[i - 1][j - 1]);
                    
                    distanceMap[i][j] = min + 1;
                }
            }
        }
        
        return distanceMap[length1][length2];
    }

    @Override
    public boolean test() {
        return false;
    }
    
    private class TestCase {
        String word1;
        String word2;
        
        TestCase(String word1, String word2) {
            this.word1 = word1;
            this.word2 = word2;
        }
    }

}