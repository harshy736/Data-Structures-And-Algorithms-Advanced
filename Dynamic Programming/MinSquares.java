//You are given a number N.
//2. You have to find the minimum number of squares that sum to N.
//3. You can always represent a number as a sum of squares of other numbers.
  // For eg -> In worst case N can be represented as (1*1) + (1*1) + (1*1)..... N //times.

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n){
		//write your code here
		int sqrt = (int)Math.sqrt(n);
		int[] dp = new int[n + 1];//every block stores the answer for ith number -> min squares required for i number 
		dp[0] = 0;
		dp[1] = 1;//1 *! = 1
		
		for(int i = 2; i < dp.length; i++){
		    int min = n;
		    
		    //iterate backward by decreasing increaseing squares from 1 to max possible
		    for(int j  = 1; j*j <= i; j++){
		        int rem = i - j*j;//j -> square
		        min = Math.min(min, dp[rem]);
		    }
		    
		    dp[i] = min + 1;// + 1 is for our square used by wich we compare to small numbers
		}
		
		

		return dp[n];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}


	
}
