package com.cllin.leetcode;

public class ReverseNodesInKGroup implements LeetCodeExercise {

	private final int MAXIMUM = 2;
	
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
	public void runExercise() {
		for (K = 2; K <= 10; K++) {
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
			while (probe != null) {
				if (count == k) break;
				
				probe = probe.next;
				count++;
			}
			
			if (count == k) {
				int c = 0;
				ListNode prev = null;
				ListNode current = node;
				ListNode next = null;
				while (current != null && c < k) {
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
