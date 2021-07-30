/*
1. Given n non-negative integers representing an elevation map where the width of each bar is 1.
2. Compute how much water it can trap after raining.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);//if peek == -1 -> no left boundary +nt for that bar
        
        //water can stored b/w 2 boundary walls which are higher than the current bar
        
        int water = 0;
        for(int i = 0; i < height.length; i++){
            int val = height[i];
            
            //if ith is right boundary for the peek element
            while(st.peek() != -1 && height[st.peek()] <= val){
                int rb = i;
                int h = height[st.pop()];//height of that bar
                int lb = st.peek();
                if(lb == -1){//no left boundary exist
                    break;
                }
                
                int width = rb - lb - 1;
                int minHeight = Math.min(height[rb], height[lb]);//min of boundary height -> bcz water can stored upto min wall height
                int depth = minHeight - h;//depth of the conatiner
                
                water += depth * width;
            }
            
            st.push(i);
        }
        
        
        return water;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int arr[] = new int[n];
        for(int i=0;i<n;i++)arr[i] = Integer.parseInt(read.readLine());
        int result = trap(arr);
        System.out.println(result);
        
    }
}
