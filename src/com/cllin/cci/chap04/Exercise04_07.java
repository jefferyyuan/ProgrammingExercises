package com.cllin.cci.chap04;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1.
 */

public class Exercise04_07 extends Exercise {
    private final int MAXIMUM = 3;
    private final int SIZE_1 = 5;
    private final int SIZE_2 = 100;
    
    private BinarySearchTree tree1;
    private BinarySearchTree tree2;
    
    private boolean isSubtree(BinarySearchTree tree, BinarySearchTree subTree) {
        return (subTree == null)? true : compareNode(tree.root, subTree.root);
    }
    
    private boolean compareNode(Node tree, Node subTree){
        if (tree == null) return false;
        
        if (tree.value == subTree.value && matchTree(tree, subTree)) return true;
        
        return compareNode(tree.left, subTree) || compareNode(tree.right, subTree);
    }
    
    private boolean matchTree(Node tree, Node subTree) {
        if (tree == null && subTree == null) return true;
        if (tree == null || subTree == null) return false;
        if (tree.value != subTree.value) return false;
        
        return matchTree(tree.left, subTree.left) && matchTree(tree.right, subTree.right);
    }
    
    @Override
    protected void initialize() {
    tree1 = new BinarySearchTree((int)(Math.random() * MAXIMUM));
    tree2 = new BinarySearchTree((int)(Math.random() * MAXIMUM));
    
    for (int i = 0; i < SIZE_1; i++) {
        tree1.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
    }
    
    for (int i = 0; i < SIZE_2; i++) {
        tree2.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
    }
    }

    @Override
    protected void runExercise() {
    System.out.printf("T2 %s a subtree of T1%n", (isSubtree(tree1, tree2))? "is" : "is not");    
    }

    @Override
    protected void test() {
    return;
    }
}
