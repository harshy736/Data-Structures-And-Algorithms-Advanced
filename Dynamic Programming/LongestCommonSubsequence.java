//1. You are given a string str1.
//2. You are given another string str2.
//3. You are required to print the length of longest common subsequence of two //strings.

import java.io.*;
import java.util.*;

public class Main {



	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.nextLine();
		String s2 = scn.nextLine();
		
		//if l1 = length of s1 and l2 = length of s2
		//subsequence of s1 : 2^l1 % subsequence of s2 : s2 : 2^l2
		//find maximum common length subseq in total sub(s1) * sub(s2) : 2 ^ (l1 + l2)
		//very high complexity
		
		//to avoid this problem we divide s like : s = c * r, c -> first char & r = rest of str
		//s1 = c1 * r1 & s2 = c2 * r2
		//length(s1, s2) = length(sub(c1, r1) * sub(c2, r2))
		//sub(s) = sub(r) + c * sub(r)
		//sub(s1) = sub(r1) + c1 * sub(r1) & sub(s2) = sub(r2) + c2 * sub(r2)
		//length(s1, s2) = length([sub(r1) + c1 * sub(r1)]*[sub(r2) + c2 * sub(r2)])
		//4 short problems
		
		//1 sub(r1) * sub(r2)
		//2 sub(r1) * c2sub(r2)
		//3 c1sub(r1) * sub(r2)
		//4 c1sub(r1) * c2sub(r2)
		
		//Now 2 cases if c1 == c2 & c1 != c2
		
		//if c1 == c2
		//then common subseq may lie in any solution
		//But case 4 also have solution and noone can jave maximum length that bcz c1 == c2
		//length(s1, s2) = len( c1sub(r1) * c2sub(r2) ) = length(sub(r1) * sub(r2)) + 1
		
		//if c1 != c2
		//case 4 can never have solution bcz s1 starts with c1 and s2 starts with c2
		//length = max(1, 2, 3 case ans);
		//length = max[len( sub(r1) * sub(s2) ), len(sub(s1) * sub(r2))]
		//by dividing  s1 & s2 in this eq we get ! + 2 +3 case
		
		
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		//vertically represents s1
		//horizontally represents s2
		//On both sides the extreme line belongs to empty string
		//i.e value = 0 for bottom and right blocks
		
		//a (i, j)block stores the length of longest common subseq in s1 = Substring(i) & s2 = substring(j)
		//means all the string starts from that block in s1 and s2
		
		//if we got vertically down , we lost 1 char in s1 -> r1
		//if we got horizontally down , we lost 1 char in s2 -> r2
		//if we got diagonally down , we lost 1 char in both s1 & s2 -> r1 & r2
		
		//we iterate form the rightomost bottom part to leftmost upper part
		
		for(int i = dp.length - 2; i >= 0; i--){
		    char c1 = s1.charAt(i);
		    for(int j = dp[0].length - 2; j >= 0; j--){
		        char c2 = s2.charAt(j);
		        
		        if(c1 == c2){
		            dp[i][j] = dp[i + 1][j + 1] + 1;
		        }else{
		            dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
		        }
		    }
		}
		
	    //1st block stores the answer bcz both th estrings starts from here 
	    System.out.println(dp[0][0]);
		
	}


	
}
