import java.io.*;
import java.util.*;

public class Main {
    
  public static class Node {
    Node[] children;
    boolean isEnd;

    Node() {
        children = new Node[26];
    }
  }
  
  
  public static class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node();
            
            curr = curr.children[ch - 'a'];
        }
        
        curr.isEnd = true;//word end on this node
    }
    
    
    
    public boolean searchHelper(Node curr, String word, int idx) {
            if (idx == word.length())//word found
                return curr.isEnd;
            
            char ch = word.charAt(idx);
            if (ch == '.') {//any character
                for (int i = 0; i < 26; i++){
                    Node child = curr.children[i];
                    if (child!=null && searchHelper(child,word,idx + 1))
                        return true;
                }
            } else {
                if (curr.children[ch - 'a'] == null)//not found
                    return false;
                else
                    return searchHelper(curr.children[ch - 'a'], word, idx + 1);
            }
            
            return false;
        }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }
  }


  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    WordDictionary obj = new WordDictionary();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");

      if (inp[0].equals("addWord")) {
        obj.addWord(inp[1]);
      } else if (inp[0].equals("search")) {
        System.out.println(obj.search(inp[1]));
      }
    }

  }
}
