//length of longest increasing sequence

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
    dp[0] = 1;//1st no -> length = 1
    
    //dp blocks stores the length of Long Inc Subseq which ends with that particular number in array
    
    int omax = 1;//length of Longest increasing subsequence
    
    for(int i = 1; i < n; i++){
        int max = 0;//max length of LIS pf that particular no
        
        for(int j = 0; j < i; j++){
            if(arr[i] > arr[j]){
                if(dp[j] > max){
                    max = dp[j];
                }
            }
        }
        
        dp[i] = max + 1;
        if(dp[i] > omax){
            omax = dp[i];
        }
    }
    
    
    System.out.println(omax);
   
  }

}
