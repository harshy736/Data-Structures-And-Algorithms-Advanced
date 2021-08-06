/*
Given an array nums of integers, return the number of non-empty continuous subarrays that satisfy the following condition:
The leftmost element of the subarray is not larger than other elements in the subarray.
*/

import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair{
        int value;
        int nos;
        
        Pair(int value, int nos){
            this.value = value;
            this.nos = nos;
        }
    }

  public static int validSubarrays(int[] nums) {
      Stack<Pair> st = new Stack<>();
      int count = 0;
      
      for(int i = nums.length - 1; i >= 0; i--){
          int nos = 1;//intialize with singlet subarray
          
          while(st.size() > 0 && nums[i] <= st.peek().value){//left not greater than other
              Pair p = st.pop();
              nos += p.nos;
              count += p.nos;
          }
          
          Pair el = new Pair(nums[i], nos);
          st.push(el);
      }
      
      //remaining elements
      while(st.size() > 0){
              Pair p = st.pop();
              count += p.nos;
        }
      
      return count;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int nums[] = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = Integer.parseInt(read.readLine());
    }

    int count = validSubarrays(nums);

    System.out.println(count);

  }
}
