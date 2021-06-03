import java.io.*;
import java.util.*;

public class Main {

  public static int solution(int[] arr) {
    int n = arr.length;
    
    //using DP
    int[][] dp = new int[n][n];
    //row -> start
    //col -> end
    
    //every (i, j)th block stores the maximum coins we can collect by bursting ballons from ith pos to jth pos
    
    //if we work on ballons from i to j, we can not assume these ballons separartely
    //we consider whole array bcz coins depends on 3 ballons - prev, curr, post
    
    //In a set of ballons( having n ballons ), then sequence to burst ballons is n!
    //But on a set we take n cases in which we consider every ballon is last to burst
    
    //eg 231564 -> whole array
    // Our case -> 3156, we work on 3156 but by conssider whole array
    //we have 4 cases -> 3 is last to burst, 1 is , 5 is & 6 is last to burst.
    //we calcutate the coins in every case & find maximum
    
    //case : if we 1 is last to burst, left = 3, & right = 56
    //left & right is already bursted, we get their cois from dp
    //& by adding the coins by bursting the last baloon
    // 2 * 1 * 5 = 10
    //Coins by bursting last ballon = prev of the sequence * last ballon in sequence * post ballon outside the sequence
    
    //if we doesn't have left. pre, post, right -> we consider them 1
    
    //using gap strategy
    for(int g = 0; g < dp.length; g++){
        for(int i = 0, j = g; j < dp[0].length; j++, i++){ 
           int coins = Integer.MIN_VALUE;
            
            int pre = (i == 0) ? 1 : arr[i - 1];
            int post = (j == arr.length - 1) ? 1 : arr[j + 1];
            
            //seq -> from i to j
            //k is the last balloon to burst
            for(int k = i; k <= j; k++){
                int left = (k == i) ? 0 : dp[i][k - 1];
                int right = (k == j) ? 0 : dp[k + 1][j];
                
                int value = pre * arr[k] * post;
                
                int total = left + value + right;
                
                if(total > coins){
                    coins = total;
                }
            }
            
            dp[i][j] = coins;
           
        }
    }

    return dp[0][n - 1];
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }

}
