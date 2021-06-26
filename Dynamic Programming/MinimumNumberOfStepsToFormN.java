/*
1. You are given a number N.
2. You have to find the minimum number of operations needed to to reach N from 0.
3. operations allowed are - 
   -> Double the number.
   -> Add one to the number.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n) {
		//write your code here
		int[] dp = new int[n + 1];
		//every ith block stires min no of steps to reach i from 0
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i = 2; i < dp.length; i++){
		    if(i % 2 == 0){//double number may work here
		        //comapring both operations to reach i
		        //which one gives min steps  -> selected
		        dp[i] = Math.min(dp[i/2], dp[i - 1]) + 1;
		    }else{
		        dp[i] = dp[i - 1] + 1;
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
