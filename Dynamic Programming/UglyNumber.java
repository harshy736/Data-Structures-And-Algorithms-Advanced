/*
1. You are given a number N.
2. You have to find Nth ugly number.
3. Ugly number is defined as the number whose prime factors are only 2,3 and 5.  
4. First eleven ugly numbers are -> 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15.

Assumption -> 1 is the first ugly number.
*/

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int n) {
    // write your code here
    int[] dp = new int[n + 1];
    //ith bloxk -> ith ugly number
    
    dp[1] = 1;//first ugly number
    
    //pointers of 2, 3 & 5
    //we iterate through their tables & find min of 3 values -> to allign increasingly
    //for ugly numbers -> we take multiples of 2, 3 & 5 only with ugly numbers
    //2, 3, 5 * ugly number = ugly number
    int p2 = 1, p3 = 1, p5 = 1; 
    
    for(int i = 2; i <= n; i++){
        int v2 = 2 * dp[p2];
        int v3 = 3 * dp[p3];
        int v5 = 5 * dp[p5];
        
        int min = Math.min(v2, Math.min(v3, v5));//min of 3 values
        dp[i] = min;//ith ugly number
        
        //update pointer if use value corresponding to that
        if(v2 == min){
            p2++;
        }
        
        if(v3 == min){
            p3++;
        }
        
        if(v5 == min){
            p5++;
        }
    }

    return dp[n];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    System.out.println(solution(n));
  }

}
