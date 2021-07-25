/*
1: Given a string s of '(' , ')' and lowercase English characters
2: Your task is to remove the minimum number of parentheses ( '(' or ')') so that the resulting parentheses string is valid and return it.
3: In case of multiple valid strings give precedence in keeping innermost parenthesis.

example
(a(b(c)d) this string has (a(bc)d), (ab(c)d) and a(b(c)d) 3 valid strings.
Among all 3 valid strings a(b(c)d) has the innermost parentheses.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        
        char[] ch = s.toCharArray();
        
        for(int i = 0; i < ch.length; i++){
            if(ch[i] == '('){
                st.push(i);//index of openning bracket
            }else if(ch[i] == ')'){
                if(st.size() == 0){//invalid parenthesis
                    ch[i] = '.';
                }else{
                    st.pop();//pop closest open bracket
                }
            }
        }
        
        while(st.size() > 0){
            ch[st.pop()] = '.';//invalid open
        }
        
        //. -> bracket removed
        
        //get string
        StringBuilder sb = new StringBuilder();
        for(char c : ch){
            if(c != '.'){
                sb.append(c);
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String result = reverseParentheses(read.readLine());
        System.out.println(result);
        
    }
}
