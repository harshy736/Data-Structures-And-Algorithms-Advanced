/*
1. You are given an array(arr) of positive integers of length N which represents the dimensions of N-1 matrices such that the ith matrix is of dimension arr[i-1] x arr[i].
2. You have to find the minimum number of multiplications needed to multiply the given chain of matrices.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int mcm(int[] arr){
		//if we have ABCDE, we have to mulyiply these matrix chain that we have minimum no of multiplications
		
		//if we A -> x * y & B -> y * z
		//then AB is size of x * z
		//& no.of multipication -> no of elemnets in total * no of cols in 1st matrix/no of rowss in 2nd matrix
		// -> (x * z) * y => x * y * z
		
		//if we want to sloving a chain of having more than 2 matirx
		//e.g ABCDE
		//we have 4 cases, At a time we work on a single matrix multipication in the chain
		//1. A * (BCDE)
		//2. (AB) * (CDE)
		//3. (ABC) * (DE)
		//4. (ABCD) * E
		
		//The no of multiplications needed to solve chain in () is laso added to final count
		//e.g ABCDE = (AB) * (CDE) -> count(AB) + count(CDE) + count((AB) * (cDE))
		
		//In every multiplication we multiply 2 matrix, whether the matrix is a single matrix(like A) or a result of multiplication of chain(like CDE)
		
		//for every chain -> left matrix(l) * right matrix(r)
		//count = count(l) + count(r) + count(m)
		//m -> means multiplication of L * r
		
		//we try every possible l & r to find minimum no of multiplications
		
		// 0 multiplication used for a single matrix
		
		//ith matrix has size  = > arr[i] * arr[i + 1]
		
		//use DP here, similar to pallindrome cut
		
	    int[][] dp = new int[arr.length - 1][arr.length - 1];
	    //bcz no of matrix = arr.length - 1 = N - 1
	    
	    //row -> start
	    //col -> end
	    
	    //using gap strategy
	    
	    for(int g = 0; g < dp.length; g++){
	        for(int i = 0, j = g; j < dp.length; i++, j++){
	            if(g == 0){//single matrix
	                dp[i][j] = 0;
	            }else if(g == 1){//2 matrix multiplication simple, eg AB, BC
	                dp[i][j] = arr[i] * arr[j] * arr[j + 1];
	            }else{
	                //using every left and righ matrix combination here
	                
	                int min = Integer.MAX_VALUE;
	                 
	                for(int k = i; k < j; k++){
	                    int lc = dp[i][k];//count of left matrix chain
	                    int rc = dp[k + 1][j];//count of right matrix chain
	                    
	                    int mc = arr[i] *  arr[k + 1] * arr[j + 1];//multipliaction
	                    
	                    int tc = lc + rc + mc;
	                    
	                    if(tc < min){
	                        min = tc;
	                    }
	                }
	                
	                dp[i][j] = min;
	            }
	        }
	    }

		return dp[0][dp.length - 1];
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scn.nextInt();
		}
		System.out.println(mcm(arr));
	}

	
}
