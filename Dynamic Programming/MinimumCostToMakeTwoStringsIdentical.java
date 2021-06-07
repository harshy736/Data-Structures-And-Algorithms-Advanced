/*
1. You are given two strings S1, S2, and two numbers x and y.
2. The cost of deleting a character from S1 is x and the cost of deleting a character from S2 is y.
3. You can delete characters from both the strings.
4. You have to find the minimum cost required to make the given two strings identical.
*/
import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String s1, String s2, int x, int y) {
		//same ques like minimum ascii
	    int[][] dp = new int[s1.length() + 1][s2.length() + 1];
	    //s1 -> row, s2 -> col
	    //last row & col -> blank char
	    
	    //every (i, j)th block stores answer for string s1 starting with i & string se starting with j
	    
	    //solution
	    //Let s1 = c1r1 & c2 r2
	    
	    //if c1 == c2
	    //answer depends on r1 & r2
	    //f(c1r1, c2r2) = f(r1, r2)
	    
	    //c1 != c2
	    //deletion of one is must for equal string
	    //we check both ways by deleting c1 or c2
	    //and store answer which deletion gives us minimum value
	    //f1(c1r1, c2r2) = Minimun( f(r1, c2r2) + x, f(c1r1, r2) + y )
	    
	    //for comparision blank char -> deletiom of all char is required
	    
	    for(int i = dp.length - 1; i >= 0; i--){
	        for(int j = dp[0].length - 1; j >= 0; j--){
	            if(i == dp.length - 1 && j == dp[0].length - 1){
	                //both strings are null -> no deletion can possible
	                dp[i][j] = 0;
	            }else if(i == dp.length - 1){
	                //last row
	                //deletion possible only of s2 characters
	                dp[i][j] = y + dp[i][j + 1];
	            }else if(j == dp[0].length - 1){
	                //deletion from s1
	                dp[i][j] = x + dp[i + 1][j];
	            }else{
	                if(s1.charAt(i) == s2.charAt(j)){//c1 == c2
	                    dp[i][j] = dp[i + 1][j + 1];
	                }else{
	                    dp[i][j] = Math.min(dp[i + 1][j] + x, dp[i][j + 1] + y);
	                }
	            }
	        }
	    }

		return dp[0][0];

	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(s1, s2,x, y));
	}

}
