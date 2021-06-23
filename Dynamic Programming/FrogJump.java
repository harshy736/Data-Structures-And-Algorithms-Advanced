/*
1. You are given an array of positive integers in ascending order, which represents the position of stones in the river.
2. A frog is trying to cross a river. It can jump on a stone, but it must not jump into the water.
3. You have to find if the frog can cross the river by landing on the last stone.
4. The frog is on the first stone initially, and from first stone it can jump 1 unit only.
5. The frog can only jump k-1, k, or k+1 units in the forward direction, where k is the frog's last jump.
*/

import java.io.*;
import java.util.*;

public class Main {

  public static boolean solution(int[] stones) {
    // write your code here
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    //hasmap -> stone -> stores jumps we can make from that stone
    
    //for all the stones only
    for(int i = 0; i < stones.length; i++){
        map.put(stones[i], new HashSet<>());
    }
    
    //for 1st stone -> jump of 1 unit only
    map.get(stones[0]).add(stones[0] + 1);
    
    for(int i = 0; i < stones.length; i++){
        int currStone = stones[i];
        
        HashSet<Integer> jumps = map.get(currStone);
        
        for(int jump : jumps){
            int pos = currStone + jump;//we go after jump by currStone
            
            //if we land on last stone
            if(pos == stones[stones.length - 1]){
                return true;
            }
            
            //if we land on stone rather than water
            if(map.containsKey(pos) == true){
                if(jump > 1){//if jump = 1, we store 0 unit of jump which is useless
                    map.get(pos).add(jump - 1);//k - 1
                }
                
                map.get(pos).add(jump);//k
                map.get(pos).add(jump + 1);//k + 1
            }
        }
    }
    
    //never land on last stone
    return false;

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0 ; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(solution(arr));
  }

}
