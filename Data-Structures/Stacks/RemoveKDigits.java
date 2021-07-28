/*
Given string num representing a non-negative integer num, and an integer k, print the smallest possible integer after removing k digits from num.
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        String num = read.readLine();
        int k = Integer.parseInt(read.readLine());

        // write your code here
        Stack<Character> st = new Stack<>();
        int remove = 0;//no of digits removed
        
        for(char ch : num.toCharArray()){
            while(st.size() > 0 && st.peek() > ch && remove < k){
                //store in increasing order in stack
                st.pop();
                remove++;  
            }
                
            st.push(ch);
        }
        
        while(remove < k){//more digits are in stack -> remove from last/top
            st.pop();
            remove++;
        }
        
        if(st.size() == 0){//updated number = 0
            System.out.println(0);
            return;
        }
        
        char[] str = new char[st.size()];
        
        for(int i = str.length - 1; i >= 0; i--){
            str[i] = st.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        
        int i = 0;
        while(str[i] == '0'){//remove leading zeroes
            i++;
        }
        
        while(i < str.length){
            sb.append(str[i]);
            i++;
        }
        
        System.out.println(sb);
    }
}
