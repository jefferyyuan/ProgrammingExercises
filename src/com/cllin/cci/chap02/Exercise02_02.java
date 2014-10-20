package com.cllin.cci.chap02;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Implement an algorithm to find the n-th to last element of a singly linked list.
 * In another word, find the n-th element from the tail.
 */

public class Exercise02_02 extends Exercise {
    private final int SIZE = 1000;
    private final int MAXIMUM = 500;
    
    private int n;
    private Node listHead;
    private Node result;
    private LinkedList<Integer> reference;

    @Override
    protected void initialize() {
        reference = new LinkedList<Integer>();
        
        Node dummy = new Node(-1);
        Node node  = dummy;
        
        for (int i = 0; i < SIZE; i++) {
            int value = (int)(Math.random() * MAXIMUM);
            
            reference.add(value);
            node.next = new Node(value);
            node = node.next;
        }
        
        listHead = dummy.next;        
    }

    @Override
    protected void runExercise() {
    n = (int) (Math.random() * SIZE);
    result = getNToLast(listHead, n);
    }

    @Override
    protected boolean test() {
        System.out
                .printf("%s%n", (result.value == reference.get(SIZE - n)) ? "Success!" : "Failed");
        return result.value == reference.get(SIZE - n);
    }
    
    private Node getNToLast(Node list, int n) {
        if (list == null) return null;
        
        // use two pointers
        Node node1 = list;
        Node node2 = list;
        
        int count = 1;
        while (count < n) {
            if (node2 == null) return null;
            
            node2 = node2.next;
            count++;
        }
        
        // right now, node2 is at the n-th element,
        // (l - n) elements away from the tail, l is the lenght of the list
        //
        // move node1 to the (l - n)-th,
        // it will be (l - (l - n)) = n elements away from the tail
        while (node2.next != null) {
            node1 = node1.next;
            node2 = node2.next;
        }
        
        return node1;
    }
    
    private class Node {
        int value;
        Node next;
        
        Node(int value) {
            this.value = value;
        }
    }
}