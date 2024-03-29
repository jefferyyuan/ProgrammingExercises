package com.cllin.algorithms;

import java.util.LinkedList;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class BreadthFirstTraversal extends Exercise {
    private final int MAXIMUM = 10;
    private final int SIZE = 10;
    
    private BinarySearchTree tree;
    
    private void breadFirstTraversal(Node node) {
        if (node == null) return;
        
        LinkedList<Node> queue = new LinkedList<Node>();
        LinkedList<Node> next = new LinkedList<Node>();
        queue.add(node);
        
        
        while (!queue.isEmpty()) {
            Node n = queue.pollFirst();
            if (n.left != null) next.add(n.left);
            if (n.right != null) next.add(n.right);
            
            System.out.printf("%d ", n.value);
            if (queue.isEmpty()) {
                queue = next;
                next = new LinkedList<Node>();
                System.out.println();
            }
        }
    }
    
    @Override
    protected void initialize(){
        tree = new BinarySearchTree();
        
        for (int i = 0; i < SIZE; i++) {
            tree.insert(new Node((int)(Math.random() * MAXIMUM), null, null, null));
        }
    }

    @Override
    protected void runExercise() {
        breadFirstTraversal(tree.root);
    }

    @Override
    protected boolean test() {
        return true;
    }

}
