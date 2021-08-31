/*
1. You r given an array of string's say dictionary and a long string say sentence.
2. You have to replace all words in sentence which contains a prefix in dictionary with the prefix itself in dictionary.

Example 
dictionary = ["cat","bat","rat"]
sentence = "the cattle was rattled by the battery"

In this sentence cattle, rattled and battery are the words containing prefix in dictionary they are cat, rat and bat.
sentence after replace words is "the cat was rat by the bat".

3. If there are multiple prefix for a word in dictionary replace it with the shortest prefix word.
*/

import java.io.*;
import java.util.*;

public class Main {
  
  static class Node{
    Node[] children;
    boolean isEnd;
    
    Node(){
        children = new Node[26];
    }
  }
  
  
  private static void insert(Node root, String word){
    Node curr = root;
    
    for(char ch : word.toCharArray()){
        if(curr.children[ch - 'a'] == null)
            curr.children[ch - 'a'] = new Node();
            
        curr = curr.children[ch - 'a'];
    }
    //curr -> last char of word
    curr.isEnd = true;
  }
  
  
  private static String findPrefix(Node root, String word){
      Node curr = root;
      StringBuilder sb = new StringBuilder();
      
      for(char ch : word.toCharArray()){
        if(curr.children[ch - 'a'] == null)
            return word;
        
        sb.append(ch);
        curr = curr.children[ch - 'a'];
        
        if(curr.isEnd)
            return sb.toString();
      }
      
      return word;
  }
  
  public static String replaceWords(String dictionary[],String sentence)   {
    Node root = new Node();
    
    for(String prefix : dictionary){
        insert(root, prefix);
    }
    
    //words in the sentence
    String[] words = sentence.split(" ");
    StringBuilder res = new StringBuilder();
    
    for(String word : words){
        res.append(findPrefix(root, word) + " ");
    }
    
    return res.toString();
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    String[]dictionary = new String[n];

    for (int i = 0; i < n; i++) {
      dictionary[i] = read.readLine();
    }

    String sentence = read.readLine();

    String result = replaceWords(dictionary, sentence);
    System.out.println(result);

  }
}
