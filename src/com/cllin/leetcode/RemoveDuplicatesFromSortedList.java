package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * Source: http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

public class RemoveDuplicatesFromSortedList implements LeetCodeExercise {
    private final int MAXIMUM = 1000;
    private final int SIZE = 1000;
    
    private int[] integers;
    private ListNode root;
    
    @Override
    public void initialize() {
        integers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            integers[i] = (int)(Math.random() * MAXIMUM);
        }
        
        Arrays.sort(integers);
        
        root = new ListNode(integers[0]);
        ListNode node = root;
        for (int i = 1; i < SIZE; i++) {
            node.next = new ListNode(integers[i]);
            node = node.next;
        }
    }

    @Override
    public void run() {
        initialize();
        deleteDuplicates(root);
        if (test()) System.out.println("Success");
        else System.out.println("Failed");    
    }
    
    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode previous = head;
        ListNode node = head.next;
        
        while (node != null) {
            if (node.val == previous.val) {
                previous.next = node.next;
            } else {
                previous = node;
            }
            node = node.next;
        }
        
        return head;
    }

    @Override
    public boolean test() {
        ListNode node = root;
        while (node != null) {
            
            ListNode previous = root;
            while (previous != null && previous.hashCode() != node.hashCode()) {
                if (previous.val == node.val) return false;
                previous = previous.next;
            }
            
            node = node.next;
        }
        return true;
    }
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
