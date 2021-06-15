/*
1. You are given an array(arr) of integers and a number k.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least k elements.
*/

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr, int k) {
    //dp in which ith box stores max sum subarray if ith element is last in subarray
    //using kadanes
    int[] dp = new int[arr.length];
   
    dp[0] = arr[0];//first element
    
    //simple filling by kadanes rule
    //for whole array
    for(int i = 1; i < dp.length; i++){
        if(dp[i - 1] > 0){//previous sequence gives us +ve value
            //benefit is to add in these seq to maximmize sum
            dp[i] = dp[i - 1] + arr[i];
        }else{
            //prev seq is -ve
            //not worth it to add in these seq
            //start new sequence
            dp[i] = arr[i];
        }
    }
    
    //stores cummulative sum for the array
    int[] csum = new int[arr.length];
    csum[0] = arr[0];
    
    for(int i = 1; i < csum.length; i++){
        csum[i] = csum[i - 1] + arr[i]; 
    }
    
    //now solving the ques
    //max sum subarray with atleast k elements
    
    //first k elemnets -> assume this is max sum subarray
    int msum = csum[k - 1];
    
    //solve for all possibilties
    for(int i = k; i < arr.length; i++){
        //sum of k elemnets prior to the element
        int ksum = csum[i] - csum[i - k];
        
        //check in kadanes max sum subarray
        
        
        int kpr = dp[i - k];
        //stores max sum pre to the per k element
        
        //if pre subarray gives +ve sum -> worth it to include it in our seq
        if(kpr > 0){
            ksum += kpr;
        }
        
        //compare with max sum
        if(ksum > msum){
            msum = ksum;
        }
    }

    return msum;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k));
  }
}
