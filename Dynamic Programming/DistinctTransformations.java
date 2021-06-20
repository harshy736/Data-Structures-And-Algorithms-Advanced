/*
1. You are given two strings S1 and S2.
2. You have to find the number of unique ways in which you can transform S1 to S2.
3. Transformation can be achieved by removing 0 or more characters from S1, such that the sequence formed by the remaining characters of S1 is identical to S2.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s, String t) {
		//tabulation
		int[][] dp = new int[t.length() + 1][s.length() + 1];
		//row -> target , col -> normal string s
		//last row & col for blank characters
		
		//direction -> from down to up, right to left
		
		for(int i = dp.length - 1; i >= 0; i--){
		    for(int j = dp[0].length - 1; j >= 0; j--){
		        if(i == dp.length - 1){
		            //target = null(.) -> only one way to convert any string into null string by deleting whole string
		            dp[i][j] = 1;
		        }else if(j == dp[0].length - 1){
		            //if source string is null(.) -> no way to convert into any non - null target string
		            dp[i][j] = 0;
		        }else{
		            int cs = s.charAt(j);//char of source string s
		            int ct = t.charAt(i);//char of target string t
		            
		            //s = cs + rs
		            //t = ct + rt
		            
		            if(cs != ct){
		                //starting char of both not match -> remove cs -> to get a chance to convert s into t
		                //get ways from (rs, ct + rt)
		                dp[i][j] = dp[i][j + 1];
		            }else{
		                //cs & ct matches -> we have both ways to convert s into t
		                //by keeping cs (rs, rt) or by removing cs (rs, ct + rt)
		                //consider both ways & add their no of ways
		                dp[i][j] = dp[i][j + 1] + dp[i + 1][j + 1];
		            }
		        }
		    }
		}

		return dp[0][0];//for whole s & t
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}
