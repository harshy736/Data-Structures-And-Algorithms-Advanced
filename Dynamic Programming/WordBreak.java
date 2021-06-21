/*
1. You are given n space-separated strings, which represents a dictionary of words.
2. You are given another string that represents a sentence.
3. You have to determine if this sentence can be segmented into a space-separated sequence of one or more dictionary words.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static boolean solution(String sentence, HashSet<String> dictionary) {
		//write your code here
		int n = sentence.length();
		
		int[] dp = new int[n];
		//every ith block stores no of sentences possible till ith char
		
		for(int i = 0; i < n; i++){
		    //explore all word ending with ith char from starting
		    for(int j = 0; j <= i; j++){
		        String wtm = sentence.substring(j, i + 1);
		        
		        //if it is +nt in dict
		        if(dictionary.contains(wtm)){
		            if(j > 0){
		                dp[i] += dp[j - 1];
		            }else{//whole sentence is a valid word
		                dp[i] += 1;
		            }
		        } 
		    }
		}

		return dp[n - 1] != 0;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		HashSet<String> dictionary = new HashSet<String>();
		for (int i = 0; i < n; i++) {
			dictionary.add(scn.next());
		}
		String sentence = scn.next();
		System.out.println(solution(sentence, dictionary));
	}

}
