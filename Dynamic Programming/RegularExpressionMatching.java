/*1. You are given two strings S1 and S2. S1 represents a text and S2 represents a pattern.
2. You have to print 'true' if the pattern is matched with the given text, otherwise print 'false'.

The pattern can include the characters '.' and '*'
'.' - matches any single character
'*' - matches zero or more of the preceding character
*/

import java.io.*;
import java.util.*;

public class Main {

	public static boolean solution(String s, String p) {
		//* -> a single * is useless
		//it fully depends on preceding char
		//e.g s * => _ , s, ss, sss, ssss, sssss, ......
		// . * = _ , . , .. , ... , ....
		
		//use Dp in which
		//row -> string p
		//col -> string s
		
		//first row & col -> empty/null char
		//iteration from top to bottom -> oppositive of wildcraft
		//bcz in this mainly in case of * we full depend on result of preceding element
		
		//every (i , j)th block possiblity of matching s end with jth char & p end with ith char
		
		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
		
		for(int i = 0; i < dp.length; i++){
		    for(int j = 0; j < dp[0].length; j++){
		        if(i == 0 && j == 0){//null matched with null
		            dp[i][j] = true;
		        }else if(i == 0){
		            dp[i][j] = false;
		        }else if(j == 0){
		            char pc = p.charAt(i - 1);
		            
		            //bcz a * = _ ;
		            //* combined with its preceding element can become null
		            //possibility depends on the remaining portion
		            if(pc == '*'){
		                dp[i][j] = dp[i - 2][j];
		            }else{
		                dp[i][j] = false;
		            }
		        }else{
		            char sc = s.charAt(j - 1);
		            char pc = p.charAt(i - 1);
		            
		            if(pc == '.'){
		                //. matches with last char of string
		                //ans depend on string removing last char from both s & p
		                //diagonal up
		                dp[i][j] = dp[i - 1][j - 1];
		            }else if(pc == '*'){
		                char pslc = p.charAt(i - 2);//2nd last char
		                dp[i][j] = dp[i - 2][j];
		                
		                
		                if(pslc == '.' || pslc == sc){
		                    dp[i][j] = dp[i][j] || dp[i][j - 1];
		                }
		                
		            }else if(sc == pc){
		                //same like . , last char matches
		                //ans depend on remaining str
		                dp[i][j] = dp[i - 1][j - 1];
		            }else{//sc != pc
		                dp[i][j] = false;
		            }
		        }
		    }
		}
		
		return dp[p.length()][s.length()];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

}
