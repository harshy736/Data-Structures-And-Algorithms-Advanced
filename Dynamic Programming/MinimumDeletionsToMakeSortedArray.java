/*
1. You are given a number N representing number of elements.
2. You are given N space separated numbers representing (ELE)elements.
3. Find the minimum number of deletions/removals needed such that remaining elements are (strictly)sorted.
*/

import java.util.Scanner;

public class Main{
    public static int minimumDeletionsToSorted(int []arr){
       // calculate length longest sorted subsequence -> characters which are sorted         
       //min deletions = total chars - length of lomg sorted subseq
		
		int[] dp = new int[arr.length];
		dp[0] = 1;//single element
		
		//every ith block stores the length of long sorted subseq ends on ith element
		
		int maxLen = 0;
		
		for(int i = 1; i < dp.length; i++){
		   int max = 0;//max length of sorted subseq prior to ith element
		    
		   for(int j = i - 1; j >= 0; j--){
		       if(arr[i] > arr[j]){//increasing
		           max = Math.max(max, dp[j]);
		       }
		   }
		   
		   dp[i] = max + 1;//1 -> ith element
		   
		   maxLen = Math.max(maxLen, dp[i]);//updating overall
		}
		
		int del = arr.length - maxLen;

		return del;
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];

        for(int i = 0 ;i < n;i++){
            arr[i] = scn.nextInt();
        }

        System.out.println(minimumDeletionsToSorted(arr));
    }
}
