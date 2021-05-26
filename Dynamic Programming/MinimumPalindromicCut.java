/*
1. You are given a string.
2. You have to find the minimum number of cuts required to convert the given string into palindromic partitions.
3. Partitioning of the string is a palindromic partitioning if every substring of the partition is a palindrome.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int minPalindromicCut(String s) {
		//problem is to find min cut required to partition a string in suvh a manner tha every partition is pallindrome
		//e.g abccbc -> 2 cuts
		//a, bccb, c
		
		//use boolean dp array to store whethet a substring is pallindromic or not
		//row -> starting points
		//col -> ending point
		
		//using gap strategy
		boolean[][] dp = new boolean[s.length()][s.length()];
		//every (i, j)th block stores that the substring starts with ith char & end eith jth char is pallindrom or not
		
		//false for where i < j : start < end
		
		for(int g = 0; g < s.length(); g++){
		    for(int i = 0, j = g; j < dp.length; i++, j++){
		        if(g == 0){//single char -> pallindrome always
		            dp[i][j] = true;
		        }else if(g == 1){//2 char
		            if(s.charAt(i) == s.charAt(j)){
		                dp[i][j] = true;
		            }else{
		                dp[i][j] = false;
		            }
		        }else{
		            if(s.charAt(i) == s.charAt(j)){//start char matches with end char
		            //ans depends on middle part
		                dp[i][j] = dp[i + 1][j - 1];
		            }else{///start char doesn't matches with end char
		                dp[i][j] = false;
		            }
		        }
		    }
		}
		
		
		//Now ew have to find minn cuts
		//By using dp
		
		int[] strg = new int[s.length()];
		//every jth block stores the min no of cuts required to make a string starts with 0 & end with jth char to convert into partitioning string
		
		strg[0] =  0;//single char -> pallindrome : no need of a cut
		
		for(int j = 1; j < strg.length; j++){
		    //whole string end with jth char is pallindrome
		    //no need of any cut
		    if(dp[0][j]){
		        strg[j] = 0;
		    }else{
		        int mc = Integer.MAX_VALUE;//min cuts
		        
		        //we are working on the suffix which are pallindrmic
		        //0 cut for them
		        //get nas for remainng string portion
		        
		        //find min cuts
    		    for(int i = j; i >= 1; i--){
    		        if(dp[i][j]){//suffix pallindromic
    		            if(strg[i - 1] < mc){//remaining portion have min cuts from previous
    		                mc = strg[i - 1];
    		            }
    		        }
    		    }
    		    
    		    strg[j] = mc + 1;//+1 for this partition suffix & remaining 
		    }
		}

		return strg[strg.length - 1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		System.out.println(minPalindromicCut(str));
	}
}
