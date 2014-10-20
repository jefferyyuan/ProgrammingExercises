package com.cllin.cci.chap04;

import java.util.LinkedList;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given a binary search tree, design an algorithm which creates a linked list of all the nodes at each depth.
 */

public class Exercise04_04 extends Exercise {
    private final int MAXIMUM = 100;
    private final int SIZE = 15;
    
    private BinarySearchTree tree;
    private LinkedList<LinkedList<Node>> nodes;
    
    private LinkedList<LinkedList<Node>> getNodeByLevel() {
        LinkedList<LinkedList<Node>> result = new LinkedList<LinkedList<Node>>();
        
        LinkedList<Node> thisLevel = new LinkedList<Node>();
        LinkedList<Node> nextLevel = new LinkedList<Node>();
        
        thisLevel.add(tree.root);
        while (!thisLevel.isEmpty()) {
            LinkedList<Node> level = new LinkedList<Node>();
            
            while (!thisLevel.isEmpty()) {
                
                Node node = thisLevel.poll();
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
                
                level.add(node);
            }
            
            result.add(level);
            thisLevel.addAll(nextLevel);
            nextLevel = new LinkedList<Node>();
        }
        
        return result;
    }

    @Override
    protected void initialize() {
        tree = new BinarySearchTree(SIZE, MAXIMUM);
        nodes = new LinkedList<LinkedList<Node>>();    
    }

    @Override
    protected void runExercise() {
        nodes = getNodeByLevel();
    }

    @Override
    protected boolean test() {
        LinkedList<Integer> result = new LinkedList<Integer>();
        LinkedList<Integer> reference = new LinkedList<Integer>();
        
        LinkedList<Node> thisLevel = new LinkedList<Node>();
        LinkedList<Node> nextLevel = new LinkedList<Node>();
        
        thisLevel.add(tree.root);
        while (!thisLevel.isEmpty()) {
            while (!thisLevel.isEmpty()) {
                Node node = thisLevel.poll();
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
                
                reference.add(node.value);
            }
            
            thisLevel.addAll(nextLevel);
            nextLevel = new LinkedList<Node>();
        }
        
        for (int i = 0; i < nodes.size(); i++) {
            for (int j = 0; j < nodes.get(i).size(); j++) {
                result.add(nodes.get(i).get(j).value);
            }
        }
        
        System.out.printf("%s%n", (result.equals(reference))? "Success!" : "Failed");
        return result.equals(reference);
    }

}
