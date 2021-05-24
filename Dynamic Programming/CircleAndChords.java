/*
1. You are given a number N.
2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
3. You have to find the number of ways in which these chords can be drawn.
*/

import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //same like catalan 
    //same like valleys an dmountain problem
    //draw cases foe n = 1. 2. 3. 4 and verufy the formula of catalan numbers
    
    //we are using dp here
    long[] dp = new long[n + 1];
    //each bloxk stores the no of chordss possible when 2 * i is no of points on circle
    
    if(n <= 1){
        System.out.println('1');
        return;
    }
    
    dp[0] = 1;
    dp[1] = 1;//1 element
    // way : simple
    
    
    //we get the ques is a variation of catalen number
    
    for(int i = 2; i < dp.length; i++){
       for(int j = 0; j < i ; j++){
           dp[i] += dp[j] * dp[i - 1 - j];
       }
        
    }
    
    //for n * 2 points
    System.out.println(dp[n]);
 }

}
