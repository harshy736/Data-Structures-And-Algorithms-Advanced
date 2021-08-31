/*
A trie or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings

Implement the Trie class:
1. Trie(): Initializes the trie object.
2. void insert(String word): Inserts the string word into the trie.
3. boolean search(String word): Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
4. boolean startsWith(String prefix): Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static class Node{
        Node[] children = new Node[26];
        String str;
    }
    
  public static class Trie {
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = root;
        
        for(int i = 0 ; i < word.length(); i++){
            char ch = word.charAt(i);
            Node child = curr.children[ch - 'a'];
            
            if(child == null){
                curr.children[ch - 'a'] = new Node();
            }
            
            curr = curr.children[ch - 'a'];
        }
        curr.str = word;//word ends on this node of last char
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            Node child = curr.children[ch - 'a'];
            
            if(child == null){//char not found which we want
                return false;
            }
            
            curr = child;
        }
        
        //word not terminate on this node -> its a prefix only
        if(curr.str == null)return false;
        
        
        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()){
            Node child = curr.children[ch - 'a'];
            
            if(child == null){
                return false;
            }
            
            curr = child;
        }
        
        return true;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    Trie obj = new Trie();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");

      if (inp[0].equals("insert")) {
        obj.insert(inp[1]);
      } else if (inp[0].equals("search")) {
        System.out.println(obj.search(inp[1]));
      } else if (inp[0].equals("startsWith")) {
        System.out.println(obj.startsWith(inp[1]));
      }
    }

  }
}
