/*
1. You are given a number n, representing the number of elements.
2. You are required to find the number of Binary Search Trees you can create using the elements.
*/

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //same like catalan -> verified with draing bsts for n = 2 & n = 3
    //if we draw bst for left edge then on the right edge same no of bsts possible
    
    
    //we are using dp here
    int[] dp = new int[n + 1];
    //each bloxk stores the no of bst possible when i is no of elements
    
    if(n <= 1){
        System.out.println('1');
        return;
    }
    
    dp[0] = 1;
    dp[1] = 1;//1 element
    
    for(int i = 2; i < dp.length; i++){
        int l = 0;
        int r = i - 1;
        
        while(l < i){
            dp[i] += dp[l] * dp[r];
            
            l++;
            r--;
        }
        
    }
    
    //for n elements
    System.out.println(dp[n]);
 }

}
