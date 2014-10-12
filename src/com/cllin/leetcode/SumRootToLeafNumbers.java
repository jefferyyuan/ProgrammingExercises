package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * 
 *         For example,
 *             1
 *            / \
 *           2   3
 *         The root-to-leaf path 1->2 represents the number 12.
 *         The root-to-leaf path 1->3 represents the number 13.
 * 
 *         Return the sum = 12 + 13 = 25.
 * 
 * Source: http://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 */

public class SumRootToLeafNumbers implements LeetCodeExercise {
    private final int SIZE = 10;
    private final int MAXIMUM = 10;
    
    private int sum = 0;
    private BinarySearchTree tree;
    
    @Override
    public void initialize() {
        tree = new BinarySearchTree();
        tree.buildTree(SIZE, MAXIMUM);
    }

    @Override
    public void run() {
        initialize();
        sum = sumNumbers(tree.root);
        test();
    }
    
    private int sumNumbers(Node root) {
        return traverse(root, 0);
    }

//    Pre-order traversal
    private int traverse(Node node, int sum) {
        if (node == null) return 0;
        
        sum = sum * 10 + node.value;
        
        int leftSum = traverse(node.left, sum);
        int rightSum = traverse(node.right, sum);
        
        return (leftSum + rightSum == 0)? sum : leftSum + rightSum;
    }

    @Override
    public boolean test() {
        System.out.printf("The root-to-leaf path is %d%n", sum);
        return false;
    }

}
