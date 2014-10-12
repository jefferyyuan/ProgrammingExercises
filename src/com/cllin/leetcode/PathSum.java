package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary tree and a sum, 
 * determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * Source: http://oj.leetcode.com/problems/path-sum/
 */

public class PathSum implements LeetCodeExercise {
    private final int MAXIMUM = 10;
    private final int SIZE = 10;
    
    private BinarySearchTree tree;
    
    @Override
    public void initialize() {
        tree = new BinarySearchTree();
        tree.buildTree(SIZE, MAXIMUM);
    }

    @Override
    public void run() {
        initialize();
        for (int sum = 0; sum < 50; sum++) {
            System.out.printf("The tree %s a root-to-leaf whose sum is %d%n", 
                    (hasPathSum(tree.root, sum))? "has" : "does not have", sum);
        }
    }
    
    private static boolean hasPathSum(Node root, int sum) {
        return traverse(root, 0, sum);
    }
    
    private static boolean traverse(Node node, int sum, int target) {
        if (node == null) return false;
        
        if (node.left == null && node.right == null) return sum + node.value == target;
        
        return traverse(node.left, sum + node.value, target) || traverse(node.right, sum + node.value, target);
    }

    @Override
    public boolean test() {
        // TODO Auto-generated method stub
        return false;
    }

}
