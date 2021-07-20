/*
1: Given two sequences pushed and popped with distinct values.
2: You have to return true if and only if this could have been the result of a sequence of push and pop operations on an initially empty stack
*/

import java.io.*;
import java.util.*;

public class Main {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        //we have a chance to change pop pattern only
        Stack<Integer> st = new Stack<>();
        int j = 0;
        
        for(int e : pushed){//push in the pushed array manner
            st.push(e);
            
            //remove when element match with popped array
            while(st.size() > 0 && popped[j] == st.peek()){
                st.pop();
                j++;
            }
        }
        
        return (j == popped.length);//if popped array complete => true, else false
    }

    public static int[] getArr(String s){
        String nums[] = s.split(" ");
        int n = nums.length;
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(nums[i]);
        }
        return ar;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int pushed [] = getArr(read.readLine());
        int popped [] = getArr(read.readLine());
        
        boolean result = validateStackSequences(pushed, popped);

        System.out.println(result);
    }
}
