package com.cllin.tree;


/*
 *	An interface should be implemented between the user and the tree
 *	User should not (and does not want to) access to the tree and the node
 */
public class BinarySearchTree {
	public Node root;
	private int size;
	
	public BinarySearchTree(int key){
		root = new Node(key, null, null, null);
		size = 0;
	}
	
	public void insert(Node node){
		Node x = root;
		Node y = null;
		
		while(x != null){
			y = x;
			if(node.key < x.key){
				x = x.left;
			}else{
				x = x.right;
			}
		}
		
		node.parent = y;
		
		if(y == null){
			root = node;
		}else if(node.key < y.key){
			y.left = node;
		}else{
			y.right = node;
		}
		size++;
	}
	
	public void delete(Node node){
		if(node == null){
			return;
		}
		
		if(node.left == null){
			transplant(node, node.right);
		}else if(node.right == null){
			transplant(node, node.left);
		}else{
			Node successor = getSuccessor(node);
			if(successor.parent != node){
				transplant(successor, successor.right);
				successor.right = node.right;
				successor.right.parent = successor;
			}
			
			transplant(node, successor);
			successor.left = node.left;
			successor.left.parent = successor;
		}
		size--;
	}
	
	public int getSize(){
		return size;
	}
	
	public void inOrderTreeWalk(Node node){
		if(node != null){
			inOrderTreeWalk(node.left);
			node.printNode();
			System.out.print(" ");
			inOrderTreeWalk(node.right);
		}
	}
	
	public Node getMinimum(Node node){
		while(node.left != null){
			node = node.left;
		}
		return node;
	}
	
	public Node getMaximum(Node node){
		while(node.right != null){
			node = node.right;
		}
		return node;
	}
	
	public Node search(Node node, int key){
		if(node == null || node.key == key){
			return node;
		}else if(key > node.key){
			return search(node.right, key);
		}else{
			return search(node.left, key);
		}
	}
	
	public Node getSuccessor(Node node){
		if(node.right != null){
			return getMinimum(node.right);
		}
		
		Node parent = node.parent;
		while(parent != null && node == parent.right){
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	public Node getPredecessor(Node node){
		if(node.left != null){
			return getMaximum(node.left);
		}
		
		Node parent = node.parent;
		while(parent != null && node == parent.left){
			node = parent;
			parent = parent.parent;
		}
		return parent;
	}
	
	private void transplant(Node origin, Node newNode){
		if(origin.parent == null){
			root = newNode;
		}else if(origin == origin.parent.left){
			origin.parent.left = newNode;
		}else{
			origin.parent.right = newNode;
		}
		
		if(newNode != null){
			origin.parent = newNode.parent;
		}
	}
}
