package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 * 
 * Nodes are labeled uniquely.
 * We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * 
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * The graph has a total of three nodes, and therefore contains three parts as separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a self-cycle.
 * 
 * Source: http://oj.leetcode.com/problems/clone-graph/
 */

public class CloneGraph extends Exercise {
    
    private UndirectedGraphNode[] testSuite = {
            null,
            new UndirectedGraphNode(1),
            new UndirectedGraphNode(0),
            new UndirectedGraphNode(0)
    };
    
    private int index;
    private UndirectedGraphNode newGraph;

    @Override
    public void initialize() {
        // CASE 0
        
        // CASE 1
        UndirectedGraphNode n0;
        UndirectedGraphNode n1;
        UndirectedGraphNode n2;
        
        n0 = new UndirectedGraphNode(0);
        n1 = testSuite[1];
        n2 = new UndirectedGraphNode(2);
        
        n0.neighbors.add(n1);
        n0.neighbors.add(n2);
        n1.neighbors.add(n0);
        n1.neighbors.add(n2);
        n2.neighbors.add(n2);
        
        // CASE 2
        n0 = testSuite[2];
        n1 = new UndirectedGraphNode(1);
        n2 = new UndirectedGraphNode(2);
        
        n0.neighbors.add(n1);
        n1.neighbors.add(n2);
        n2.neighbors.add(n2);
        
        // CASE 3
        n0 = testSuite[3];
        
        n0.neighbors.add(n0);
        n0.neighbors.add(n0);
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    /*
     * Classic BFS.
     *         1) Create new node if it has never been created
     *         2) For each neighbor, find/create it, then build the link
     */
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        HashSet<Integer> finished = new HashSet<Integer>();
        HashMap<Integer, UndirectedGraphNode> newNodes = new HashMap<Integer, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        queue.add(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            if (finished.contains(n.label)) continue;

            UndirectedGraphNode newNode = newNodes.get(n.label);
            
            if (newNode == null) {
                newNode = new UndirectedGraphNode(n.label);
                newNodes.put(n.label, newNode);
            }
            
            for (UndirectedGraphNode neighbor : n.neighbors) {
                UndirectedGraphNode newNeighbor = newNodes.get(neighbor.label);
                
                if (newNeighbor == null) {
                    newNeighbor = new UndirectedGraphNode(neighbor.label);
                    newNodes.put(newNeighbor.label, newNeighbor);
                }
                
                newNode.neighbors.add(newNeighbor);
                queue.add(neighbor);
            }
            
            finished.add(n.label);
        }
        
        return newNodes.get(node.label);
    }

    @Override
    public boolean test() {
        for (index = 0; index < testSuite.length; index++) {
            newGraph = cloneGraph(testSuite[index]);

            if (testSuite[index] == null && newGraph == null) {
                System.out.println("Success");
                continue;
            }

            if (testSuite[index] == null || newGraph == null) {
                System.out.println("Failed");
                return false;
            }

            LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
            LinkedList<UndirectedGraphNode> newQueue = new LinkedList<UndirectedGraphNode>();

            ArrayList<Integer> visited = new ArrayList<Integer>();
            ArrayList<Integer> newVisited = new ArrayList<Integer>();

            queue.add(testSuite[index]);
            newQueue.add(newGraph);
            
            while (!queue.isEmpty()) {
                UndirectedGraphNode n = queue.pop();

                if (!visited.contains(n.label)) {
                    for (UndirectedGraphNode neighbor : n.neighbors) {
                        queue.add(neighbor);
                    }
                    visited.add(n.label);
                }
            }
            
            while (!newQueue.isEmpty()) {
                UndirectedGraphNode n = newQueue.pop();

                if (!newVisited.contains(n.label)) {
                    for (UndirectedGraphNode neighbor : n.neighbors) {
                        newQueue.add(neighbor);
                    }
                    newVisited.add(n.label);
                }
            }

            if (visited.size() != newVisited.size()) {
                System.out.println("Failed");
                return false;
            }

            int size = visited.size();
            for (int i = 0; i < size; i++) {
                if (visited.get(i) != newVisited.get(i)) {
                    System.out.println("Failed");
                    return false;
                }
            }

            System.out.println("Success");
        }
        
        return true;
    }

    private class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
