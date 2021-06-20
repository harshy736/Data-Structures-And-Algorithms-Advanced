/*
1. You are given two strings s1 and s2.
2. You have to find the minimum number of operations needed to convert s1 to s2.
   Operations allowed are - 
   Insert - You can insert any character in s1.
   Remove - You can remove any character in s1.
   Replace - You can replace any character in s1 with any other character.
*/

import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(String str1, String str2) {
        //tabulation
		int[][] dp = new int[str1.length() + 1][str2.length() + 1];
		//row -> str1 , col -> str2
		//last row & col for blank characters
		
		//every(i, j)th block stores the minimum no of operations to convert str1(i) to str(j)
		
		//direction -> from down to up, right to left
		
		for(int i = dp.length - 1; i >= 0; i--){
		    for(int j = dp[0].length - 1; j >= 0; j--){
		        if(i == dp.length - 1 && j == dp[0].length - 1){
		            //both s1 & s2 are null strings -> no operation req
		            dp[i][j] = 0;
		        }
		        else if(i == dp.length - 1){
		            //str1 -> empty/null 
		            //insert str2 characters in str1 to make it s2
		            dp[i][j] = dp[i][j + 1] + 1;
		        }else if(j == dp[0].length - 1){
		            //str2 -> empty/null -> deletion of all str1 characters is required
		            dp[i][j] = dp[i + 1][j] + 1;
		        }else{
		            int c1 = str1.charAt(i);//char of tring s1
		            int c2 = str2.charAt(j);//char of string s2
		            
		            //s = c1 + r1
		            //t = c2 + r2
		            
		            if(c1 == c2){
		                //starting char of both match -> no operation req here
		                //get operations required for (r1, r2)
		                dp[i][j] = dp[i + 1][j + 1];
		            }else{
		                //c1 != c2
		                //but to make s1 to s2 we have to make c2 from anywhere
		                //explore all 3 operations here
		                //insert -> c2 matched -> call (c1 + r1, r2)
		                //replace -> c1 is replaced -> (r1, r2)
		                //remove -> c1 is deleted but c2 not matched til -> (r1, c2 + r2)
		                //choose operation which gives us min no of operations
		                //add 1 in the no of operations for this operation
		                
		                dp[i][j] = Math.min(dp[i][j + 1], Math.min(dp[i + 1][j + 1], dp[i + 1][j])) + 1;
		            }
		        }
		    }
		}

		return dp[0][0];//for whole s1 & s2
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
