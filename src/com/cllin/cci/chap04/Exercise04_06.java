package com.cllin.cci.chap04;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree.
 * Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
 */

public class Exercise04_06 extends Exercise {
    private final int MAXIMUM = 1000;
    private final int SIZE = 1000;
    
    private BinarySearchTree tree;
    private Node nodeA;
    private Node nodeB;
    
    private Node fcs;
    
    private Node getFirstCommonAncestor(Node node, Node nodeA, Node nodeB){
        if (node == null) return null;
        if (node == nodeA || node == nodeB) return node;
        
        if (getCoveredNodes(node.left, nodeA, nodeB) == 1 && getCoveredNodes(node.right, nodeA, nodeB) == 1) {
            return node;
        } else if (getCoveredNodes(node.left, nodeA, nodeB) == 2) {
            return getFirstCommonAncestor(node.left, nodeA, nodeB);
        } else if(getCoveredNodes(node.right, nodeA, nodeB) == 2) {
            return getFirstCommonAncestor(node.right, nodeA, nodeB);
        }
        
        return null;
    }
    
    private int getCoveredNodes(Node node, Node nodeA, Node nodeB) {
        if (node == null) return 0;
        
        int nCoveredNodes = 0;
        if (node.hashCode() == nodeA.hashCode()) nCoveredNodes++;
        if (node.hashCode() == nodeB.hashCode()) nCoveredNodes++;
        
        nCoveredNodes += getCoveredNodes(node.right, nodeA, nodeB) + getCoveredNodes(node.left, nodeA, nodeB);
        
        return nCoveredNodes;
    }

    @Override
    protected void initialize() {
        int a = (int) (Math.random() * SIZE);
        int b = (int) (Math.random() * SIZE);
        
        while (b == a) {
            b = (int) (Math.random() * SIZE);
        }
        
        tree = new BinarySearchTree((int)(Math.random() * MAXIMUM));
        for (int i = 0; i < SIZE; i++) {
            Node node = new Node((int)(Math.random() * MAXIMUM), null, null, null);
            if (i == a) nodeA = node;
            if (i == b) nodeB = node;
            
            tree.insert(node);
        }    
    }

    @Override
    protected void runExercise() {
    fcs = getFirstCommonAncestor(tree.root, nodeA, nodeB);    
    }

    @Override
    protected void test() {
    System.out.printf("The first common ancestor of %d and %d is %d%n", nodeA.value, nodeB.value, fcs.value);    
    }
}