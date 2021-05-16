//1. You are given a string str.
//2. You are required to print the count of palindromic subsequence of string str.

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		
		
		//if l = length of s
		//subsequence of str : 2^l 
		//find longest pallindromic subsequence
		//very high complexity
		
		//to avoid this problem we divide s like : str = c1 * m + c2, c1 -> first char & m = middle of str & c2 = last char
		//length(str) = length(c1 sub(m) c2)
		
		//4 short problems
		
		//1 sub(m)
		//2 c1 sub(m)
		//3 sub(m) c2
		//4 c1 sub(m) c2
		
		//sub(c1 m) = sub(m) + c1 * sub(m) = t1 + t2 
		////sub(m c2) = sub(m) + sub(m) * c2 = t1 + t3 
		
		//Now 2 cases if c1 == c2 & c1 != c2
		
		//if c1 == c2
		//then pallindrome may lie in any solution 
		//count = sum of all counts from all cases
		//t = t1 + t2 + t3 + t4, t -> total count
		//But t4 = t1 + 1, in 4th case all the pallind str will be same as of case 1 But one additional pallind string  -> c1c2 = cc -> not +nt in case 1
		//countstr) = t1 + t2 + t3 + t1 + 1 = (t1+t2) + (t1+t3) + 1
		//t = count[sub(c1 * m)] + count[sub(m * c2] + 1
		
		//if c1 != c2
		//case 4 can never have solution bcz s1 starts with c1 and s2 starts with c2
		//count(str) = t = t1 + t2 + t3
		//t = t1 + t2 + t3 + t1 - t1 = (t1+t2) + (t1+t3) - t1
		//t = count[sub(c1*m)] + count[sub(m*c2)] - count[sub(m)];
		
		
		
		int[][] dp = new int[str.length()][str.length()];
		//vertically represents starting char
		//horizontally represents ending char
		//blocks under main diagonal can not form any string bcz start > end 
		//i.e value = 0 for blocks under principal diagonal
		
		//(i, j)block stores the count of pallindromic string in substring starts from starting char and end at ending char
		
		
		//if we got vertically down , we lost 1 starting char
		//if we got horizontally down , we lost 1 ending char
		//if we got diagonally down , we lost 1 char from both starting and end of the string -> m 
		
		//we iterate diagonally form principle diagonal to thr right doagonals
		//bcz all the diagonal below principle stores 0
		
		//answer will be stored in 1st row & last column bcz the whole string form there
		//1st row - starting first char & last col - ending char will be last of str
		
		for(int g = 0; g < dp.length; g++){//all diagonals
	        //iterate over 1 diagonal in which g = row - col
		    for(int i = 0, j = g; j < dp[0].length; i++, j++){
		        char c1 = str.charAt(i);
		        char c2 = str.charAt(j);
		        
		        if(g == 0){//principle diagonal -> stores str of length 1, always be pallindromic
		            dp[i][j] = 1;
		        }else if(c1 == c2){
		            dp[i][j] = dp[i][j - 1] + dp[i + 1][j]  + 1;
		        }else{
		            dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
		            //dp[i][j - 1] = c1 * sub(m)
		            //dp[i + 1][j ] = sub(m) * c2
		        }
		    }
		}
		
		
	   
	    System.out.println(dp[0][dp.length - 1]);
		
	}


	
}
