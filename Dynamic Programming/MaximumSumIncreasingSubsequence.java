//sum of increasing sequence having maximum sum

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = scn.nextInt();
    }
    
    //dp array
    int[] dp = new int[n];
    dp[0] = arr[0];//1st no -> sum = 1st no.
    
    //dp blocks stores the max sum of Inc Subseq which ends with that particular number in array
    
    int maxSum = dp[0];//maximum sum of increasing sequence
    
    for(int i = 1; i < n; i++){
        int sum = 0;//sum of LIS having maximum sum pf that particular no
        
        for(int j = 0; j < i; j++){
            if(arr[i] >= arr[j]){//increasing , strictly not compulsory
                if(dp[j] > sum){
                    sum = dp[j];
                }
            }
        }
        
        dp[i] = sum + arr[i];
        if(dp[i] > maxSum){
            maxSum = dp[i];
        }
    }
    
    
    
    System.out.println(maxSum);
   
  }

}
