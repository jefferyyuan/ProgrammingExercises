package com.cllin.algorithms;

import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Given a very long list of URLs, find the first URL which is unique (occurred exactly once). 
 * 
 * Source: http://www.careercup.com/question?id=11856466
 */

public class FirstUniqueElement extends Exercise {

    private final String[][] testSuite = {
            {"A", "A", "B", "C", "B", "D", "D", "Q", "A"},
            {"A", "A", "B", "C", "B", "D", "D", "Q", "A", "C"},
            {"A", "A", "B", "C", "B", "D", "D", "Q", "A", "C", "Q"}
    };
    
    private int index;
    private String unique;
    
    private String getFirstUnique(String[] array) {
        HashMap<String, Node> map = new HashMap<String, Node>();
        LinkedList list = new LinkedList();
        
        for (String element : array) {
            if (map.containsKey(element)) {
                Node node = map.get(element);
                
                if (node != null) {
                    list.remove(node);
                    map.put(element, null);
                }
            } else {
                Node node = new Node(element);
                list.add(node);
                map.put(element, node);
            }
        }
        
        return (list.head == null)? null : list.head.element;
    }
    
    private class LinkedList {
        Node head;
        Node tail;
        
        LinkedList() {
            head = null;
            tail = null;
        }
        
        void remove(Node node) {
            if (node.previous == null) {
                head = node.next;
                if (node.next != null) node.next.previous = null;
            } else {
                node.previous.next = node.next;
                if (node.next != null) node.next.previous = node.previous;
            }
            
            if (node.next == null) {
                tail = node.previous;
                if (node.previous != null) node.previous.next = null;
            } else {
                node.next.previous = node.previous;
                if (node.previous != null) node.previous.next = node.next;
            }
        }
        
        void add(Node node) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.previous = tail;
                
                tail = node;
                node.next = null;
            }
        }
    }
    
    private class Node {
        String element;
        Node previous;
        Node next;
        
        Node(String element) {
            this.element = element;
            this.previous = null;
            this.next = null;
        }
    }
    
    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }

    @Override
    protected boolean test() {
        for (index = 0; index < testSuite.length; index++) {
            unique = getFirstUnique(testSuite[index]);

            System.out.print("A = { ");
            for (String n : testSuite[index]) {
                System.out.printf("%s ", n);
            }
            System.out.printf("}%n");

            if (unique == null) {
                System.out.printf("The list does not have unique elements%n");
            } else {
                System.out.printf("The first unique element is %s%n", unique);
            }

            System.out.println("------------------------------");
        }

        return true;
    }
}
