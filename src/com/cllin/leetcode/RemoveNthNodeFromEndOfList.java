package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * Source: http://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 */

public class RemoveNthNodeFromEndOfList implements LeetCodeExercise {
    private final int MAXIMUM = 100;
    private final int LENGTH = 100;

    private int n;
    private ListNode head;
    private ArrayList<Integer> reference;;
    
    @Override
    public void initialize() {
        reference = new ArrayList<Integer>();
        n = (int)(Math.random() * LENGTH);
        
        int value = (int)(Math.random() * MAXIMUM);
        head = new ListNode(value);
        reference.add(value);
        
        ListNode node = head;
        for (int i = 1; i < LENGTH; i++) {
            value = (int)(Math.random() * MAXIMUM);
            node.next = new ListNode(value);
            reference.add(value);
            
            node = node.next;
        }
        
        reference.remove(LENGTH - n);
    }

    @Override
    public void run() {
        initialize();
        
        head = removeNthFromEnd(head, n);
        
        if (test()) System.out.println("Success");
        else System.out.println("Failed");    
    }
    
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode i = head;
        ListNode j = head;
        
        int count = 0;
        while (i != null && count < n) {
            i = i.next;
            count++;
        }
        
        /*
         * Remove the first element
         * It is guaranteed that n is always valid, so no need to worry about cases about n > list.size
         */
        if (i == null && count == n) {
            return head.next;
        } 
        
        while (i.next != null) {
            i = i.next;
            j = j.next;
        }
        
        j.next = j.next.next;
        
        return head;
    }

    @Override
    public boolean test() {
        int index = 0;
        ListNode node = head;
        
        while (node != null) {
            if (node.val != reference.get(index).intValue()) return false;
            
            index++;
            node = node.next;
        }
        
        return true;
    }
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
