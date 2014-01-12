package com.cllin.chap04;

import com.cllin.main.Exercise;

public class Exercise04_05 implements Exercise {

	@Override
	public void runExercise() {
		// TODO Auto-generated method stub
	}
	
//	private TreeNode getNextNode(TreeNode node){
//		TODO
//		if (node == null) return null;
//		
//		if(node.getParent() == null){
//			TreeNode leftChild = node.getRightChild();
//			while(leftChild.getLeftNode() != null){
//				leftChild = leftChild.getLeftNode();
//			}
//			return leftChild;
//		}
//		
//		if(node.isLeaf()){
//			if(node.hashCode() == node.getParent().getLeftNode().hashCode()){
//				return node.getParent();
//			}else{
//				TreeNode parent = node.getParent();
//				while(parent.getValue() <= node.getValue()){
//					parent = parent.getParent();
//				}
//				return parent;
//			}
//		}else{
//			return (node.getParent().getValue() > node.getRightChild().getValue())? 
//					node.getRightChild() : node.getParent();
//		}
//		return null;
//	}

}
