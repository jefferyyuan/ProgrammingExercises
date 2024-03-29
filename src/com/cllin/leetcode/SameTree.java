package com.cllin.leetcode;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 * 
 * Source: http://oj.leetcode.com/problems/same-tree/
 */

public class SameTree extends Exercise {
    private final int MAXIMUM = 100;
    private final int SIZE = 100;
    
    private BinarySearchTree tree;
    private BinarySearchTree treeCopy;
    private BinarySearchTree tree2;
    
    private boolean result1 = false;
    private boolean result2 = false;
    private boolean result3 = false;
    
    @Override
    public void initialize() {
        tree = new BinarySearchTree();
        treeCopy = new BinarySearchTree();
        tree2 = new BinarySearchTree();
        
        for(int i = 0; i < SIZE; i++){
            int value = (int)(Math.random() * MAXIMUM);
            tree.insert(new Node(value, null, null, null));
            treeCopy.insert(new Node(value, null, null, null));
            
            tree2.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
        }

    }

    @Override
    protected void runExercise() {
        initialize();
        
        result1 = isSameTree(tree.root, treeCopy.root);
        result2 = isSameTree(tree2.root, treeCopy.root);
        result3 = isSameTree(tree.root, tree2.root);
        
        if (test()) System.out.println("Success"); 
        else System.out.println("Failed");
    }
    
    private boolean isSameTree(Node p, Node q){
        return isSameNode(p, q);
    }
    
    private boolean isSameNode(Node p, Node q){
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.value != q.value) return false;
        
        return isSameNode(p.left, q.left) && isSameNode(p.right, q.right);
    }
    
    @Override
    public boolean test() {
        if (!result1 || result2 || result3) return false; 
        return true;
    }

}
