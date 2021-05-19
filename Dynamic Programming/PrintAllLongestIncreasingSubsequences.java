/*1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) Length of "Longest Increasing Subsequence"(LIS).
    3.2) All "Longest Increasing Subsequence(s)"(LIS). 
*/

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    
    public static class Pair {
        int l;//length of longest Inc subsequence
        int i;//index
        int v;//value
        String psf;//path so far
        
        Pair(int i, int l, int v, String psf){
            this.l = l;
            this.i = i;
            this.v = v;
            this.psf = psf;
        }
    }
        
    public static void solution(int []arr){
        //we have first have to find length of longest Inc subsequence for the whole array
        int ml = 1;//max length
        
        //every ith block stores length of LIS when last element of LIS is ith char
        int[] dp = new int[arr.length];
        dp[0] = 1;//1 element always increasing
        
        for(int i = 1; i < dp.length; i++){
            int cl = 0;
            for(int j = 0; j < i; j++){
                if(dp[j] > cl && arr[j] < arr[i]){//increasing and find LIS from the subsequences in which ith char can be placed in last 
                    cl = dp[j];
                }
            }
            
            dp[i] = cl + 1;
            if(dp[i] > ml){
                ml = dp[i];
            }
        }
        
        System.out.println(ml);
        
        Queue<Pair> q = new ArrayDeque<>();
        
        for(int i = 0; i < dp.length; i++){
            if(dp[i] == ml){//LIS end on that element
                q.add(new Pair(i, dp[i], arr[i], arr[i] + ""));
            }
        }
        
        //start from largest element of LIS to the smallest
        
        while(q.size() > 0){
            Pair p = q.remove();
            
            if(p.l == 1){//whole LIS is completed
                System.out.println(p.psf);
            }else{
                for(int j = p.i - 1; j >= 0; j--){
                    if(dp[j] == p.l - 1 && arr[j] <= p.v){
                        q.add(new Pair(j, dp[j], arr[j], arr[j] + " -> " + p.psf));
                    }
                }
            }
        }
    }
    
    
    
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();

        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = scn.nextInt();
        }

        solution(arr);

        scn.close();
    }
}
