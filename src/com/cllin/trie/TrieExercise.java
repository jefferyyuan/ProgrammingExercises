package com.cllin.trie;

import com.cllin.main.Exercise;

public class TrieExercise implements Exercise {

	@Override
	public void run() {
		String apple = "apple";
		String apartment = "apartment";
		String apart = "apart";
		String aparent = "aparent";
		String android = "android";
		String banana = "banana";
		String mouse = "mouse";
		String stapler = "stapler";
		
		Trie trie = new Trie();
		trie.add(apple);
		trie.add(aparent);
		trie.add(apart);
		trie.add(apartment);
		trie.add(android);
		trie.add(banana);
		
		trie.find(mouse);
		trie.find(stapler);
		trie.find(android);
		trie.find(apple);
		trie.find(banana);
		
		trie.delete(apple);
		trie.find(apple);
	}

}
