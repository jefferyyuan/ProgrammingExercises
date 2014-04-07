package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Populate each next pointer to point to its next right node. 
 * If there is no next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * 
 * Source: http://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */

public class PopulatingNextRightPointersInEachNode implements LeetCodeExercise {

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		connect(new TreeLinkNode(0));
	}
	
    private void connect(TreeLinkNode root) {
        if (root == null) return;
        link(root, null);
    }
    
    private void link(TreeLinkNode node, TreeLinkNode next){
    	if (node == null) return;
    	
    	node.next = next;
    	link(node.left, node.right);
    	
    	if (next == null) link(node.right, null);
    	else link(node.right, next.left);
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

	public class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;
		TreeLinkNode(int x) { val = x; }
	}
}