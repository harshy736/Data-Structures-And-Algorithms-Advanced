/*
1. Given an integer array nums and a positive integer k;
2. return the lexicographically smallest subsequence of size k;
*/

import java.io.*;
import java.util.*;

public class Main {
  public static int[] smallest(int[] nums, int k) {
    //find a subsequence which is lexiographically smaller
    //increasing order nhi h
    
    Stack<Integer> st = new Stack<>();
    int n = nums.length;
    
    //check for a potential candidate in the subsequence
    //if after adding ith element -> x elemnts are more required in k subseq
    //then ti is valid only iff -> atleast x elements are +nt in the array nums
    
    //req = n - st.size
    //rem = n - (i + 1)
    
    //rem >= req -> potential candidate for that pos in the subsequence
    //fill position with smallest of all the potential elements
    
    for(int i = 0; i < n; i++){
        int val = nums[i];
        
        int rem = n - i - 1;
        
        //finding correct position for ith element by removing larger elements
        while(st.size() > 0 && val < st.peek() && rem >= k - st.size()){
            st.pop();
        }
        
        if(st.size() < k){
            st.push(val);//add to the subsequence
        }
    }
    
    int[] ans = new int[k];
    for(int i = k - 1; i >= 0; i--){
        ans[i] = st.pop();
    }
    
    return ans;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine());
    int k = Integer.parseInt(read.readLine());
    int ans[] = smallest(arr, k);
    System.out.println(ans.length);

    for (int e : ans) {
      System.out.println(e);
    }

  }
}
