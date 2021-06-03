import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2){
		//using dp
		
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		//first row & col -> blank
		//row -> s1 , col -> s1
		
		//every (i, j)th block stores length of common substring if there is any common substring
		//else -> 0
		
		int max = 0;
		
		for(int i = 0; i < dp.length; i++){
		    for(int j = 0; j < dp[0].length; j++){
		        if(i == 0 || j == 0){
		            dp[i][j] = 0;//for blank
		        }else{
		            char c1 = s1.charAt(i - 1);
		            char c2 = s2.charAt(j - 1);
		            
		            //substring possible->length depends on remaining string s1 & s2
		            if(c1 == c2){
		                dp[i][j] = dp[i - 1][j - 1] + 1;
		            }else{//substring not possible
		                dp[i][j] = 0;
		            }
		        }
		        
		        if(dp[i][j] > max){
		            max = dp[i][j];
		        }
		    }
		}

		return max;
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
