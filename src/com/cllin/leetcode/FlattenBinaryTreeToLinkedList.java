package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * Source: http://oj.leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList implements LeetCodeExercise {
    private final int SIZE = 5;
    private final int MAXIMUM = 10;
    
    private BinarySearchTree tree;
    
    @Override
    public void initialize() {
        tree = new BinarySearchTree();
        tree.buildTree(SIZE, MAXIMUM);
    }

    @Override
    public void run() {
        initialize();
        flatten(tree.root);
    }
    
    private void flatten(Node root) {
        traversal(root);
    }
    
    /*
     * 1. Flatten left tree
     *         IF node.left == null
     *             1) Link node.right to the tail of the flatten left tree
     *             2) Set node.right as the head of the flatten left tree
     *         ELSE    Set tail as node
     * 
     * 2. Flatten right tree
     *         IF node.right != null
     *             Set tail as the tail of the flatten right tree
     * 3. Return tail
     */
    private static Node traversal(Node node) {
        if (node == null) return null;
        
        Node right = node.right;
        Node tail = null;
        
        if (node.left != null) {
            tail = traversal(node.left);
            
            tail.right = right;
            node.right = node.left;
            node.left = null;
        } else {
            tail = node;
        }
        
        if (right != null) tail = traversal(right);
        
        return tail;
    }

    @Override
    public boolean test() {
        return true;
    }

}
