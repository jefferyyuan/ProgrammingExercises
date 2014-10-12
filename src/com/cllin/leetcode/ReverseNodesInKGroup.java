package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * 
 * Only constant memory is allowed.
 * 
 * For example,
 * Given this linked list: 1 -> 2 -> 3 -> 4 -> 5
 * 
 * For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5
 * For k = 3, you should return: 3 -> 2 -> 1 -> 4 -> 5
 * 
 * Source: http://oj.leetcode.com/problems/reverse-nodes-in-k-group/ 
 */

public class ReverseNodesInKGroup extends LeetCodeExercise {

    private final int MAXIMUM = 10;
    
    private ListNode head;
    private int K;
    
    @Override
    public void initialize() {
        head = new ListNode(1);
        
        ListNode node = head;
        for (int i = 2; i <= MAXIMUM; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
    }

    @Override
    public void run() {
        for (K = 2; K <= MAXIMUM * 2; K++) {
            initialize();
            head = reverseKGroup(head, K);
            test();
        }
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode node = head;
        ListNode beforeHead = dummy;
        while (node != null) {
            int count = 0;
            ListNode probe = node;
            while (probe != null && count < k) {
                probe = probe.next;
                count++;
            }
            
            if (count == k) {
                int c = 0;
                ListNode prev = null;
                ListNode current = node;
                ListNode next = null;
                while (c < k) {
                    next = current.next;
                    current.next = prev;
                    prev = current;
                    current = next;
                    
                    c++;
                }
                
                dummy.next = prev;
                dummy = node;
                node = next;
            } else {
                dummy.next = node;
                break;
            }
        }
        
        return beforeHead.next;
    }
    
    @Override
    public boolean test() {
        System.out.printf("K = %d%n", K);
        
        ListNode node = head;
        while (node != null) {
            System.out.printf("%d ", node.val);
            node = node.next;
        }
        
        System.out.println("\n------------------");
        
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
