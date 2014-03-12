package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class PopulatingNextRightPointers implements LeetCodeExercise {

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
