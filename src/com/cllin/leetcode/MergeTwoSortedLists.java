package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

public class MergeTwoSortedLists implements LeetCodeExercise {
	private final int MAXIMUM = 1000;
	private final int SIZE = 1000;
	
	private ListNode list1;
	private ListNode list2;
	
	private int[] reference1;
	private int[] reference2;
	private int[] answer;

	@Override
	public void initialize() {
		reference1 = new int[SIZE];
		reference2 = new int[SIZE];
		answer = new int[SIZE * 2];
		
		reference1[0] = 0;
		reference2[0] = 0;
		
		for (int i = 1; i < SIZE; i++) {
			reference1[i] = (int)(Math.random() * MAXIMUM);
			reference2[i] = (int)(Math.random() * MAXIMUM);
		}
		
		Arrays.sort(reference1);
		Arrays.sort(reference2);

//		Creating the LinkedList
		list1 = new ListNode(reference1[0]);
		list2 = new ListNode(reference2[0]);
		
		ListNode next1 = list1;
		ListNode next2 = list2;
		for (int i = 1; i < SIZE; i++) {
			next1.next = new ListNode(reference1[i]);
			next2.next = new ListNode(reference2[i]);
			
			next1 = next1.next;
			next2 = next2.next;
		}
		
		for (int i = 0; i < SIZE; i++) {
			answer[i] = reference1[i];
			answer[i + SIZE] = reference2[i];
		}
		
		Arrays.sort(answer);
	}

	@Override
	public void runExercise() {
		initialize();
		
		list1 = mergeTwoLists(list1, list2);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1 == null && l2 == null) return null;
    	else if (l1 == null) return l2;
    	else if (l2 == null) return l1;
    	
    	ListNode head = new ListNode(-1);
    	ListNode node = head;
    	ListNode iter1 = l1;
    	ListNode iter2 = l2;
    	
    	while (iter1 != null && iter2 != null) {
    		if (iter1.val < iter2.val) {
    			node.next = iter1;
    			iter1 = iter1.next;
    		} else {
    			node.next = iter2;
    			iter2 = iter2.next;
    		}
    		
    		node = node.next;
    	}

    	if (iter1 == null && iter2 == null) return head.next;
    	else if (iter1 != null) {
    		while (iter1 != null) {
    			node.next = iter1;
    			iter1 = iter1.next;
    			
        		node = node.next;
    		}
    	} else {
    		while (iter2 != null) {
    			node.next = iter2;
    			iter2 = iter2.next;
    			
        		node = node.next;
    		}
    	}
    	
    	return head.next;
    }

	@Override
	public boolean test() {
		int count = 0;
		ListNode node = list1;
		
		while (node != null) {
			if (node.val != answer[count]) {
				return false;
			}
			node = node.next;
			count++;
		}
		
		if (count != answer.length) {
			return false;
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
