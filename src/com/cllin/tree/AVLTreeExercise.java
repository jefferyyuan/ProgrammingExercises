package com.cllin.tree;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.Exercise;

public class AVLTreeExercise extends Exercise {
    private final int MAXIMUM = 10000;
    private final int SIZE = 10000;
    
    private AVLTree tree;
    private int[] reference = new int[SIZE];
    
    private boolean isSorted() {
        ArrayList<Integer> fromTree = tree.printTree();
        if (fromTree.size() != reference.length) return false;
        
        for (int i = 0; i < fromTree.size(); i++) {
            if (fromTree.get(i).intValue() != reference[i]) return false;
        }
        
        return true;
    }
    
    @Override
    protected void initialize() {
	tree = new AVLTree();
	
        for (int i = 0; i < SIZE; i++) {
            int key = (int)(Math.random() * MAXIMUM);
            tree.insert(key);
            reference[i] = key;
        }
        
        Arrays.sort(reference);	
    }

    @Override
    protected void runExercise() {
        int maximum = tree.getMaximum();
        int minimum = tree.getMinimum();
        int size = tree.getSize();
        boolean isEmpty = tree.isEmpty();
        boolean isSorted = isSorted();

        System.out.printf("The maximum value on the tree is %d%n", maximum);
        System.out.printf("The minimum value on the tree is %d%n", minimum);
        System.out.printf("The size of the tree is %d%n", size);
        System.out.printf("The tree is %s%n", (isEmpty)? "empty" : "not empty");
        System.out.printf("The tree is %s%n", (isSorted)? "sorted" : "not sorted");	
    }

    @Override
    protected void test() {
	return;
    }
}
