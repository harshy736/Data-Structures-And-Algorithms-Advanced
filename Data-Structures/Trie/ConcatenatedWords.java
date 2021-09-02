/*
Given an array of strings words, return all the concatenated words in the given list of words.
Concatenated word is a word that can be created by concatination of at least two other shorter words from the list.

You can return concatination words in any order
*/

import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Node[] children;
        String str;
        boolean added;

        Node() {
            children = new Node[26];
        }
    }
    
    static Node root;
    
    private static void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node();
            curr = curr.children[ch - 'a'];
        }
        curr.str = word;
    }
    
    //curr is smallest word
    //nword new other word which adds in curr until nword exists
    //if after addition of other word(nword) curr ends -> this word exist in list
    //if other word finish -> take curr as it is -> start adding other word starting from root
    public static void search(Node curr, Node nword){
        //both word finish -> conacta word = curr
        if(curr.str != null && nword.str != null){
            if(curr.added == false){
                list.add(curr.str);
                curr.added = true;
            }
        }
        
        if(nword.str != null){//small word completed
            search(curr, root);
        }
        
        for(int i = 0; i < 26; i++){
            //if both conatins same char -> move pointer of both by 1
            if(curr.children[i] != null && nword.children[i] != null){
                search(curr.children[i], nword.children[i]);
            }
        }
    }
    
    
    public static void search1(Node curr){
        if(curr.str != null){//word finish on curr
            search(curr, root);//to form new concat word
        }
        
        for(Node child : curr.children){
            if(child != null){
                search1(child);
            }
        }
    }
    
    static List<String> list = new ArrayList<String>();
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words.length <= 1)
            return list;
        
        root = new Node();
        
        for(String word : words){
            insert(word);
        }
        
        search1(root);//find smallest word
        
        return list;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());

        String[]words = new String[n];

        for(int i=0;i<n;i++){
            words[i] = read.readLine();
        }

        List<String> result = findAllConcatenatedWordsInADict(words);
        Collections.sort(result);
        PrintWriter out = new PrintWriter(System.out);
        for(String s: result){
            out.println(s);
        }
        out.close();
    }
}
