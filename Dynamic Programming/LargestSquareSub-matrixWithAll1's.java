/*
1. You are given a matrix of 0's and 1's.
2. You have to find the maximum size square sub-matrix with all 1's.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[][] arr) {
		//write your code here
		int[][] dp = new int[arr.length][arr[0].length];
		//(i, j)th stores size of square matrix with all 1s having (i, j)th element as Top Left Corner
		
		int max = 0;
		
		for(int i = dp.length - 1; i >= 0; i--){
		    for(int j = dp[0].length - 1; j >= 0; j--){
		        if(i == dp.length - 1 || j == dp[0].length - 1){
		            dp[i][j] = arr[i][j];
		        }else if(arr[i][j] == 0){//top left is 0
		            dp[i][j] = 0;
		        }else{
		            //checking size of minor sub matrix haing all 1's
		            int min = Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
		            dp[i][j] = min + 1;//new big sub matrix
		            
		            max = Math.max(max, dp[i][j]);//update
		        }
		    }
		}
		
		

		return max;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m =scn.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0 ; i < n; i++){
			for(int j = 0 ; j < m; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		System.out.println(solution(arr));
	}

}
