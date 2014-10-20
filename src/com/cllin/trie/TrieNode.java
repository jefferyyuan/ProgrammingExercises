package com.cllin.trie;

public class TrieNode {
    private TrieNode parent;
    private TrieNode[] children;
    private char character;
    
    public TrieNode(){
        parent = null;
        children = new TrieNode[0];
    }
    
    public TrieNode(TrieNode parent, char character){
        this.parent = parent;
        this.character = character;
        children = new TrieNode[0];
    }
    
    public TrieNode getParent(){
        return parent;
    }
    
    public char getCharacter(){
        return character;
    }
    
    public TrieNode getChild(char character){
        for(TrieNode trie : children){
            if(trie.getCharacter() == character){
                return trie;
            }
        }
        return null;
    }
    
    public boolean removeChild(char character){
        if(this.getChild(character) == null){
            return false;
        }
        
        TrieNode[] tmp = children;
        int removed = 0;
        for(int i = 0; i < children.length; i++){
            if(children[i].getCharacter() == character){
                removed = i;
                children = new TrieNode[tmp.length - 1];
                for(int j = 0; j < tmp.length - 1; j++){
                    if(j < removed){
                        children[j] = tmp[j];
                    }else{
                        children[j] = tmp[j + 1];
                    }
                }
            }
        }
        
        return true;
    }
    
    public TrieNode[] getAllChildren(){
        return children;
    }
    
    public TrieNode addChild(TrieNode child){
        TrieNode[] buf = children;
        int oldSize = buf.length; 
        children = new TrieNode[oldSize + 1];
        
        for(int i = 0; i < oldSize; i++){
            children[i] = buf[i];
        }
        children[oldSize] = child;
        
        return child;
    }
}
