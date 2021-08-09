/*
1. You are given a string s determine if it is valid or not.
2. A valid string is a string that can be created by inserting abc at any index any number of times.

Example:
aabcbc can be created 
"" -> "abc" -> "aabcbc"

while it is impossible to create abccba.

*/

import java.io.*;
import java.util.*;

public class Main {
  public static boolean isValid(String S) {
    // write your code here
    Stack<Character> st = new Stack<>();
    
    for(int i = 0; i < S.length(); i++){
        char ch = S.charAt(i);
        
        if(ch == 'c'){
            //pair exists -> ab exists for c
            if(st.size() >= 2&& st.pop() == 'b' && st.pop() == 'a'){
              
            }else{//ab not found -> invalid
                return false;
            }
        }else{
            st.push(ch);;
        }
    }

    return st.size() == 0;//empty stack -> means all are in abc form
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    boolean result = isValid(read.readLine());
    System.out.println(result);

  }
}
