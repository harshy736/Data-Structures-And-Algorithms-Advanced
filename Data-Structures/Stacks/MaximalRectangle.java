/*
1. Given a rows x cols binary matrix filled with 0's and 1's.
2. Find the largest rectangle containing only 1's and return its area.
*/

import java.io.*;
import java.util.*;

public class Main {

    public static int maximalRectangle(int[][] arr) { 
        int[] heights = new int[arr[0].length];
        
        for(int j = 0; j < arr[0].length; j++){
            heights[j] = arr[0][j];
        }
        
        int maxArea = largestRectangleArea(heights);
        
        //treat every row as a histogram & find a max araea rectangle
        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] == 1){
                    heights[j]++;
                }else{//height = 0
                    heights[j] = 0;
                }
            }
            
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        
        return maxArea;
    }
    
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

        int row = Integer.parseInt(read.readLine());
        int col = Integer.parseInt(read.readLine());
        
        int bmat[][] = new int[row][col];

        for(int i=0;i<row;i++){
            String s = read.readLine();
            for(int j=0;j<col;j++){
                bmat[i][j] = s.charAt(j)-'0';
            }
        }

        int result = maximalRectangle(bmat);
        System.out.println(result);
        
    }
}
