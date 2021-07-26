/*
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].
Return true if there is a 132 pattern in nums, otherwise, return false.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        Stack<Integer> st = new Stack<>();
        boolean is132 = false;
        
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++){
            nums[i] = scn.nextInt();
        }
        
        int[] min = new int[n];
        //ith cal minimum value upto ith element starting from left
        min[0] = nums[0];
        for(int i = 1; i < n; i++){
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        
        
        for(int j = n - 1; j > 0; j--){
            while(st.size() > 0 && st.peek() <= min[j]){//cond false
                st.pop();
            }
            
            //kth > ith -> satisfied already
            if(st.size() > 0 && st.peek() < nums[j]){//st.peek -> contains kth element
                is132 = true;
                break;
            }
            
            st.push(nums[j]);
        }
        
        
        System.out.println(is132);

      
    }
}
