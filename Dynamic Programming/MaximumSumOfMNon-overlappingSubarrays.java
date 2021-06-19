/*
1. You are given an array(arr) of positive numbers and two numbers M and K.
2. You have to find the maximum sum of M non-overlapping subarrays of size K.
3. The size of the given array(arr) is greater than M*K.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr, int m, int k){
	    int n = arr.length;
	    
	    //cummmulative sum
	    int[] csum = new int[n];
	    csum[0] = arr[0];
	    for(int i = 1; i < csum.length; i++){
	        csum[i] = csum[i - 1] + arr[i];
	    }
	    
		//2d dp
		
		int[][] dp = new int[m + 1][n];
		//row -> m(no of subarrays required)
		//col -> array
		
		for(int i = 0; i < dp.length; i++){
		    for(int j = n - 1; j >= 0; j--){
		        if(i == 0){
		            dp[i][j] = 0;//0 subarray -> sum = 0
		        }else if(j > n - i * k){
		            dp[i][j] = 0;
		        }else if(i == 1){
		           int inc = csum[j + k - 1] - (j == 0 ? 0 : csum[j - 1]);
		           int exc = (j == n - 1 ? 0 : dp[i][j + 1]);
		           
		           dp[i][j] = Math.max(inc, exc);//max of both condition
	            }else{
    	            //if ith element is included in a subarray
    	            int inc = csum[j + k - 1] - (j == 0 ? 0 : csum[j - 1]) + dp[i - 1][j + k];
    	            
    	            int exc = dp[i][j + 1];//excluded
    	            
    	            dp[i][j] = Math.max(inc, exc);//max of both condition
		        }
		    }
		}
		
		
		
		return dp[m][0];
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
        int m = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(solution(arr, m , k));
	}

}
