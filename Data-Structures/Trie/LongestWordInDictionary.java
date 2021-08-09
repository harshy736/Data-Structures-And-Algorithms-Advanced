/*
1. Given an array of strings words.
2. Find the word of longest length, where all of its substrings starting from 0th index exists as different word in array.
3. If there are multiple answers with same length return one which is smallest in lexicographical order. If there is no valid string return empty string.
*/

import java.io.*;
import java.util.*;

public class Main {
    
  public static class Node{
      Node[] children = new Node[26];//for all alphabets
      String str;//which ends on +nt node
  }
  
  public static void insert(Node curr, String s){
      for(int i = 0; i < s.length(); i++){
          char ch = s.charAt(i);
          
          if(curr.children[ch - 'a'] == null){//alp not +nt as child
              curr.children[ch - 'a'] = new Node();
          }
          
          curr = curr.children[ch - 'a'];
      }
      
      //save string on the terminating node
      curr.str = s;
  }
  
  
  public static void dfs(Node curr){
     
      for(int i = 0; i < 26; i++){
          Node child = curr.children[i];
          
          if(child != null && child.str != null){
              if(child.str.length() > ans.length()){
                  ans = child.str;
              }
              
              dfs(child);
          }
      }
      
  }


  static String ans = "";
  public static String longestWord(String[] words) {
        Node root = new Node();
        
        for(String s : words){
            insert(root, s);
        }
        
        dfs(root);//depth first search
        //& find answer string
        
        return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    String[]words = new String[n];

    for (int i = 0; i < n; i++) {
      words[i] = read.readLine();
    }

    String result = longestWord(words);
    System.out.println(result);

  }
}
