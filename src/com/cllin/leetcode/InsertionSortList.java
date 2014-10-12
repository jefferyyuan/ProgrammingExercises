package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Sort a linked list using insertion sort.
 * 
 * Source: http://oj.leetcode.com/problems/insertion-sort-list/
 */

public class InsertionSortList implements LeetCodeExercise {
    private final int SIZE = 1000;
    private final int MAXIMUM = 1000;

    private ListNode head;
    
    @Override
    public void initialize() {
        head = new ListNode((int) (Math.random() * MAXIMUM));
        
        ListNode node = head;
        for (int i = 1; i < SIZE; i++) {
            node.next = new ListNode((int) (Math.random() * MAXIMUM));
            node = node.next;
        }
    }

    @Override
    public void run() {
        initialize();
        head = insertionSortList(head);
        
        if (test()) System.out.println("Success");
        else System.out.println("Failed");    
    }
    
    /*
     * Iterative through the list:
     *     1) node is in its place, i.e. prev.value < node.value
     *         Do nothing, move on
     *     2) node is not in its place
     *         a) node is the smallest element so far
     *             Insert the node to the head
     *         b) node is the largest element so far
     *             Do nothing, move on
     *         c) node is neither
     *             Insert the node to its place
     */
    private ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        
        ListNode node = head.next;
        ListNode prev = head;
        
        while (node != null) {
            ListNode next = node.next;
            
//            Node is not in its place
            if (prev.val > node.val) {
                ListNode n = head.next;
                ListNode p = head;
                
//                Case: node.value is the smallest element in this list
                if (node.val < p.val) {
                    head = node;
                    node.next = p;
                    prev.next = next;
                    
                    node = next;
                } else {
                    while (n != node) {
//                        Case: the node finds its place between head and current place (exclusively)
                        if (p.val <= node.val && node.val < n.val) {
                            p.next = node;
                            node.next = n;
                            prev.next = next;
                            
                            node = next;
                            break;
                        }
                        p = n;
                        n = n.next;
                    }
                    
//                    Case: node.value is the largest element so far
                    if (node != null && n == node) {
                        prev = node;
                        node = next;
                    }
                }
            } else {
//                Node is in its place, do nothing, moving on
                prev = node;
                node = next;
            }
        }
        
        return head;
    }

    @Override
    public boolean test() {
        if (head == null || head.next == null) return true;
        
        ListNode node = head.next;
        ListNode prev = head;
        while (node != null) {
            if (prev.val > node.val) {
                return false;
            }
            
            prev = node;
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
