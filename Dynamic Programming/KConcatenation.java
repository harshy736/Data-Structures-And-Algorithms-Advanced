/*
1. You are given an array(arr1) of integers and an integer k.
2. Another array(arr2) is formed by concatenating K copies of arr1.
   For example, if arr1 = {1,2} and k = 3, then arr2 = {1,2,1,2,1,2}.
3. You have to find the maximum subarray sum in arr2.
*/


import java.io.*;
import java.util.*;

public class Main {
    
  public static int kadanes(int[] arr) {
    int csum = 0;
    int msum = Integer.MIN_VALUE;//max sum of subarray
    
    //csum -> sum of previous subarray to the element
    
    for(int i = 0; i < arr.length; i++){
        //+ve -> prev seq is beneficial -> attach with it
        if(csum >= 0){
            csum += arr[i];
        }else{
            csum = arr[i];
        }
        
        //update for maximum subarray sum
        if(csum > msum){
            msum = csum;
        }
    }

    return msum;
  }
  
  
  public static int kadanesOfTwo(int[] arr) {
    int[] darr = new int[arr.length * 2];
    //array of double size
    // 2 arr1 combined
    
    
    for(int i = 0; i < arr.length; i++){
       darr[i] = arr[i];
    }
    
    //duplicating again
    for(int i = 0; i < arr.length; i++){
       darr[i + arr.length] = arr[i];
    }
    
    //find max sum subarray from these combination of 2 array1
    return kadanes(darr);
  }



  public static long solution(int[] arr, int k, long sum) {
    //3 cases
    long msum = 0;
    
    if(k == 1){//single array -> no repeatation -> kadane's algorithm
        msum = kadanes(arr);
    }else if(sum <= 0){//addition of ehole array 1 reduce sum -> not added 
        msum = kadanesOfTwo(arr);
    }else{//sum > 0 -> +ve -> worth it to add whole array to maximize sum
        //2 arr1 is used to find max sum
        //k - 2 arr1 is left between useless & sum of arr1 is +ve
        //add these k - 2 arr1
        
        //subarray of max sum is not possible in single arr1 in combination of 2 arr1
        //bcz arr1 is +ve 
        
        //from combination
        int tsum = kadanesOfTwo(arr);
        
        msum = tsum + (k - 2) * sum;
        //sum -> sum of arr1
    }
    
    return msum;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
      sum += arr[i];
    }
    int k = scn.nextInt();
    System.out.println(solution(arr, k, sum));
  }

}
