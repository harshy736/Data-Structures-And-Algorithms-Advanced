/*
1: Given a string S of '(' and ')' parentheses.
2: You need to find count of minimum number of parentheses '(' or ')' when added in any positions so that the resulting parentheses string is valid.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static int minAddToMakeValid(String S) {
        Stack<Character> st = new Stack<>();
        int count = 0;
        
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            
            if(ch == '('){
                st.push(ch);
            }else{
                if(st.size() > 0){
                    st.pop();
                }else{
                    count++;//corresponding '(' not found
                }
            }
        }
        
        count += st.size();//remaining '(' which can not find corresponding ')'
        
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = minAddToMakeValid(read.readLine());
        System.out.println(result);
    }
}
