package com.cllin.main;

import com.cllin.trie.Trie;

public class Main {
	private static final int TRIE = 1;
	
	public static void main(String args[]){
		int option = TRIE;

		switch(option){
			case TRIE:
				trie();
				break;
		}
	}
	
	private static void trie(){
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
