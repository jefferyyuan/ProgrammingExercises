package com.cllin.algorithms;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * You have k lists of sorted integers. Find the smallest range that includes at least one number from each of the k lists. 
 * 
 * For example,
 *         List 1: {4, 10, 15, 24, 26}
 *         List 2: {0, 9, 12, 20}
 *         List 3: {5, 18, 22, 30}
 * 
 * The smallest range here would be {20, 24} as it contains 24 from list 1, 20 from list 2, and 22 from list 3.
 * 
 * Source: http://www.careercup.com/question?id=16759664
 */

public class MinimumWindow extends Exercise {

    private final TestCase[] testSuite = {
        new TestCase(new int[]{4, 10, 15, 24, 26}, new int[]{0, 9, 12, 20}, new int[]{5, 18, 22, 30})
    };
    
    private int index;
    private int[] window;
    
    private static int[] getMinimumWindow(int[] l1, int[] l2, int[] l3) {
        LinkedList<Integer> list1 = new LinkedList<Integer>();
        LinkedList<Integer> list2 = new LinkedList<Integer>();
        LinkedList<Integer> list3 = new LinkedList<Integer>();
        
        for (int n : l1) list1.add(n);
        for (int n : l2) list2.add(n);
        for (int n : l3) list3.add(n);
        
        int start = -1;
        int end = -1;
        
        while (list1.size() >= 1 && list2.size() >= 1 && list3.size() >= 1) {
            int leftRange = getRange(true, list1, list2, list3);
            int rightRange = getRange(false, list1, list2, list3);
            
            boolean shrinkLeft = (leftRange > rightRange);
            boolean isMinimum = !removeExtreme(shrinkLeft, list1, list2, list3);
            start = getEdge(true, list1, list2, list3);
            end = getEdge(false, list1, list2, list3);
            
            if (isMinimum) break;
        }
        
        return new int[]{start, end};
    }
    
    private static int getRange(boolean getLeft, 
            LinkedList<Integer> list1, LinkedList<Integer> list2, LinkedList<Integer> list3) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        int[] heads = (getLeft)? 
                new int[]{list1.peekFirst(), list2.peekFirst(), list3.peekFirst()} : 
                new int[]{list1.peekLast(), list2.peekLast(), list3.peekLast()};
        for (int n : heads) {
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        return max - min;
    }
    
    private static int getEdge(boolean getLeft, 
            LinkedList<Integer> list1, LinkedList<Integer> list2, LinkedList<Integer> list3) {
        int result = (getLeft)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        int[] set = (getLeft)? 
                new int[]{list1.peekFirst(), list2.peekFirst(), list3.peekFirst()} : 
                new int[]{list1.peekLast(), list2.peekLast(), list3.peekLast()};

        for (int n : set) {
            result = (getLeft)? Math.min(result, n) : Math.max(result, n);
        }
        
        return result;
    }
    
    private static boolean removeExtreme(boolean removeLeft, 
            LinkedList<Integer> list1, LinkedList<Integer> list2, LinkedList<Integer> list3) {
        if (list1.size() == 1 && list2.size() == 1 && list3.size() == 1) return false;
        
        if (removeLeft) {
            int s1 = list1.peekFirst();
            int s2 = list2.peekFirst();
            int s3 = list3.peekFirst();
            
            if (s1 == Math.min(s1, Math.min(s2, s3))) {
                if (list1.size() == 1) {
                    if (s2 < s3 && list2.size() > 1) {
                        list2.pollFirst();
                    } else {
                        list3.pollFirst();
                    }
                } else {
                    list1.pollFirst();
                }
            }
            
            if (s2 == Math.min(s1, Math.min(s2, s3))) {
                if (list2.size() == 1) {
                    if (s1 < s3 && list1.size() > 1) {
                        list1.pollFirst();
                    } else {
                        list3.pollFirst();
                    }
                } else {
                    list2.pollFirst();
                }
            }
            
            if (s3 == Math.min(s1, Math.min(s2, s3))) {
                if (list3.size() == 1) {
                    if (s1 < s2 && list1.size() > 1) {
                        list1.pollFirst();
                    } else {
                        list2.pollFirst();
                    }
                } else {
                    list3.pollFirst();
                }
            }
        } else {
            int s1 = list1.peekLast();
            int s2 = list2.peekLast();
            int s3 = list3.peekLast();
            
            if (s1 == Math.max(s1, Math.max(s2, s3))) {
                if (list1.size() == 1) {
                    if (s2 > s3 && list2.size() > 1) {
                        list2.pollLast();
                    } else {
                        list3.pollLast();
                    }
                } else {
                    list1.pollLast();
                }
            }
            
            if (s2 == Math.max(s1, Math.max(s2, s3))) {
                if (list2.size() == 1) {
                    if (s1 > s3 && list1.size() > 1) {
                        list1.pollLast();
                    } else {
                        list3.pollLast();
                    }
                } else {
                    list2.pollLast();
                }
            }
            
            if (s3 == Math.max(s1, Math.max(s2, s3))) {
                if (list3.size() == 1) {
                    if (s1 > s2 && list1.size() > 1) {
                        list1.pollLast();
                    } else {
                        list2.pollLast();
                    }
                } else {
                    list3.pollLast();
                }
            }
        }
        
        return true;
    }
    
    private class TestCase {
        int[] list1;
        int[] list2;
        int[] list3;
        
        TestCase(int[] list1, int[] list2, int[] list3) {
            this.list1 = list1;
            this.list2 = list2;
            this.list3 = list3;
        }
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }

    @Override
    protected boolean test() {
        for (index = 0; index < testSuite.length; index++) {
            TestCase test = testSuite[index];
            window = getMinimumWindow(test.list1, test.list2, test.list3);

            System.out.print("List 1 = { ");
            for (int n : test.list1) {
                System.out.printf("%d ", n);
            }
            System.out.printf("}%n");

            System.out.print("List 2 = { ");
            for (int n : test.list2) {
                System.out.printf("%d ", n);
            }
            System.out.printf("}%n");

            System.out.print("List 3 = { ");
            for (int n : test.list3) {
                System.out.printf("%d ", n);
            }
            System.out.printf("}%n");

            System.out.print("Minimum Window that covers at least one element in each list = { ");
            for (int n : window) {
                System.out.printf("%d ", n);
            }
            System.out.printf("}%n");
        }

        return true;
    }
}
