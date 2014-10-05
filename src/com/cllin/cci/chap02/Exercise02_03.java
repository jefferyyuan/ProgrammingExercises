package com.cllin.cci.chap02;

import java.util.ArrayList;

import com.cllin.main.Exercise;

/*
 * Implement an algorithm to delete a node in the middle of a single linked list, given only access to that node.
 * 
 * For example:
 *         Input: the node 'c' from the linked list a -> b -> c -> d -> e
 *         Result: nothing is returned, but the new linked list looks like a -> b -> d -> e
 */

public class Exercise02_03 extends Exercise {
    private final int SIZE = 100;
    private final int MAXIMUM = 1000;
    
    private Node listHead;
    private ArrayList<Integer> reference;
    
    @Override
    protected void initialize() {
        reference = new ArrayList<Integer>();
        Node dummy = new Node(-1);
        Node node  = dummy;
        
        for (int i = 0; i < SIZE; i++) {
            int n = (int)(Math.random() * MAXIMUM);
            
            reference.add(n);
            node.next = new Node(n);
            node = node.next;
        }
        
        listHead = dummy.next;	
    }

    @Override
    protected void runExercise() {
	return;
    }

    @Override
    protected void test() {
	final int nTests = 10;
        for (int count = 0; count < nTests; count++) {
//          get the node
            int i = 0;
            int index = (int)(Math.random() * (SIZE - count - 1));
            
            Node node = listHead;
            while (i < index) {
                i++;
                node = node.next;
            }
            
//          remove node from the list and the reference
            remove(node);
            reference.remove(index);
            
//          test if the result is correct
            i = 0;
            node = listHead;
            while (node != null) {
                if (node.value != reference.get(i)) {
                    System.out.println("Failed");
                    return;
                }
                
                i++;
                node = node.next;
            }
        }
        
        System.out.println("Success!");	
    }
    
    /*
     * Note that this question has no solution when node is the last element.
     * 
     * Using node = null does not make the node null, 
     * because node is passed to the method as a reference, not an object.
     */
    private boolean remove(Node node) {
        if (node == null || node.next == null) return false;
        
        Node next = node.next;
        node.value = next.value;
        node.next = next.next;
        
        return true;
    }

    private class Node {
        int value;
        Node next;
        
        Node(int value) {
            this.value = value;
        }
    }
}
