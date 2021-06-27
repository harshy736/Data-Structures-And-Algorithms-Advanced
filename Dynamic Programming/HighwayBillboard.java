/*
1. You are given a number M representing length of highway(range).
2. You are given a number N representing number of bill boards.
3. You are given N space separated numbers representing (P)position of bill-boards.
4. You are given N space separated numbers representing (R)revenue corresponding to each (P)position.
5. You are given a number T such that bill-boards can only be placed after specific distance(T).
6. Find the maximum revenue that can be generated.
*/

import java.util.Scanner;
public class Main{
    public static int solution(int m , int[] x, int[] rev, int t) {
        // write your code here
        int[] dp = new int[x.length];
        //ith block stores max revenue possible if ith is last bill board
        dp[0] = rev[0];//1st bill board
        
        int maxR = 0;//max revenue
        
        for(int i = 1; i < dp.length; i++){
            int max = 0;
            
            for(int j = 0; j < i; j++){
                if(x[i] - x[j] > t){//t gap
                    max = Math.max(dp[j], max);
                }
            }
            
            dp[i] = max + rev[i];//adding rev of ith board
            
            maxR = Math.max(maxR, dp[i]);//update
        }
        
        
        
        return maxR;
    }
    public static void input(int []arr,Scanner scn){
        for(int i = 0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
    }
    public static void main(String []args){
        Scanner scn = new Scanner(System.in);   
        int m = scn.nextInt();
        int n = scn.nextInt();
        
        int x[] = new int[n];
        input(x, scn);

        int revenue[] = new int[n];
        input(revenue,scn);

        int t = scn.nextInt();

        System.out.println(solution(m, x, revenue, t));
        scn.close();
    }
}
