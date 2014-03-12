package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

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
	public void runExercise() {
		initialize();
		
		head = removeNthFromEnd(head, n);
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");	
	}
	
    private ListNode removeNthFromEnd(ListNode head, int n) {
    	if (head == null) return null;
    	else if (n == 0) return head;
    	
    	ArrayList<ListNode> list = new ArrayList<ListNode>();
    	
    	ListNode node = head;
    	while (node != null) {
    		list.add(node);
    		node = node.next;
    	}
    	
    	int index = list.size() - n;
    	if (index == list.size() - 1) {
    		if (index == 0) return null;
    		else list.get(index - 1).next = null;
    	} else if (index == 0) {
    		return head.next;
    	} else list.get(index - 1).next = list.get(index + 1);
    	
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
