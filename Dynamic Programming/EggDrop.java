/*
1. You are given two integers N and K. N represents the number of eggs and K represents the number of floors in a building.
2. You have to find the minimum number of attempts you need in order to find the critical floor in the worst case while using the best strategy.
3. The critical floor is defined as the lowest floor from which you drop an egg and it doesn't break. 
4. There are certain which you have to follow -
   a. All eggs are identical.
   b. An egg that survives a fall can be used again.
   c. A broken egg can't be used again.
   d. If the egg doesn't break at a certain floor, it will not break at any floor below.
   e. If the egg breaks at a certain floor, it will break at any floor above.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int eggDrop(int n, int k){
		//write your code here
		int[][] dp = new int[n + 1][k + 1];
		//row -> eggs = n
		//col -> floors = k
		
		for(int i = 1; i <= n; i++){
		    for(int j = 1;  j <= k; j++){
		        if(j == 1){//single floor
		            dp[i][j] = 1;
		        }else if(i == 1){
		            //single egg
		            //worst case -> critical floor not found -> itearte over all floors
		            dp[i][j] = j;
		        }else{
		            int min = Integer.MAX_VALUE;
		            
		            for(int mj = j - 1, pj = 0; mj >= 0; mj--, pj++){
		                int v1 = dp[i - 1][pj];//egg breaks
		                int v2 = dp[i][mj];//egg survives
		                int val = Math.max(v1, v2);
		                
		                min = Math.min(min, val);
		            }
		            
		            dp[i][j] = min + 1;//1 for this step
		        }
		    }
		}

		return dp[n][k];
	} 

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		//n -> number of eggs and k -> number of floors
		int n = scn.nextInt();
		int k = scn.nextInt();
		System.out.println(eggDrop(n,k));
	}
	
}
