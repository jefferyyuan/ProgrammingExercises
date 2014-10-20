package com.cllin.trie;

public class Trie {
    private TrieNode root;
    
    public Trie(){
        root = new TrieNode();
    }
    
    public boolean add(String word){
        TrieNode iter = root;
        while(word.length() != 0){
            if(iter.getChild(word.charAt(0)) == null){
                iter = iter.addChild(new TrieNode(iter, word.charAt(0)));
            }else{
                iter = iter.getChild(word.charAt(0));
            }
            word = word.substring(1);
        }
        
        return true;
    }

    public boolean find(String word){
        String tmp = word;
        TrieNode iter = root;
        while(word.length() != 0){
            if(iter.getChild(word.charAt(0)) == null){
                System.out.println("The word '" + tmp + "' is not found");
                return false;
            }else{
                iter = iter.getChild(word.charAt(0));
            }
            word = word.substring(1);
        }
        System.out.println("The word '" + tmp + "' is found");
        return true;
    }
    
    public boolean delete(String word){
        String tmp = word;
        String buf = word;
        
        if(!find(word)){
            return false;
        }
        
        TrieNode iter = root;
        while(word.length() != 0){
            if(iter.getChild(word.charAt(0)) != null){
                iter = iter.getChild(word.charAt(0));
            }
            word = word.substring(1);
        }
        
        while(iter.getParent() != null){
            if(iter.getChild(tmp.charAt(tmp.length() - 1)) != null){
                iter.removeChild(tmp.charAt(tmp.length() - 1));
            }
            iter = iter.getParent();
            tmp = tmp.substring(0, tmp.length() - 1);
        }
        
        System.out.println("The word '" + buf + "' is deleted");
        return true;
    }
}
