/*
1. You are given a string(str).
2. You have to find the minimum number of characters to be inserted to convert it to a palindrome.
*/

import java.io.*;
import java.util.*;

public class Main {
	
	public static int solution(String str) {
		// calculate length longest pallindromic subsequence -> characters which are pallindromic
		
		//min Insertions = total chars - length of lps
		
		int[][] dp = new int[str.length()][str.length()];
		//using gap strategy
		//row - start, col - end
		
		for(int g = 0; g < dp.length; g++){
		    for(int i = 0, j = g; j < dp[0].length; i++, j++){
		        if(g == 0){
		            if(str.charAt(i) == str.charAt(j)){//one char only
		                dp[i][j] = 1;
		            }
		        }else{
		            //str = c1 + m + c2
		            if(str.charAt(i) == str.charAt(j)){//c1 == c2 ->len = len(m) + 2
		                dp[i][j] = dp[i + 1][j - 1] + 2;
		            }else{//c1 != c2 -> len = max[len(c1m), len(mc2)]
		                dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
		            }
		        }
		    }
		}
		
		int ins = str.length() - dp[0][dp[0].length - 1];

		return ins;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}
}
