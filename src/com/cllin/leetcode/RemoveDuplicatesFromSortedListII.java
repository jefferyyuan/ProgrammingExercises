package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * 
 * Source: http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */

public class RemoveDuplicatesFromSortedListII extends Exercise {

    private final int MAXIMUM = 10;
    private final int SIZE = 10;
    
    private ListNode head;
    
    @Override
    public void initialize() {
        int[] numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = (int) (Math.random() * MAXIMUM);
        }
        
        Arrays.sort(numbers);
        
        head = new ListNode(numbers[0]);
        ListNode node = head;
        for (int i = 1; i < SIZE; i++) {
            node.next = new ListNode(numbers[i]);
            node = node.next;
        }
    }

    @Override
    protected void runExercise() {
        initialize();
        head = deleteDuplicates(head);
        
        if (test()) System.out.println("Success");
        else System.out.println("Failed");

    }
    
    private static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode node = head;
        while (node != null) {
            if (node.next == null) break;
            
            int count = 0;
            ListNode next = node.next;
            while (next != null && next.val == node.val) {
                next = next.next;
                count++;
            }
            
            if (count == 0) {
                prev = node;
                node = node.next;
            } else {
                prev.next = next;
                node = next;
            } 
        }
        
        return dummy.next;
    }

    @Override
    public boolean test() {
        ListNode prev = head;
        ListNode node = prev.next;
        
        while (node != null) {
            if (prev.val == node.val) return false;
            
            prev = node;
            node = node.next;
        }
        
        return true;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
