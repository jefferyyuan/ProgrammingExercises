package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * Source: http://oj.leetcode.com/problems/linked-list-cycle/
 */

public class LinkedListCycle extends Exercise {
    private final int SIZE = 1000 - 1;
    private final int MAXIMUM = 1000;
    private final int CYCLE_BEGINNING = 500;
    
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
            nodeB.next = new ListNode((int)(Math.random() * MAXIMUM));
            nodeB = nodeB.next;
            
            if (i == CYCLE_BEGINNING) cycleBeginning = nodeB;
        }
        nodeB.next = cycleBeginning;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    private boolean hasCycle(ListNode head) {
        ListNode a = head;
        ListNode b = head;
        
        while (a != null && b != null) {
            if (a.next != null) a = a.next.next;
            else return false;
            
            b = b.next;
            
            if (a == null || b == null) return false;
            if (a == b) return true;
        }
        
        return false;
    }

    @Override
    public boolean test() {
        if (hasCycle(listA) || !hasCycle(listB)) {
            System.out.println("Failed");
            return false;
        }
        
        System.out.println("Success");
        return true;
    }

    @SuppressWarnings("unused")
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
