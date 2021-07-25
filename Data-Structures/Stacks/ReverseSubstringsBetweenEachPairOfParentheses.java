/*
1: You are given a string s that consists of lower case English letters and brackets. 
2: Reverse the strings in each pair of matching parentheses, starting from the innermost one.
3: Your result should not contain any brackets.

Example
(abcd) -> dcba
(u(love)i) -> iloveu
(gni(pc(do))ep) -> pepcoding
*/

import java.io.*;
import java.util.*;

public class Main {
    public static String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(ch == ')'){
                Queue<Character> queue = new ArrayDeque<>();
                
                
                while(st.peek() != '('){
                    queue.add(st.pop());
                }
                st.pop();
                
                //reverse filling
                while(queue.size() > 0){
                    st.push(queue.remove());
                }
            }else{
                st.push(ch);
            }
        }
        
        //get ans string in cirrect order
        char[] ans = new char[st.size()];
        for(int i = ans.length - 1; i >= 0; i--){
            ans[i] = st.pop();
        }
        
        return new String(ans);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);
        
    }
}
