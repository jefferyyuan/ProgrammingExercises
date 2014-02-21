package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeKSortedLists implements LeetCodeExercise {
	
	private ArrayList<ArrayList<ListNode>> testSuite;
	private int index;
	
	private ListNode head;

	@Override
	public void initialize() {
		ArrayList<ListNode> list;
		testSuite = new ArrayList<ArrayList<ListNode>>();
		
//		CASE 0: NULL LIST
		list = new ArrayList<ListNode>();
		testSuite.add(list);

//		INITIALIZATION
		ListNode l1, l2, n1, n2;
		
		int max = 100;
		int size = max / 2;
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = (int) (Math.random() * max);
		}
		
		Arrays.sort(numbers);
		
//		CASE 1: LISTS WITH EQUAL LENGTH
		list = new ArrayList<ListNode>();
		
		
		l1 = new ListNode(-1);
		l2 = new ListNode(-1);
		n1 = l1;
		n2 = l2;
		
		for (int i = 0; i < size; i++) {
			n1.next = new ListNode(numbers[i]);
			n2.next = new ListNode(numbers[i]);
			
			n1 = n1.next;
			n2 = n2.next;
		}
		
		list.add(l1.next);
		list.add(l2.next);
		
		testSuite.add(list);
		
//		CASE 2: LISTS WITH DIFFERENT LENGTH
		list = new ArrayList<ListNode>();
		
		
		l1 = new ListNode(-1);
		l2 = new ListNode(-1);
		n1 = l1;
		n2 = l2;
		
		for (int i = 0; i < size; i++) {
			if (i < size / 2) {
				n2.next = new ListNode(numbers[i]);
				n2 = n2.next;
			}
			
			n1.next = new ListNode(numbers[i]);
			n1 = n1.next;
		}
		
		list.add(l1.next);
		list.add(l2.next);
		
		testSuite.add(list);
	}

	@Override
	public void runExercise() {
		initialize();
		for (index = 0; index < testSuite.size(); index++) {
			head = mergeKLists(testSuite.get(index));
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
	private ListNode mergeKLists(ArrayList<ListNode> lists) {
		if (lists == null || lists.size() == 0) return null;
		
		ListNode dummyHead = new ListNode(-1);
		ListNode tail = dummyHead;
		
		while (lists.size() > 0) {
			int minIndex = -1;
			ListNode min = new ListNode(2147483647);
			
			for (int i = 0; i < lists.size(); i++) {
				if (lists.get(i) == null) {
					lists.remove(i--);
				} else if (lists.get(i).val < min.val) {
					min = lists.get(i);
					minIndex = i;
				}
			}
			
			if (minIndex == -1) break;
			
			tail.next = min;
			tail = tail.next;
			if (min.next == null) {
				lists.remove(minIndex);
			} else {
				lists.set(minIndex, min.next);
			}
		}
		
    	return dummyHead.next;
    }

	@Override
	public boolean test() {
		ListNode node = head;
		ListNode next;
		while (node != null) {
			next = node.next;
			
			if (next == null) break;
			if (next.val < node.val)
				return false;
				
			node = next;
			next = next.next;
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
