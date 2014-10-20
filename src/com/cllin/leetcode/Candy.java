package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 *         1) Each child must have at least one candy.
 *         2) Children with a higher rating get more candies than their neighbors.
 * 
 * What is the minimum candies you must give?
 * 
 * Source: http://oj.leetcode.com/problems/candy/
 */

public class Candy extends Exercise {

    private int[][] testSuite = {
            {1, 2, 2},
            {2, 1},
            {2, 3, 2},
            {4, 2, 3, 4, 1}
    };
    
    @Override
    public void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    @SuppressWarnings("unused")
    private int candyLinearSpace(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        
        int[] candies = new int[ratings.length];
        candies[0] = 1;
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                candies[i] = 1;
            }
        }
        
        for (int i = ratings.length - 2; i >= 0; i--) {
            // If the rating is higher but with less or equal number of candies
            if (ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        
        int output = 0;
        for (int i = 0; i < ratings.length; i++) {
            output += candies[i];
        }
        
        return output;
    }
    
    /*
     * When the rating is descending, the current one should always be the least in the sequence (i.e., 1).
     * If the length of descending sequence is larger the first element (i.e. the one who has the most candies in the sequence),
     * we need to shift the entire sequence by one. (Giving everyone in the sequence one more candy)
     * 
     * When the rating is ascending, the current one could be:
     *     1) the the largest in the sequence
     *     2) 1, if R(i) == R(i - 1)
     *             ------ The question states "Children with a higher rating get more candies than their neighbors."
     *             ------ Equal is not higher
     */
    private int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;

        int nCandy = 1;
        int prevCandy = 1;
        int lengthDescendingSequence = 0;
        int maximumCandyInSequence = prevCandy;
        
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]) {
                // Increment length of the descending sequence
                lengthDescendingSequence++;
                
                /*
                 * If length of descending sequence is larger the first element, i.e. this kid will get 0 candy,
                 * we need to increment the length of the sequence by one.
                 * 
                 * For example, the second child in this case: R = [3, 2, 1], C = [1, *, *]
                 * maximum in the sequence is 1, so he would get 0 zero, which violates the rule,
                 * so we need to shift 1 and make C = [2, 1, *]
                 */
                if (maximumCandyInSequence == lengthDescendingSequence) {
                    lengthDescendingSequence++;
                }
                
                // Shift the entire sequence by one
                nCandy += lengthDescendingSequence;
                prevCandy = 1;
            } else {
                prevCandy = (ratings[i] > ratings[i - 1])? prevCandy + 1 : 1;
                
                nCandy += prevCandy;
                lengthDescendingSequence = 0;
                maximumCandyInSequence = prevCandy;
            }
        }
        
        return nCandy;
    }

    @Override
    public boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            int minimumCandy = candy(testSuite[index]);

            System.out.print("For the following rating: { ");
            for (int i = 0; i < testSuite[index].length; i++) {
                System.out.printf("%d ", testSuite[index][i]);
            }

            System.out.printf("}, it needs %d candies at least%n", minimumCandy);
        }
        
        return false;
    }

}
