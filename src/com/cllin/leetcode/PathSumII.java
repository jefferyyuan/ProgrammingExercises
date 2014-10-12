package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * 
 * Source: http://oj.leetcode.com/problems/path-sum-ii/
 */

public class PathSumII implements LeetCodeExercise {
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
            result = pathSum(tree.root, sum);
            
            System.out.printf("For sum = %d,%n", sum);
            for (ArrayList<Integer> path : result) {
                int size = path.size();
                for (int i = 0; i < size; i++) {
                    System.out.printf("->%d", path.get(i));
                }
                System.out.println("\n*********");
            }
            System.out.println("---------------------");
            System.out.println("---------------------");
        }
    }
    
    private ArrayList<ArrayList<Integer>> result;
    private ArrayList<ArrayList<Integer>> pathSum(Node root, int target) {
        result = new ArrayList<ArrayList<Integer>>();
        
        traverse(root, 0, target, new ArrayList<Integer>());
        return result;
    }
    
    private void traverse(Node node, int sum, int target, ArrayList<Integer> path) {
        if (node == null) return;
        
        path.add(node.value);
        
        if (node.left == null && node.right == null) {
            if (sum + node.value == target) result.add(path);
        }
        
        traverse(node.left, sum + node.value, target, new ArrayList<Integer>(path)); 
        traverse(node.right, sum + node.value, target, new ArrayList<Integer>(path));
    }

    @Override
    public boolean test() {
        // TODO Auto-generated method stub
        return false;
    }

}
