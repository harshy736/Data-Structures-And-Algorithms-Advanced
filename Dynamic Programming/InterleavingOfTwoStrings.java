/*
. You are given three strings - s1, s2 and s3.
2. You have to find whether s3 is formed by interleaving of s1 and s2.
3. s3 is interleaving if it contains all characters of s1 and s2, and order of all characters in individual string is preserved.
*/

import java.io.*;
import java.util.*;

public class Main {

  public static boolean solution(String s1, String s2, String s3) {
    // write your code here
    boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
    //first row, col - denotes for blank char
    
    //i - 1 -> pointer on s1, j - 1 -> pointer on s2
    //k = i + j - 1 -> pointer on s3
    
    //every(i, j)th block stores answer for s1.substring(0, i) & s2.substring(0, j) with s3.substring(0, i + j) 
    
    for(int i = 0; i < dp.length; i++){
        for(int j = 0; j < dp[0].length; j++){
            if(i == 0 && j == 0){//null s1 & s2
                dp[i][j] = true;
            }else if(i == 0){//s1 = null
                if(s2.charAt(j - 1) == s3.charAt(j - 1)){
                    dp[i][j] = dp[i][j - 1];
                }else{
                    dp[i][j] = false;
                }
            }else if(j == 0){
                if(s1.charAt(i - 1) == s3.charAt(i - 1)){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = false;
                }
            }else{
                if(s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i - 1][j];
                }
                
                //if already true if condition get avoided
                if(!dp[i][j] && s2.charAt(j - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
    }
    
    return dp[dp.length - 1][dp[0].length - 1];

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String s1 = scn.nextLine();
    String s2 = scn.nextLine();
    String s3 = scn.nextLine();
    if(s1.length() + s2.length() != s3.length()){
        System.out.println(false);
        return;
    }
    System.out.println(solution(s1, s2, s3));
  }

}
