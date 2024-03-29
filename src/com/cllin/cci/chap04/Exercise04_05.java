package com.cllin.cci.chap04;

import java.util.ArrayList;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Find the 'next' node (in-order successor) of a given node in a binary search tree where each node has a link to its parent.
 */

public class Exercise04_05 extends Exercise {
    private final int MAXIMUM = 10000;
    private final int SIZE = 1000;
    
    private int[] reference;
    private BinarySearchTree tree;
    
    private Node node;
    private Node result;
    
    private Node getNextNode(Node node) {
        if (node == null) return null;
        
        if (node.right != null || node.parent == null) return getLeftMostChild(node.right);
        
        if (node.parent.left != null && node.hashCode() == node.parent.left.hashCode()) return node.parent;
        
        Node next = node;
        while (next.parent != null) {
            if (next.parent.left != null && next.hashCode() == next.parent.left.hashCode()) {
                return next.parent;
            }
            
            next = next.parent;
        }
        
        return null;
    }
    
    private Node getLeftMostChild(Node root) {
        if (root == null) return null;
        
        Node node = root;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    
    private ArrayList<Node> inOrderTreeWalk(Node node, ArrayList<Node> list) {
        if (node == null) return list;
        
        inOrderTreeWalk(node.left, list);
        list.add(node);
        inOrderTreeWalk(node.right, list);
        return list;
        
    }

    @Override
    protected void initialize() {
        reference = new int[SIZE];
        tree = new BinarySearchTree();
        
        int index = (int)(Math.random() * SIZE);
        for (int i = 0; i < SIZE; i++) {
            int value = (int) (Math.random() * MAXIMUM);
            
            Node node = new Node(value, null, null, null);
            reference[i] = value;
            
            if (i == index) this.node = node; 
            tree.insert(node);
        }    
    }

    @Override
    protected void runExercise() {
        result = getNextNode(node);    
    }

    @Override
    protected boolean test() {
        ArrayList<Node> sorted = inOrderTreeWalk(tree.root, new ArrayList<Node>());
        
        for (int i = 0; i < sorted.size(); i++) {
            if (sorted.get(i).hashCode() != node.hashCode()) continue;

            if (i == sorted.size() - 1) {
                System.out.printf("%s%n", (result == null) ? "Success" : "Failed");
                return result == null;
            }
            
            System.out.printf("%s%n", (sorted.get(i + 1) == result)? "Success" : "Failed");
            return sorted.get(i + 1) == result;
        }
        
        System.out.println("Failed");
        return false;
    }

}
