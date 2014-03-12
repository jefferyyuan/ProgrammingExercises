package com.cllin.leetcode;

import java.util.Stack;

import com.cllin.main.LeetCodeExercise;

public class RotateList implements LeetCodeExercise {
	
	private int SIZE = 10;
	
	private int N;
	private ListNode head;
	
	@Override
	public void initialize() {
		head = new ListNode(1);
		
		ListNode node = head;
		for (int i = 2; i <= SIZE; i++) {
			node.next = new ListNode(i);
			node = node.next;
		}
	}

	@Override
	public void runExercise() {
		for (N = 0; N <= SIZE * 2; N++) {
			initialize();
			head = rotateRight(head, N);
			test();
		}
	}
	
	private ListNode rotateRight(ListNode head, int n) {
		if (head == null || n == 0) return head;
		
		ListNode node = head;
		Stack<ListNode> stack = new Stack<ListNode>();
		while (node != null) {
			stack.push(node);
			node = node.next;
		}
		
		int size = stack.size();
		if (n >= size) {
			return rotateRight(head, n % size);
		}
		
		ListNode tempTail = stack.pop();
		for (int i = 1; i < n; i++) {
			node = stack.pop();
		}
		head = (n == 1)? tempTail : node;
		
		ListNode newTail = stack.pop();
		if (stack.isEmpty()) {
			node = newTail;
		} else {
			while (!stack.isEmpty()) {
				node = stack.pop();
			}
		}
		
		tempTail.next = node;
		newTail.next = null;
		
    	return head;
    }

	@Override
	public boolean test() {
		System.out.printf("N = %d%n", N);
		
		ListNode node = head;
		while (node != null) {
			System.out.printf("%d -> ", node.val);
			node = node.next;
		}
		System.out.print("NULL\n");
		System.out.println("------------------");
		
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
