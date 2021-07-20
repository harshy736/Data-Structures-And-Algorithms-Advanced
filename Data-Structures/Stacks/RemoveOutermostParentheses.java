/*
1. You are given a valid parentheses string in form of A+B+C... where A, B and C are valid primitive strings.
2. A primitive string is a valid parentheses string which cant is split in s = x+y, with x and y nonempty valid parentheses strings.
3. You have to remove the outermost parentheses from all primitive strings.

Example "(()())(())" = "(()())" + "(())".
removing outermost parentheses from "(()())" and "(())" will result in ()()().
*/

import java.io.*;
import java.util.*;

public class Main {
  public static String removeOuterParentheses(String s) {
    // write your code here
    Stack<Character> st = new Stack<>();
    String ans = "";
    
    for(int i = 0; i < s.length(); i++){
        char ch = s.charAt(i);
        
        if(ch == '('){
            if(st.size() > 0){//outermost ( exist
                ans += ch;
            }
            st.push(ch);
        }else{//ch == ')'
            st.pop();
            if(st.size() > 0){//outermost ( exist
                ans += ch;
            }
        }
        
    }
    
    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String result = removeOuterParentheses(read.readLine());
    System.out.println(result);
  }
}
