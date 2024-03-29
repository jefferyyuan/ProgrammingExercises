package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * Source: http://oj.leetcode.com/problems/linked-list-cycle-ii/
 */

public class LinkedListCycleII extends Exercise {
    private final int SIZE = 3 - 1;
    private final int MAXIMUM = 100;
    private final int CYCLE_BEGINNING = 0;
    
    private ListNode listA;
    private ListNode listB;
    
    @Override
    public void initialize() {
        listA = new ListNode((int)(Math.random() * MAXIMUM));
        listB = new ListNode((int)(Math.random() * MAXIMUM));
        ListNode nodeA = listA;
        ListNode nodeB = listB;
        ListNode cycleBeginning = null;
        
        for(int i = 0; i < SIZE; i++){
            nodeA.next = new ListNode((int)(Math.random() * MAXIMUM));
            nodeA = nodeA.next;
        }
        
        for(int i = 0; i < SIZE; i++){
            if (i == CYCLE_BEGINNING) cycleBeginning = nodeB;
            
            nodeB.next = new ListNode((int)(Math.random() * MAXIMUM));
            nodeB = nodeB.next;
        }
        nodeB.next = cycleBeginning;
    }

    @Override
    protected void runExercise() {
        ListNode a = detectCycle(listA);
        ListNode b = detectCycle(listB);
        
        if (a != null || b == null) System.out.println("Failed");
        else System.out.printf("The cycle starts at %d%n", b.val);
    }
    
    private ListNode detectCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        
        while (a != null && b != null) {
            if (a.next != null) a = a.next.next;
            else return null;
            b = b.next;
            
            if (a == null || b == null) return null;
            if (a == b) break;
        }
        
        a = head;
        while (a != null) {
            if (a == b) return a;
            
            a = a.next;
            b = b.next;
        }
        
        return null;  
    }

    @Override
    public boolean test() {
        return false;
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
