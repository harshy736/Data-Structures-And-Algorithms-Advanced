import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int[] dp = new int[n + 1];
    
    if(n <= 1){
        System.out.println('1');
        return;
    }
    
    dp[0] = 1;
    dp[1] = 1;
    
    for(int i = 2; i < dp.length; i++){
        for(int j = 0; j < i/2; j++){
            dp[i] += dp[j] * dp[i - 1 - j];
        }
        
        dp[i] = dp[i] * 2;
        
        if(i % 2 != 0){
            dp[i] = dp[i] + dp[i/2]*dp[i/2];
        }
    }
    
    System.out.println(dp[n]);
 }

}
