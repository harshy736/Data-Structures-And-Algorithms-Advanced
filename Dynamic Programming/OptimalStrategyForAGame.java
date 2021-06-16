/*
1. You are given an array(arr) of length N, where N is an even number.
2. The elements of the array represent N coins of values arr1,arr1...arrN.
3. You are playing a game against an opponent in an alternative way, where the opponent is equally smart.
4. In this game, a player selects either the first or the last coin from the row in every turn, removes it from the row permanently, and receives the value of the coin.
5. You have to find the maximum possible amount of money you can win if you make the first move.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static void optimalStrategy(int[] arr) {
		//write your code here
		int[][] dp = new int[arr.length][arr.length];
		//row -> start, col -> end
		//(i, j)th block stores the max amt of money in the subarray(i, j) if u make first move
		
		//opponent is smart -> choose that coin by removal of it we get least amt
		
		//we have to maximze our money
		
		//let f(i, j) -> max amt of money we can make
		//2 coins to select -> i & j
		
		//if we select i -> opponent has (i + 1, j)
		//he select one coin by giving us subarray which give us lesst amt
		// after his selection -> (i + 2, j) or (i + 1, j - 1)
		//we assume best step from him
		//our money = arr[i] + minimium{f(i + 2, j), f(i + 1, j - 1)}
		
		//sam eif we choose j
		//opponent -> (i, j - 1)
		//money = arr[j] + minimum{f(i + 1, j - 1), f(i, j - 2)
		
		//using gap strategy to fill
		//g = i - j
		
		for(int g = 0; g < dp.length; g++){
		    for(int i = 0, j = g; j < dp[0].length; i++, j++){
		        if(g == 0){//single lement
		            dp[i][j] = arr[i];
		        }else if(g == 1){//2 element -> choose max from them
		            dp[i][j] = Math.max(arr[i], arr[j]);
		        }else{
		            //choose from start
		            int vals = arr[i] + Math.min(dp[i + 2][j], dp[i + 1][j - 1]);
		            
		            //choose from end
		            int vale = arr[j] + Math.min(dp[i][j - 2], dp[i + 1][j - 1]);
		            
		            //select coin which results in max amt of money
		            dp[i][j] = Math.max(vals, vale);
		        }
		    }
		}
		
		//for whole array
		System.out.println(dp[0][dp[0].length - 1]);
	
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = scn.nextInt();
		}
		optimalStrategy(a);
	}

}
