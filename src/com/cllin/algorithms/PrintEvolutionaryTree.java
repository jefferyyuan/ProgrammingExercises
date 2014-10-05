package com.cllin.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Complete the function printTree which takes an arraylist and displays the list in the expected output 
 * 
 * Example input:
 * List<Relation> input = newArrayList();
 * input.add(new Relation("animal", "mammal")); 
 * input.add(new Relation("animal", "bird")); 
 * input.add(new Relation("lifeform", "animal")); 
 * input.add(new Relation("cat", "lion")); 
 * input.add(new Relation("mammal", "cat")); 
 * input.add(new Relation("animal", "fish")); 
 * 
 * TreePrinter.printTree(input);
 * 
 * Expected output:
 * line 1: lifeform
 * line 2: animal
 * line 3: mammal
 * line 4: cat
 * line 5: lion
 * line 6: bird
 * line 7: fish
 * 
 * Source: http://www.careercup.com/question?id=5074387359236096
 */

public class PrintEvolutionaryTree implements Exercise {

	@Override
	public void run() {
		ArrayList<Relation> input = new ArrayList<Relation>();
		
		input.add(new Relation("animal", "mammal"));
		input.add(new Relation("animal", "bird"));
		input.add(new Relation("lifeform", "animal"));
		input.add(new Relation("cat", "lion"));
		input.add(new Relation("mammal", "cat"));
		input.add(new Relation("animal", "fish"));
		
		printTree(input);
	}
	
	private void printTree(ArrayList<Relation> input) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		HashSet<String> isChildren = new HashSet<String>();
		
		for (Relation relation : input) {
			String parent = relation.parent;
			String child = relation.child;
			
			ArrayList<String> children = (map.containsKey(parent))? map.get(parent) : new ArrayList<String>();
			children.add(relation.child);
			map.put(relation.parent, children);
			
			if (!map.containsKey(child)) map.put(child, new ArrayList<String>());
			isChildren.add(relation.child);
		}
		
		HashSet<String> isNotChildren = new HashSet<String>(map.keySet());
		isNotChildren.removeAll(isChildren);
		
		if (isNotChildren.isEmpty()) return;

		for (String root : isNotChildren) {
			traversal(root, map);
		}
	}
	
	private void traversal(String parent, HashMap<String, ArrayList<String>> map) {
		System.out.println(parent);
		for (int i = 0; i < map.get(parent).size(); i++) {
			traversal(map.get(parent).get(i), map);
		}
	}

	private static class Relation {
		String parent;
		String child;
		
		Relation(String parent, String child) {
			this.parent = parent;
			this.child = child;
		}
	} 
}
