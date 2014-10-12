package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * Source: http://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 */

public class BinaryTreeLevelOrderTraversal extends LeetCodeExercise {
    private final int SIZE = 10;
    private final int MAXIMUM = 10;
    
    private BinarySearchTree tree;
    private ArrayList<ArrayList<Integer>> result;
    
    @Override
    public void initialize() {
        tree = new BinarySearchTree();
        tree.buildTree(SIZE, MAXIMUM);
    }

    @Override
    public void run() {
        initialize();
        result = levelOrder(tree.root);
        test();
    }
    
    private ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        LinkedList<Node> thisLevel = new LinkedList<Node>();
        LinkedList<Node> nextLevel = new LinkedList<Node>();
        
        if (root == null) return result;
        
        thisLevel.add(root);
        while (!thisLevel.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<Integer>();
            
            while (!thisLevel.isEmpty()) {
                Node n = thisLevel.pop();
                
                if (n.left != null) nextLevel.add(n.left);
                if (n.right != null) nextLevel.add(n.right);
                
                level.add(n.value);
            }
            
            result.add(level);
            thisLevel = nextLevel;
            nextLevel = new LinkedList<Node>();
        }
        
        return result;
    }

    @Override
    public boolean test() {
        for (ArrayList<Integer> level : result) {
            for (int n : level) System.out.printf("%d ", n);
            System.out.println();
        }
        
        return false;
    }
}
