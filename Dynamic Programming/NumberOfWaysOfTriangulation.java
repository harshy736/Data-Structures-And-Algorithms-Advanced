/*1. You are given a number N, which represents the number of sides in a polygon.
2. You have to find the total number of ways in which the given polygon can be triangulated.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int n){
		// reducable to catalan 
		
		//In these ques, we have to fing no of ways in polygon can be triangulated
		//Triangulated -> polygon is divided int maximum no of possible triangles for that polygon in every way
		//e.g n = 3, max traingle in it = 1
		//eg n - 4, max tria = 2
		//eg n = 5, max triangle = 3
		//e.g n = 4, max triangle = 4
		
		//max triangle in a polygon = n - 2
		//for triangulation we have to divide a polygon into max triangles
		
		//& we have to count no of ways to do so
		
		//for deafult, n = 2, w = 1 = C0 (like 0! = 1) practically not possible
		//for making catalan
		
		//polygon starts from n = 3
		//for n - 3, w = 1 = C1
		
		//for n = 4, w = 2 = C2
		
		//for n = 5, w = 5 = C3
		
		//for n = 6, w = 14 = C4
		
		//By this analysis, we can easily understand that this is a problem of catalan
		//we an convert it by taking n as (n - 2)
		
		n = n - 2;
        
        //we are using dp here
        int[] dp = new int[n + 1];
        //each bloxk stores the no ways of triangulation when (i + 2) is no of sides of polygon
        
        dp[0] = 1;//default
        dp[1] = 1;//n = 3, triangle shape 
        
        for(int i = 2; i < dp.length; i++){
            int l = 0;
            int r = i - 1;
            
            while(l < i){
                dp[i] += dp[l] * dp[r];
                
                l++;
                r--;
            }
            
        }
    
    
		
		return dp[n];
	 }
	 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(solution(n));
	}

}
