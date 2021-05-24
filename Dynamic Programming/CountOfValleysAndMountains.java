/*
1. You are given a number n, representing the number of upstrokes / and number of downstrokes(\) .
2. You are required to find the number of valleys and mountains you can create using strokes.
E.g.

countvalleys

Note -> At no point should we go below the sea-level. (number of downstrokes should never be more than number of upstrokes).
*/

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //same like catalan 
    //draw cases foe n = 1. 2. 3. 4 and verufy the formula of catenal numbers
    
    //we are using dp here
    int[] dp = new int[n + 1];
    //each bloxk stores the no of mountains possible when i is no of upstrokes/downstrokes
    
    if(n <= 1){
        System.out.println('1');
        return;
    }
    
    dp[0] = 1;
    dp[1] = 1;//1 element
    // moutanin : /\
    
    //we derive formula for n > 1 from n = 1
    //eg n = 2, we add one pair of strokes to n = 1
    //we have 2 options to add one pair : inside a pair & outside a pair
    //using both possibility we get
    //in(0) * out(1) + in(1) * out(0)
    
    //for n = 3, add 2
    //in(0) * out(2) + in(1) * out(1) + in(2) * out(0)
    
    //from this we get the ques is a variation of catalen number
    
    for(int i = 2; i < dp.length; i++){
        int inside = 0;
        int outside = i - 1;
        
        while(inside < i){
            dp[i] += dp[inside] * dp[outside];
            
            inside++;
            outside--;
        }
        
    }
    
    //for n elements
    System.out.println(dp[n]);
 }

}
