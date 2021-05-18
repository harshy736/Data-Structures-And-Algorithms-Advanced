//Important Question

/*1. You are given a string.
2. You have to print the count of distinct and non-empty palindromic subsequences in the given string.
3. Two sequences s1 and s2 are distinct if here is some i, for which ith character in s1 and s2 are different.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str) {
		// str = c1 m c2
		
		//if c1 != c2
		//dps(str) = dps(c1 m) + dps(m c2) - dps(m)
		
		//if c1 == c2 = c
		//3 cases
		
		//1. m doesn't have 'c' char
		//dps(str) = 2 * dps(m) + 2
		
		//2. m have ony one 'c' char
		//dps(str) = 2 * dps(m) + 1
		
		//1. m have more than 1 'c' char
		//dps(str) = 2 * dps(m) - dps(m')
		//where m = between c1 & c2
		//m' = between inside 'c' characters
		//eg. abacdaba -> m = bacdab & m' = cd
		
		int[][] dp = new int[str.length()][str.length()];
		// (i, j)th block stores the count of pallindromic subsequences
		
		int[] prev = new int[str.length()];
		//stores the previous position of the ith char
		
		HashMap<Character, Integer> map = new HashMap<>(); 
		
		for(int i = 0; i < prev.length; i++){
		     char ch = str.charAt(i);
		     
		     if(map.containsKey(ch)){
		         prev[i] = map.get(ch);
		     }else{
		         prev[i] = -1;
		     }
		     
		     map.put(ch, i);
		}
		
		map.clear();
		
		int[] next = new int[str.length()];
		//stores the next position of the ith char
	
		for(int i = next.length - 1; i >= 0; i--){
		     char ch = str.charAt(i);
		     
		     if(map.containsKey(ch)){
		         next[i] = map.get(ch);
		     }else{
		         next[i] = -1;
		     }
		     
		     map.put(ch, i);
		}
		
		//m' = substring(n + 1, p - 1)
		
		for(int g = 0; g < dp.length; g++){
		    for(int i = 0, j = g; j < dp[0].length; i++, j++){
		        if(g == 0){//single char
		            dp[i][j] = 1;
		        }else if(g == 1){//double char
		            dp[i][j] = 2;
		        }else{
		            char sc = str.charAt(i);
		            char ec = str.charAt(j);
		            
		            if(sc != ec){
		                dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
		            }else{
		                int n = next[i];
		                int p = prev[j];
		                
		                if(n > p){//no 'c' char in m
		                    dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
		                }else if(n == p){//only one 'c' char in m
		                    dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
		                }else{//more than one 'c' char in m
		                    dp[i][j] = 2 * dp[i + 1][j - 1] - dp[n + 1][p - 1];
		                }
		            }
		        }
		    }
		}
		
		return dp[0][dp.length - 1];
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
