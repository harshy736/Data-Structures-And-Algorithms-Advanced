/*
1. You are given a number n, representing the size of array a.
2. You are given n numbers, representing the height of bars in a bar chart.
3. You are required to find and print the area of largest rectangle in the histogram.

Challenge. Could u solve it in one iteration.
Note. This question is same as Largest Area Histogram just the constrains are higher.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);//outermost left
        
        int maxArea = 0;
        for(int i = 0; i <= heights.length; i++){
            int val = i == heights.length ? 0 : heights[i];//0 for the remainning rectangles after full iteration
            
            while(st.peek() != -1 && heights[st.peek()] >= val){
                int rb = i;//right boundary -> bcz peek is greater than ith -> next smaller element on right
                int h = heights[st.pop()];//height
                int lb = st.peek();//left boundary -> nextt smaller element on left
                
                maxArea = Math.max(maxArea, h * (rb - lb - 1));//width = rb - lb - 1
            }
            
            st.push(i);
        }
        
        return maxArea;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int heights[] = new int[n];
        for(int i=0;i<n;i++)heights[i] = Integer.parseInt(read.readLine());

        System.out.println(largestRectangleArea(heights));
        
    }
}
