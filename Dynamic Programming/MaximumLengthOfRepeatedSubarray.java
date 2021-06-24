/*
1. You are given two arrays of integers arr1 and arr2.
2. You have to find the maximum length of subarray that appears in both the given arrays.
*/

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr1, int[] arr2) {
    // write your code here
    int[][] dp = new int[arr1.length + 1][arr2.length + 1];
    //first row & col -> null char -> len = 0
    //row - arr1, col - arr2
    //(i, j)th block stores length of common subarray which starts with ith element in arr1 & jth element in arr2
    
    //s1 = e1 + r1, s2 == e2 + r2
    
    //if e1 != e2 -> length = 0 (no common string possible with different starters)
    
    //e1 == e2 -> len = len(r1, r2) + 1
    
    int maxLen = 0;
    
    //fill dp array
    for(int i = dp.length - 2; i >= 0; i--){
        for(int j = dp[0].length - 2; j >= 0; j--){
            if(arr1[i] == arr2[j]){//e1 == e2
                dp[i][j] = dp[i + 1][j + 1] + 1;
                
                if(dp[i][j] > maxLen){
                    maxLen = dp[i][j];
                }
            }else{//e1 != e2
                dp[i][j] = 0;
            }
        }
    }
    
    return maxLen;

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr1 = new int[n];
    for (int i = 0 ; i < n; i++) {
      arr1[i] = scn.nextInt();
    }

    int m = scn.nextInt();
    int[] arr2 = new int[m];
    for (int i = 0 ; i < m; i++) {
      arr2[i] = scn.nextInt();
    }
    System.out.println(solution(arr1, arr2));
  }

}
