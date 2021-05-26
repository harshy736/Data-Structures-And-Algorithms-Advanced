/*
1. You are given an integer N, which represents the length of a rod, and an array of integers, which represents the prices of rod pieces of length varying from 1 to 
     N.
2. You have to find the maximum value that can be obtained by selling the rod.
3. You can sell it in pieces or as a whole.
*/

import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] prices) {
    //In prices[], ith reppresents the prices of a rod pieces of length (i - 1)
    //we convert into new prices array
    //in which ith price for rod piece of length i
    //i.e np[1] stores price for length 1
      
    int[] np = new int[prices.length + 1];
    for(int i = 1; i < np.length; i++){
        np[i] = prices[i - 1];
    }
    
    // using dp bcz we want to calculate value only
    //every ith box stores the maximum price of a rod of length i
    
    //i.e dp[3] stores the max price of a rod having length = 3
    //whether it is sold in pieces or as whole by any mean
    
    int[] dp = new int[prices.length + 1];
    dp[0] = 0;
    dp[1] = np[1];//length = 1, rod piece length = 1 is the answer
    //bcz it is the smallest pieces no more options avaliable
    
    for(int i = 2; i < dp.length; i++){
       dp[i] = np[i];//if it is sell as whole rod
       
       //now consider pieces having combined length = i
       //having 2 pieces left & right
       int l = 1;
       int r = i - 1;
       
       //l + r == i always
       
       //l <= r , to avoid permutaion
       while(l <= r){
           
           if(dp[l] + dp[r] > dp[i]){
               dp[i] = dp[l] + dp[r];
            }
           
           l++;
           r--;
       }
    }

    //stores for the complete rod
    return dp[dp.length - 1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] prices = new int[n];
    
    for (int i = 0; i < n; i++) {
      prices[i] = scn.nextInt();
    }
    
    System.out.println(solution(prices));
  }

}
