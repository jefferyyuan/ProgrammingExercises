package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class AddTwoNumbers implements LeetCodeExercise {
	private final int MAXIMUM = 10;
	
	private int DIGITS;
	
	private ListNode head1;
	private ListNode head2;
	private ListNode result;
	
	private int reference;
	
	@Override
	public void initialize() {
		int power = 1;
		int value1;
		int value2;
		ListNode dummy1 = new ListNode(-1);
		ListNode dummy2 = new ListNode(-1);
		ListNode node1 = dummy1;
		ListNode node2 = dummy2;

		reference = 0;
		for (int i = 0; i < DIGITS; i++) {
			value1 = (int) (Math.random() * MAXIMUM);
			value2 = (int) (Math.random() * MAXIMUM);
			
			node1.next = new ListNode(value1);
			node2.next = new ListNode(value2);
			node1 = node1.next;
			node2 = node2.next;
			
			reference += (value1 + value2) * power;
			power *= 10;
		}
		
		head1 = dummy1.next;
		head2 = dummy2.next;
	}

	@Override
	public void runExercise() {
		for (DIGITS = 1; DIGITS <= 5; DIGITS++) {
			initialize();
			result = addTwoNumbers(head1, head2);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
    private ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode n1 = l1;
    	ListNode n2 = l2;

    	ListNode dummyHead = new ListNode(-1);
    	ListNode node = dummyHead;
    	
    	int sum;
    	boolean addOne = false;
    	while (n1 != null || n2 != null) {
    		if (n1 != null && n2 != null) {
    			sum = n1.val + n2.val;
    			sum = (addOne)? sum + 1 : sum;
    			
    			node.next = new ListNode(sum % 10);
    			addOne = (sum >= 10);
    			
    			node = node.next;
    			n1 = n1.next;
    			n2 = n2.next;
    		} else if (n1 != null) {
    			sum = n1.val;
    			sum = (addOne)? sum + 1 : sum;
    			
    			node.next = new ListNode(sum % 10);
    			addOne = (sum >= 10);
    			
    			node = node.next;
    			n1 = n1.next;
    		} else if (n2 != null) {
    			sum = n2.val;
    			sum = (addOne)? sum + 1 : sum;
    			
    			node.next = new ListNode(sum % 10);
    			addOne = (sum >= 10);
    			
    			node = node.next;
    			n2 = n2.next;
    		}
    	}
    	
    	if (addOne) {
    		node.next = new ListNode(1);
    	}
    	
    	return dummyHead.next;
    }

	@Override
	public boolean test() {
		int solution = 0;
		int power = 1;
		ListNode node = result;
		
		while (node != null) {
			solution += node.val * power;
			
			power *= 10;
			node = node.next;
		}
		
		return (solution == reference);
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
