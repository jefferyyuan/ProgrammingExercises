package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.Node;

/*
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Source: http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */

public class PopulatingNextRightPointersInEachNodeII implements
        LeetCodeExercise {

    private TreeLinkNode root;
    
    @Override
    public void initialize() {
        root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
    }

    @Override
    public void run() {
        initialize();
        connect(root);
        
        test();
    }
    
    private void connect(TreeLinkNode node) {
        if (node == null) return;

        TreeLinkNode next = node.next;
        while (next != null) {
            if (next.left != null) {
                next = next.left;
                break;
            }
            
            if (next.right != null) {
                next = next.right;
                break;
            }
            
            next = next.next;
        }
        
        if (node.right != null) {
            node.right.next = next;
        }
        
        if (node.left != null) {
            node.left.next = (node.right == null)? next : node.right;
        }
        
        connect(node.left);
        connect(node.right);
    }

    @Override
    public boolean test() {
        // TODO Auto-generated method stub
        return false;
    }
    
    private class TreeLinkNode extends Node {
        TreeLinkNode left, right, next;
        
        public TreeLinkNode(int key) {
            super(key);
        }
    }

}
