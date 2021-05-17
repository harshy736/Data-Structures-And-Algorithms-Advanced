//1. You are given a string str.
//2. You are required to print the count of palindromic substring of string str.

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
	    //str = c1 * m * c2
		
		boolean[][] dp = new boolean[str.length()][str.length()];
		int maxLen = 1;//by default : a char is always pallindromic
		//len = longest pallindromic substring 
		
		//vertically represents starting char
		//horizontally represents ending char
		//blocks under main diagonal can not form any string bcz start > end 
		//i.e value = 0 for blocks under principal diagonal
		
		//(i, j)block stores that the substring is pallindromic or not which starts from starting char and end at ending char
		
		
		//if we got vertically down , we lost 1 starting char
		//if we got horizontally down , we lost 1 ending char
		//if we got diagonally down , we lost 1 char from both starting and end of the string -> m 
		
		//we iterate diagonally form principle diagonal to thr right doagonals
		//bcz all the diagonal below principle stores 0
		
		
		for(int g = 0; g < dp.length; g++){//all diagonals
	        //iterate over 1 diagonal in which g = row - col
		    for(int i = 0, j = g; j < dp[0].length; i++, j++){
		        char c1 = str.charAt(i);
		        char c2 = str.charAt(j);
		        
		        if(g == 0){//principle diagonal -> stores str of length 1, always be pallindromic
		            dp[i][j] = true;
		        }else if(g == 1){//size = 2
		            if(c1 == c2){
		                dp[i][j] = true;
		            }else{
		                dp[i][j] = false;
		            }
		        }else if(c1 == c2){//depends on mid substring
		            dp[i][j] = dp[i + 1][j - 1];
		        }else{
		            dp[i][j] = false;
		        }
		        
		        if(dp[i][j]){// if substring  is pallindrmic
	                int len = g + 1;//length of this pallindromic string
	                //g = j - 1 = end - start
	                
	                if(len > maxLen){
	                    maxLen = len;
	                }
	            }
		    }
		}
	   
	    System.out.println(maxLen);
		
	}


	
}
