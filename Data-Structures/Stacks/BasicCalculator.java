/*
Given a string s representing an expression, implement a basic calculator to evaluate it.
*/

import java.io.*;
import java.util.*;

public class Main {

    public static int calculate(String s){
        int sum = 0, sign = 1;//sign -> +1 for positive, -1 for negative
        
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                int val = 0;
                
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;//staying for non digit character bcz i++ by loop -> stays at i
                sum += sign * val;
                sign = 1;//by deafult + for future
            }else if(ch == '('){//solve inside the bracket
                st.push(sum);//sum before (
                st.push(sign);//sign outside parenthesis
                sum = 0;
                sign = +1;
            }else if(ch == ')'){
                sum *= st.pop();//with sign
                sum += st.pop();//previous sum
            }else if(ch == '-'){
                sign *= -1;//toggle sign
            }
        }
        
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int result = calculate(read.readLine());
        System.out.println(result);
        
    }
}
