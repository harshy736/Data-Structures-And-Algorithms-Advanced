//to find maximum number of envelopes that can be nested inside each other

import java.io.*;
import java.util.*;

public class Main {

    public static class Envelope implements Comparable<Envelope>{
      int width;
      int height;
      
      Envelope(int width, int height){
          this.width = width;
          this.height = height;
      }
      
      public int compareTo(Envelope other){
          if(this.width != other.width){
            return this.width - other.width;
          }else{
              return this.height - other.height;
          }
      }
    }

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    Envelope[] env = new Envelope[n];
    
    for(int i = 0; i < n; i++){
        int width = scn.nextInt();
        int height = scn.nextInt();
        
        env[i] = new Envelope(width, height);
    }
    
    //Sorting env on the basis of their width
    Arrays.sort(env);
    
    //dp array 
    int[] dp = new int[n];
    dp[0] = 1;//1st env = 1
    
    //dp blocks stores the max no. of envelops ehich can nested inside the ith block from left to roght
    
    int maxEnv = 1;
    
    //iterate over all bridges except first one
    for(int i = 1; i < n; i++){
        int max = 0;//max number of envelopes when ith env is parent or biggest env 
        
        //compare with all previous envelopes
        for(int j = 0; j < i; j++){
            if(env[i].height >= env[j].height){// condiotion -> jth env is smaller in width then height of jth env is ALSO smaller than ith env
                if(dp[j] > max){
                    max = dp[j];
                }
            }
        }
        
        dp[i] = max + 1;
        
        if(dp[i] > maxEnv){
            maxEnv = dp[i];
        }
    }
    
    
    System.out.println(maxEnv);
   
  }

}
