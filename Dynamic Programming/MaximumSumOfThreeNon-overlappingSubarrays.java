/*
1. You are given an array(arr) of positive numbers and a number K.
2. You have to find the maximum sum of elements in three non-overlapping subarrays.
3. Also, you have to print indices representing the starting position of every subarray.
4. If there are multiple answers, print the lexicographically smallest one.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static void solution(int[] arr, int k){
		//length of array
		int n = arr.length;
		
		//dp array storing previous/cummulative sum upto the lement
		int[] csum = new int[n];
		csum[0] = arr[0];
		
		for(int i = 1; i < n; i++){
		    csum[i] = csum[i - 1] + arr[i];
		}
		
		//for left subarray
		int[] left = new int[n];
		//every ith block stores max sum of subaray of length k -> upto ith elemnet
		//in the array from 0 to ith element
		
	    //for right subarray
		int[] right = new int[n];
		//every ith block stores max sum of subaray of length k 
		//in the array from ith to (n - 1)th element
		
		//filling left element
		left[k - 1] = csum[k - 1];//first subarray of length k
		
		
		for(int i = k ; i < n; i++){
		    int sum = csum[i] - csum[i - k];//if ith element included
		    
		    //stores max sum
		    left[i] = Math.max(left[i - 1], sum);
		}
		
		//filling right element
		right[n - k] = csum[n - 1] - csum[n - k - 1];//first subarray of length k
		
		
		for(int i = n - k - 1; i > k; i--){
		    int sum = csum[i + k - 1] - csum[i - 1];//if ith element included
		    
		    //stores max sum
		    right[i] = Math.max(right[i + 1], sum);
		}
		
		int maxSum = 0;
		int lsum = 0;
		int rsum = 0;
		int spmsa = k;//starting pos of middle subarray
		
		//iterate over possiblity of middle subarray -. for max sum
		for(int i = k; i <= n - 2 * k; i++){
		    int sum = left[i - 1] + (csum[i + k - 1] - csum[i - 1]) + right[i + k];
		    
		    if(sum > maxSum){
		        maxSum = sum;
		        spmsa = i;
		        lsum = left[i - 1];
		        rsum = right[i + k];
		    }
		}
		
		int splsa = 0, sprsa = 0;//starting pos of left & right subarray
		
		//left pos
		for(int i = k - 1; i < spmsa; i++){
		    if(left[i] == lsum){
		        splsa = i - k + 1;
		        break;
		    }
		}
		
		//right pos
		for(int i = spmsa + k; i < n ; i++){
		    int sum = csum[i + k - 1] - csum[i - 1];
		    if(sum == rsum){
		        sprsa = i;
		        break;
		    }
		}
		
		System.out.println(maxSum + " " + splsa + " " + spmsa + " " + sprsa);
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		solution(arr,k);
	}

}
