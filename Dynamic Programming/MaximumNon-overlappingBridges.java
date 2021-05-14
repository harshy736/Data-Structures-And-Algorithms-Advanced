//to find maximum number of non - overlapping bridges in a city

import java.io.*;
import java.util.*;

public class Main {

    public static class Bridge implements Comparable<Bridge>{
      int start;
      int end;
      
      Bridge(int start, int end){
          this.start = start;
          this.end = end;
      }
      
      public int compareTo(Bridge other){
          if(this.start != other.start){
            return this.start - other.start;
          }else{
              return this.end - other.end;
          }
      }
    }

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    Bridge[] bdges = new Bridge[n];
    
    for(int i = 0; i < n; i++){
        int start = scn.nextInt();
        int end = scn.nextInt();
        
        bdges[i] = new Bridge(start, end);
    }
    
    //Sorting bridges on the basis of their starting point
    Arrays.sort(bdges);
    
    //dp array 
    int[] dp = new int[n];
    dp[0] = 1;//1st bridge -> possible bridge = 1
    
    //dp blocks stores the max no. of non - overlapping bridges possible if particular bridges is the last bridge
    
    int maxBridges = 1;
    
    //iterate over all bridges except first one
    for(int i = 1; i < n; i++){
        int max = 0;//max number of non - overlap bridges when ith bridge is last bridge
        
        //compare with all previous bridges
        for(int j = 0; j < i; j++){
            if(bdges[i].end >= bdges[j].end){//non - overlapping condiotion -> bcz jth bridge is smaller in starting point then end point of jth bridge is ALSO smaller than ith bridge
                if(dp[j] > max){
                    max = dp[j];
                }
            }
        }
        
        dp[i] = max + 1;
        
        if(dp[i] > maxBridges){
            maxBridges = dp[i];
        }
    }
    
    System.out.println(maxBridges);
   
  }

}
