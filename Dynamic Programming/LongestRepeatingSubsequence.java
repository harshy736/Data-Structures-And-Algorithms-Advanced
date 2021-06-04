/*
1. You are given a string str.
2. You have to find the length of longest subsequence which is appearing twice in the string.
3. Every ith character in both the subsequences must have different indices in the original string.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str){
		//find length repeating subsequence which occurs 2 times in the original string
		//both subsequence doesn't have common char having same indices in string
		//means a char can not participate in both the subsequence
		
		//Using Longest common Subsequence with itself
		//But here, c1 == c2 case valid only if they are at different positions
		
		int[][] dp = new int[str.length() + 1][str.length() + 1];
		//last row & col for blank char
		
		for(int i = dp.length - 1; i >= 0; i--){
		    for(int j = dp[0].length - 1; j >= 0; j--){
		        if(i == dp.length - 1 || j == dp[0].length - 1){
		            dp[i][j] = 0;//no common subsequence with blank/null
		        }else{
		            char c1 = str.charAt(i);
		            char c2 = str.charAt(j);
		            
		            if(c1 == c2 && i != j){//i != j for not using a char again in other subsequence
		                dp[i][j] = dp[i + 1][j + 1] + 1;       
		            }else{
		                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
		            }
		        }
		    }
		}

		return dp[0][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
