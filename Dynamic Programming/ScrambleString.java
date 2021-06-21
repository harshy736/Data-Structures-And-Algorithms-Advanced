import java.io.*;
import java.util.*;

public class Main {

	public static boolean isScrambleTab(String s1, String s2) {
		//write your code here
		int n = s1.length();
		boolean[][][] dp = new boolean[n][n][n + 1];
		//3rd dimension - for length of substrings
		//row -> s1
		//col - s2
		
		//3d array -> like many 2d arrays
		//for different lengths -> 0, 1, 2, ....
		
		//every (i, j, len) stores whether s1.sub(i, len) & s2.sub(j, len) is possible or not
		
	    for(int len = 1; len <= n; len++){//solve for every possible length 
	        for(int i = 0; i <= n - len; i++){
	            for(int j = 0; j <= n - len; j++){
	                if(len == 1){
	                    //single element
	                    dp[i][j][len] = s1.charAt(i) == s2.charAt(j);
	                }else{
	                    //k -> partitioning string -> any partition is allowed
	                    //of non - empty substring
	                    for(int k = 1; k < len && !dp[i][j][len]; k++){
	                        //s1 = l1 + r1, s2 = l2 + r2
	                        //first case -> l1,l2 & r1, r2 -> 
	                        //2nd case -> l1, r2 & l2, r1
	                        
	                        //if any case gives us true -> then s1 & s2 can be scramble string for length = len
	                        dp[i][j][len] = (dp[i][j][k] && dp[i + k][j + k][len - k]) || (dp[i][j + len - k][k] && dp[i + k][j][len - k]);
	                    }
	                }
	            }
	        }
	    }
		
		//length -> n -> whole string
		//taking s1 & s2 complete
		return dp[0][0][n];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(isScrambleTab(s1,s2));
	}

}
