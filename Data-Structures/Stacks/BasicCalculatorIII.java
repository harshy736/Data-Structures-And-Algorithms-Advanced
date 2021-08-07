/*
1. Implement a basic calculator to evaluate a simple expression string.
2. String will contain only non-negative integers, '+', '-', '*', '/' operators, and open '(' and closing parentheses ')'. 
3. All intermediate results will be in the range of [-2^31, 2^31 - 1].
*/

import java.io.*;
import java.util.*;

public class Main {
 
  static class Pair {
     Stack<Integer> st = new Stack<>();
     char sign;
     
     Pair(Stack<Integer> st, char sign){
         this.st = st;
         this.sign = sign;
     }
  }   
 
 
  public static void calculate(Stack<Integer> st, int val, char sign){
    if(sign == '+'){
        st.push(val);
    }else if(sign == '-'){
        st.push(-val);
    }else if(sign == '*'){
        int a = st.pop();
        int ans = a * val;
        st.push(ans);
    }else if(sign == '/'){
        int a = st.pop();
        int ans = a / val;
        st.push(ans);
    }
  }
 
 
  public static int calculate(String s) {
    Stack<Pair> stP = new Stack<>();
    Stack<Integer> st = new Stack<>();
    
    char sign = '+';//default
    
    for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                int val = 0;
                //val complete for any no fo digits 
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                
                calculate(st, val, sign);
            }else if(ch == '('){
                Pair p = new Pair(st, sign);
                stP.push(p);//saving current state
                st = new Stack<>();//new stack for inside parenthesis
                sign = '+';
            }else if(ch == ')'){
                int val = 0;
                while(st.size() > 0){
                    val += st.pop();
                }
                
                Pair rem = stP.pop();
                st = rem.st;//previous stack
                sign = rem.sign;
                
                calculate(st, val, sign);
            }else if(ch != ' '){
                sign = ch;
            }
    }
    
    int sum = 0;
    while(st.size() > 0){//final stack
        sum += st.pop();
    }
    
    return sum;
  }
  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int result = calculate(read.readLine());
    System.out.println(result);

  }
}
