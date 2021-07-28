/*
1. Given a string s, remove duplicate letters so that every letter appears once and only once.
2. You must make sure your result is the first in dictionary order among all possible results.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> st = new Stack<>();
        int[] freq = new int[26];
        boolean[] used = new boolean[26];
        
        //cal freq of chars
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        
        for(char ch : s.toCharArray()){
            freq[ch - 'a']--;//dec freq
            
            if(used[ch - 'a']){//character already used once
                continue;
            }
            
            //if greater char +nt in left & it has more copies -> remove it to make string which is first in  dictionary
            while(st.size() > 0 && st.peek() > ch && freq[st.peek() - 'a'] > 0){
                char rem = st.pop();
                used[rem - 'a'] = false;
            }
            
            
            used[ch -'a'] = true;//char is used
            st.push(ch);//push in stack
        }
        
        char[] str = new char[st.size()];
        for(int i = str.length - 1; i >= 0; i--){
            str[i] = st.pop();
        }
        
        return new String(str);//return in string format
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = removeDuplicateLetters(read.readLine());
        System.out.println(result);
        
    }
}
