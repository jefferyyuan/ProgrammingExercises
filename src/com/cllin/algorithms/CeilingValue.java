package com.cllin.algorithms;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * A binary search tree is given. Find the ceiling value present in the BST of a given key.
 * 
 * Source: http://www.careercup.com/question?id=20229674
 */

public class CeilingValue extends Exercise {

    private final int SIZE = 30;
    private final int MAXIMUM = 100;
    
    private int ceilingValue;
    private int target;
    private BinarySearchTree tree;
    
    private int getCeilingValue(Node node, int target, int ceiling) {
        if (node == null) return ceiling;
        
        int result = ceiling;
        if (node.value <= target) {
            result = getCeilingValue(node.right, target, ceiling);
        } else {
            result = getCeilingValue(node.left, target, node.value);
        }
        
        return result;
    }
    
    @Override
    protected void initialize() {
        tree = new BinarySearchTree();
        tree.buildTree(SIZE, MAXIMUM);

        ceilingValue = Integer.MIN_VALUE;
        target = (int) (Math.random() * MAXIMUM);
    }

    @Override
    protected void runExercise() {
        ceilingValue = getCeilingValue(tree.root, target, ceilingValue);
    }

    @Override
    protected void test() {
        if (ceilingValue == Integer.MIN_VALUE) {
            System.out.printf("Cannot find any number larger than %d in the tree%n", target);
            return;
        }

        System.out.printf("The ceiling value of %d is %d%n", target, ceilingValue);
    }
}
