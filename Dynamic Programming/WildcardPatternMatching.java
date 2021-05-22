/*1. You are given two strings S1 and S2. S1 represents a text and S2 represents a wildcard pattern.
2. You have to print 'true' if the wildcard pattern is matched with the given text, otherwise print 'false'.

The wildcard pattern can include the characters '?' and '*'
'?' - matches any single character
'*' - matches any sequence of characters (including the empty sequence)
*/

import java.io.*;
import java.util.*;

public class Main {

	public static boolean solution(String str, String pattern) {
		//to solve we use Dp arrat
		//row -> shows str
		//col -> pattern
		
		//last row and col -> for blank character
		boolean[][] dp = new boolean[pattern.length() + 1][str.length() + 1];
		
		//every (i, j) block store if the substr(str(i)) matched substr(pattern(j))
		
		//filling from right to left
		//and borrom to top
		
		//0th index represents 0th char
		
		
		
		//3 cases in pattern
		
		//case 1. char -> alphabet
		//check with str ith char
		//if true depends on remaining part of both
		//substr(str(i - 1)) & pattern.substr(j - 1)
		//if false  -> false
		
		//case 2 : ?
		//it adjust with ith char of str
		//depend on substr(str(i - 1)) & pattern.substr(j - 1)
		//diagnolly right
		
		//case 3 : *
		//* can use any sequence of char
		//start using with _ to whole str.sub(i)
		//& check in remainng str and pattern matching
		//if anyone true -> true
		//check in all boxes in (i+1)th row staring from j to end
		//means every box of * stores the OR of all the boxes below start from j to end
		//but we don't need  to take OR of all the boxes all the time
		//we have solution
		//right side box in same row stores the OR of all the boxes in below row starting from (j + 1)
		//means we have to take only 2 boxes for OR
		//dp[i][j + 1] || dp[i - 1][j]

        for(int i = dp.length - 1; i >= 0; i--){
            for(int j = dp[0].length - 1; j >= 0; j--){
                //bootom right corner -> _ match _ -> true
                //_ -> last char in both row and col
                if(i == dp.length - 1 && j == dp[0].length - 1){
                    dp[i][j] = true;
                }else if(i == dp.length - 1){
                    //blank pattern with substr(str) -> false
                    dp[i][j] = false;
                }else if(j == dp[0].length - 1){
                    //blank str with sub pattern
                    //any chances  only if char is *
                    if(pattern.charAt(i) == '*'){//* treats like empty
                        dp[i][j] = dp[i + 1][j];
                    }else{
                        dp[i][j] = false;
                    }
                }else{
                    if(pattern.charAt(i) == '?'){
                        dp[i][j] = dp[i + 1][j + 1];
                    }else if(pattern.charAt(i) == '*'){
                        dp[i][j] = dp[i][j + 1] || dp[i + 1][j];
                    }else{//alphabets
                        if(str.charAt(j) == pattern.charAt(i)){
                            dp[i][j] = dp[i + 1][j + 1];
                        }else{
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }	
        
        
		return dp[0][0];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
