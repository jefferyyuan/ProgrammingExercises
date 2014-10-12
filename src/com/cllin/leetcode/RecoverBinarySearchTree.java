package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * 
 * Source: http://oj.leetcode.com/problems/recover-binary-search-tree/
 */

public class RecoverBinarySearchTree implements LeetCodeExercise {
    
    private TreeNode[] testSuite = {
            new TreeNode(0),
            new TreeNode(2),
            new TreeNode(5)
    };
    
    private int index; 

    @Override
    public void initialize() {
//        CASE 0:
        testSuite[0].left = new TreeNode(1);
        
//        CASE 1:
        testSuite[1].left = new TreeNode(3);
        testSuite[1].right = new TreeNode(1);
        
//        CASE 2:
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(7);
        l.left = new TreeNode(0);
        l.right = new TreeNode(6);
        r.left = new TreeNode(3);
        r.right = new TreeNode(9);
        
        testSuite[2].left = l;
        testSuite[2].right = r;
    }

    @Override
    public void run() {
        initialize();
        
        for (index = 0; index < testSuite.length; index++) {
            recoverTree(testSuite[index]);
            test();
        }
    }
    
    /*
     * Iterate the tree, if these is a node in wrong place, store its address.
     * Swap the nodes if there are nodes that are in wrong place.
     */
    private TreeNode first;
    private TreeNode second;
    private TreeNode prev;
    private void recoverTree(TreeNode root) {
        if (root == null) return;
        
        first = null;
        second = null;
        prev = null;
        
        inorderTraversal(root);

        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    
    private void inorderTraversal(TreeNode node) {
        if (node == null) return;
        
        inorderTraversal(node.left);
        
        if (prev == null) prev = node;
        else {
            if (prev.val > node.val) {
                if (first == null) first = prev;
                second = node;
            }
            
            prev = node;
        }
        
        inorderTraversal(node.right);
    }
    
    private void printTree(TreeNode node) {
        if (node == null) return;
        
        printTree(node.left);
        System.out.printf("%d ", node.val);
        printTree(node.right);
    }

    @Override
    public boolean test() {
        printTree(testSuite[index]);
        System.out.println();
        
        return true;
    }
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
