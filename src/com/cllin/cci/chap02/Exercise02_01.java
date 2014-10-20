package com.cllin.cci.chap02;

import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Write code to remove duplicates from an unsorted linked list.
 * 
 * FOLLOW UP: How would you solve this problem if a temporary buffer is not allowed?
 */

public class Exercise02_01 extends Exercise {
    private final int SIZE = 1000;
    private final int MAXIMUM = 10000;
    
    private Node listHead;
    
    @Override
    protected void initialize() {
        Node dummy = new Node(-1);
        Node node  = dummy;
        
        for(int i = 0; i < SIZE; i++){
            node.next = new Node((int) (Math.random() * MAXIMUM));
            node = node.next;
        }
        
        listHead = dummy.next;    
    }

    @Override
    protected void runExercise() {
        listHead = removeDuplicate(listHead);
    }

    @Override
    protected boolean test() {
        Node node = listHead;
        HashSet<Integer> set = new HashSet<Integer>();
        
        while (node != null) {
            int value = node.value;
            
            if (set.contains(value)) {
                System.out.println("Failed");
                return false;
            }
            
            set.add(value);
            node = node.next;
        }

        System.out.println("Success!");
        return true;
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
            while (iterator != node && !hasDuplicate) {
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
    
    private class Node {
        int value;
        Node next;
        
        Node(int value) {
            this.value = value;
        }
    }
}
