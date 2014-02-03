package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

import com.cllin.tree.Node;

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
	public void runExercise() {
		initialize();
		connect(root);
		
		test();
	}
	
    private void connect(TreeLinkNode root) {
    	if (root == null) return;
    	
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
        TreeLinkNode node = root;
        
        queue.add(node);
        int count = 0;
        int capacity = 1;
        int nextLevelCapacity = 0;
        
        while (!queue.isEmpty()) {
        	TreeLinkNode n = queue.pollFirst();
        	count++;
        	list.add(n);
        	
        	if (n.left != null) {
        		queue.add(n.left);
        		nextLevelCapacity++;
        	}
        	
        	if (n.right != null) {
        		queue.add(n.right);
        		nextLevelCapacity++;
        	}
        	
        	if (count == capacity) {
        		count = 0;
        		capacity = nextLevelCapacity;
        		nextLevelCapacity = 0;
        		
        		int size = list.size();
        		for (int i = 0; i < size - 1; i++) {
        			list.get(i).next = list.get(i + 1);
        		}
        		list.get(size - 1).next = null;
        		
        		list = new ArrayList<TreeLinkNode>();
        	}
        }
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@SuppressWarnings("unused")
	private class TreeLinkNode extends Node {
		TreeLinkNode left, right, next;
		
		public TreeLinkNode(int key) {
			super(key);
		}
	}

}
