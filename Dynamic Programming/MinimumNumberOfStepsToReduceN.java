/*
1. You are given a number N.
2. You have to find the minimum number of operations needed to reduce it to 1.
3. operations allowed are - 
   -> If n is divisible by 2 then you may reduce n to n/2.
   -> If n is divisible by 3 then you may reduce n to n/3.
   -> Decrement n by 1.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n) {
		//write your code here
		int[] dp = new int[n + 1];
		//every ith block stores min no of steps to reach 1 from i
		dp[0] = 0;
		dp[1] = 0;
		
		
		for(int i = 2; i < dp.length; i++){
		    int min = dp[i - 1];//min steps by decrement op
		    
		    if(i % 2 == 0){
		        min = Math.min(min, dp[i/2]);
		    }
		    
		    if(i % 3 == 0){
		        min = Math.min(min, dp[i/3]);
		    }
		    
		    dp[i] = min + 1;//1 -> curr operation
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}
