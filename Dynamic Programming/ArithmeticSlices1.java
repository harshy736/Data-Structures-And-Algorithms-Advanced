/*
1. You are given an array(arr) of integers.
2. You have to find the count of arithmetic slices in the given array.
3. Arithmetic slice is defined as the sub-array having all its elements in A.P and the length of sub-array should be greater than or equal to 3.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr) {
		//write your code here
		int[] dp = new int[arr.length];
		// every ith block stores count Of A.Ps which finished at ith element
		
		//count of total A.Ps
		int count = 0;
		
		for(int i = 2; i < dp.length; i++){
		    if(2 * arr[i - 1] == arr[i - 2] + arr[i]){//A.P condition
		        dp[i] = dp[i - 1] + 1;//1 more A.P than previous element
		        count += dp[i];
		    }
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(solution(arr));
	}

}
