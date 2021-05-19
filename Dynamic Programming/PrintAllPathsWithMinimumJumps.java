/* 1. You are given a number N representing number of elements.
2. You are given N space separated numbers (ELE : elements).
3. Your task is to find & print  
    3.1) "MINIMUM JUMPS" need from 0th step to (n-1)th step.
    3.2) all configurations of "MINIMUM JUMPS".
*/

//something similar to print all LIS

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
    
    public static class Pair {
        int j;//min jumps required to reach this block from starting index
        int i;//index
        int v;//value -> jump size can perfom by this block
        String psf;//path so far
        
        Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
        
    public static void solution(int []arr){
        //we have to first find min number of jumps required to cober whole array
        //form 0th index to (i - 1)th index
        
        
        //every ith block stores min no of jumps required to go to last block/index from that index
        int[] dp = new int[arr.length];
        dp[dp.length - 1] = 0;//destination element -> no need of a jump
        
        //right to left
        
        //find min jumps for all the remaining elements
        for(int i = dp.length - 2; i >= 0; i--){
            int cj = arr.length;
            
            //we can not go anywhere
            if(arr[i] == 0){
                dp[i] = -1;
                continue;
            }
            
            //we iterate whole possiblity on which block we go through this block in a single jump
            for(int j = i + 1; j <= i + arr[i] && j < dp.length; j++){
                //arr[i] = max no of box we can jump in a single jump
 
                //get path having less no of jumps && path is also valid
                if(dp[j] < cj && dp[j] >= 0){
                    cj = dp[j];
                }
            }
            
            dp[i] = cj + 1;// + 1 for -> ith to jth block 
        }
        
        int mj = dp[0];//min jumps to iterate whole array from starting point
        
        System.out.println(mj);
        
        //queue helps us in find the order of jumps
        //we iterate from right to left 
        Queue<Pair> q = new ArrayDeque<>();
        
        //adding staring elemnt
        q.add(new Pair(0, mj,  "0"));
        
       
        while(q.size() > 0){
            Pair rem = q.remove();
            
            if(rem.i == dp.length - 1){//end point
                System.out.println(rem.psf + " .");
            }else{
                //iterate for all blocks on right of ith block on which we go through this block in a single jump 
                //arr[rem.i] = max size of jump taken from ith block
                for(int k = rem.i + 1; k <= rem.i + arr[rem.i] && k < dp.length; k++){
                    //we are looking for that element (kth) on which we can go through on a single jump from rem element and
                    //from that kth element min jumps is one less than the current one go
                    //means we are searching for block having min jumps = (j - 1)
                    
                    if(dp[k] == rem.j - 1){
                        q.add(new Pair(k, dp[k], rem.psf + " -> " + k));
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
        //array block stores the value which represents at max how many block can be jumped from that
        
        //value -> how far you go from that box in a jump

        solution(arr);

        scn.close();
    }
}
