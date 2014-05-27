package com.cllin.cci.chap02;

import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?
 */

public class Exercise02_01 implements Exercise {
	private final int SIZE = 100;
	private final int MAXIMUM = 1000;
	
	private Node listHead;
	
	@Override
	public void runExercise() {
		boolean isSuccess = true;
		for (int i = 0; i < 100 && isSuccess; i++) {
			initialize();
			listHead = removeDuplicate(listHead);
			isSuccess = test();
		}
		
		System.out.printf("%s%n", (isSuccess)? "Success!" : "Failed");
	}
	
	/*
	 * If a buffer is not allowed,
	 * Time Complexity = O(n ^ 2), n is the length of the list
	 * Space Complexity = O(1)
	 */
	private Node removeDuplicate(Node listHead) {
		Node previous = null;
		Node node = listHead;
		
		while (node != null) {
			Node iterator = listHead;
			
			boolean hasDuplicate = false;
			while (iterator.hashCode() != node.hashCode() && !hasDuplicate) {
				if (iterator.value == node.value) {
					hasDuplicate = true;
				}
				iterator = iterator.next;
			}
			
			if (hasDuplicate) {
				previous.next = node.next;
			} else {
				previous = node;
			}
			
			node = node.next;
		}
		
		return listHead;
	}
	
	private boolean test() {
		Node node = listHead;
		HashSet<Integer> set = new HashSet<Integer>();
		
		while (node != null) {
			int value = node.value;
			
			if (set.contains(value)) {
				return false;
			}
			
			set.add(value);
			node = node.next;
		}
		
		return true;
	}

	private void initialize(){
		Node dummy = new Node(-1);
		Node node  = dummy;
		
		for(int i = 0; i < SIZE; i++){
			node.next = new Node((int)(Math.random() * MAXIMUM));
			node = node.next;
		}
		
		listHead = dummy.next;
	}
	
	private class Node {
		int value;
		Node next;
		
		Node(int value) {
			this.value = value;
		}
	}
}
