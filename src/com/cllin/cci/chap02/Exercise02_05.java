package com.cllin.cci.chap02;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Given a circular linked list, implement an algorithm which returns node at the beginning of the loop.
 * 
 * Definition of Circular linked list:
 *         A (corrupt) linked list in which a node’s next pointer points to an earlier node, so as to make a loop in the linked list.
 * 
 * For example,
 *         Input: A -> B -> C -> D -> E -> C [the same C as earlier]
 *         Output: C
 */

public class Exercise02_05 extends Exercise {
    private final int SIZE = 3;
    private final int CYCLE_BEGINNING = 2;
    
    private LinkedList<TestCase> testSuite;
    
    @Override
    protected void initialize() {
        testSuite = new LinkedList<TestCase>();
        
//      Case 1: No cycle
	Node dummyA = new Node();
        Node nodeA = dummyA;
        for (int i = 0; i < SIZE; i++) {
            nodeA.next = new Node();
            nodeA = nodeA.next;
        }
        testSuite.add(new TestCase(dummyA.next, null));
      
//      Case 2: Cycle
        Node dummyB = new Node();
        Node nodeB = dummyB;
        Node cycleBeginning = null;
        for (int i = 0; i < SIZE; i++) {
            nodeB.next = new Node();
            nodeB = nodeB.next;
          
            if (i == CYCLE_BEGINNING) cycleBeginning = nodeB;
        }
        nodeB.next = cycleBeginning;
        testSuite.add(new TestCase(dummyB.next, cycleBeginning));
    }

    @Override
    protected void runExercise() {
        for (TestCase test : testSuite) {
            Node result = getBeginning(test.list);
            
            System.out.printf("%s%n", (result == test.beginning)? "Success!" : "Failed");
        }        
    }

    @Override
    protected void test() {
	return;
    }
    
//  use two pointers, a fast one and a slow one
    private Node getBeginning(Node head) {
        Node a = head;
        Node b = head;
        
        while (a != null && b != null) {
            if (a.next == null) return null;

            a = a.next.next;
            b = b.next;
            
            if (a == null) return null;
            if (a.hashCode() != b.hashCode()) break;
        }
        
        a = head;
        while (a != null && b != null) {
            if (a.hashCode() == b.hashCode()) return a;
            
            a = a.next;
            b = b.next;
        }
        
        return null;
    }
    
    private class Node {
        Node next;
        Node() {
            next = null;
        }
    }
    
    private class TestCase {
        Node list;
        Node beginning;
        
        TestCase (Node list, Node beginning) {
            this.list = list;
            this.beginning = beginning;
        }
    }
}
