/*
1. You are given an array(arr) of size k which contains prime numbers in ascending order, and an integer N.
2. You have to find Nth super ugly number.
3. Super ugly number is defined as the number whose prime factors are elements of the given array.

Assumption -> 1 is the first super ugly number.
*/


import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair implements Comparable<Pair>{
        int prime;
        int pointer;
        int value;
        
        public Pair(int prime, int pointer, int value){
            this.prime = prime;
            this.pointer = pointer;
            this.value = value;
        }
        
        public int compareTo(Pair o){
            return this.value - o.value;
        }
    }

  public static int solution(int[] primes, int n) {
    //like ugly number
    
    int[] dp = new int[n + 1];
    dp[1] = 1;
    
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    
    for(int i = 0; i < primes.length; i++){
        pq.add(new Pair(primes[i], 1, primes[i]));
    }
    
    for(int i = 2; i <= n; ){
        Pair rp = pq.remove();//gives object having minimum value
        
        //if same value is come more than once then it count as a single super ugly number
        //object is updated all the time
        if(rp.value != dp[i - 1]){//unique value 
             dp[i] = rp.value;
            
             i++;//ith super ugly number is found
        }
        
        //object update by increasing pointer & value
        pq.add(new Pair(rp.prime, rp.pointer + 1,rp.prime * dp[rp.pointer + 1]));
    }
    
    return dp[n];

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int k = scn.nextInt();
    int[] primes = new int[k];
    for (int i = 0 ; i < k; i++) {
      primes[i] = scn.nextInt();
    }
    int n = scn.nextInt();
    System.out.println(solution(primes, n));
  }

}
