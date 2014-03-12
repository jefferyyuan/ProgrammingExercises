package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class BinaryTreeZigzagLevelOrderTraversal implements LeetCodeExercise {
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
	public void runExercise() {
		initialize();
		result = zigzagLevelOrder(tree.root);
		test();
	}
	
	private ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node root) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	ArrayList<Node> list = new ArrayList<Node>();
    	LinkedList<Node> queue = new LinkedList<Node>();
    	
    	if (root == null) return result;
    	
//    	Get all elements in an ArrayList<Node>
    	ArrayList<Integer> counts = new ArrayList<Integer>();
    	int index = 0;
    	int count = 0;
    	int nextLevelCount = 0;
    	
    	queue.add(root);
    	counts.add(1);
    	
    	while (queue.size() > 0) {
    		Node n = queue.pollFirst();
    		list.add(n);
    		count++;
    		
    		if (n.left != null) {
    			queue.add(n.left);
    			nextLevelCount++;
    		}
    		
    		if (n.right != null) {
    			queue.add(n.right);
    			nextLevelCount++;    			
    		}
    		
    		if (count == counts.get(index)) {
    			counts.add(nextLevelCount);
    			nextLevelCount = 0;
    			count = 0;
    			index++;
    			list.add(new Node(-2147483648));
    		}
    	}
    	
//    	Sort the array by level of the node
    	int size = list.size();
    	ArrayList<Integer> l = new ArrayList<Integer>();
    	for (int i = 0; i <= size - 2; i++) {
    		Node n = list.get(i);
    		if (n.value == -2147483648) {
    			result.add(l);
    			l = new ArrayList<Integer>();
    		} else {
    			l.add(n.value);
    		}
    	}
    	result.add(l);
    	
    	size = result.size();
    	for (int i = 0; i < size; i++) {
    		if (i % 2 == 1) {
    			int s = result.get(i).size();
    			int bound = s / 2;
    			for (int j = 0; j < bound; j++) {
    				int tmp = result.get(i).get(j);
    				result.get(i).set(j, result.get(i).get(s - j - 1));
    				result.get(i).set(s - j - 1, tmp);
    			}
    		}
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
