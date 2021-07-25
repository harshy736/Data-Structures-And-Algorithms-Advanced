/*
Given a balanced parentheses string S, compute the score of the string based on the following rule:
    () has score 1
    AB has score A + B, where A and B are balanced parentheses strings.
    (A) has score 2 * A, where A is a balanced parentheses string.

Score of ()()() string is 3 => 1 + 1 + 1
Score of (()) string is 2 => 2 * 1
*/

import java.io.*;
import java.util.*;

public class Main {
    public static int scoreOfParentheses(String S) {
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < S.length(); i++){
            if(S.charAt(i) == '('){
                st.push(-1);
            }else{//')'
                int val = 0;
                
                while(st.peek() != -1){
                    val += st.pop();//adding child in the parent
                }
                
                st.pop();
                if(val == 0){
                    st.push(1);//no child exist
                }else{
                    st.push(2 * val);
                }
            }
        }
        
        int score = 0;
        while(st.size() > 0){
            score += st.pop()
        }
        
        return score;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int score = scoreOfParentheses(read.readLine());
        System.out.println(score);
        
    }
}
