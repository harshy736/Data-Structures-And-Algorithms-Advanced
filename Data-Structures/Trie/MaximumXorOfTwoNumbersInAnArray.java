/*
1. Given an integer array nums.
2. return the maximum result of nums[i] XOR nums[j], where 0 <= i <= j < n.
*/

import java.io.*;
import java.util.*;

public class Main {
    
  public static class Trie{
      public static class Node{
          Node left, right;//left - 0, right - 1 
      }
      
      static Node root;
      
      Trie(){
          root = new Node();
      }
      
      public static void insert(int val){
          Node curr = root;
          int bitIndex = 30;//bcz int is of 31 bits excluding sign bit
          //start from rightmost bit
          
          while(bitIndex-- > 0){
              int mask = 1 << bitIndex;//1 to bitINdex pos
              int bit = (mask&val) > 0 ? 1 : 0;//bit at bitindex pos
              
              if(bit == 0){
                  if(curr.left == null) curr.left = new Node();
                  
                  curr = curr.left;
              }else{
                  if(curr.right == null) curr.right = new Node();
                  
                  curr = curr.right;
              }
          }
      }
      
      public static int query(int find){
          Node curr = root;
          int bitIndex = 30;
          int ans = 0;
          
          while(bitIndex-- > 0){
              int mask = 1 << bitIndex;//1 to bitINdex pos
              int bit = (mask & find) > 0 ? 1 : 0;//bit at bitindex pos -> desired bit
              
              if(bit == 0){
                  if(curr.left != null){
                      curr = curr.left;
                  }else{//0 not exist -> take 1
                      curr = curr.right;
                      ans = ans | mask;//adding 1 in ans at bitIndex
                  }
              }else{
                  if(curr.right != null){
                      curr = curr.right;
                      ans = ans | mask;//adding 1 in ans at bitIndex
                  }else{//1 not exist -> take 0
                      curr = curr.left;
                  }
              }
          }
          
          return ans;
      }
      
  }

  public static int findMaximumXOR(int[] nums) {
    // write your code here
    Trie trie = new Trie();
    
    for(int val : nums){
        trie.insert(val);
    }
    
    int max = 0;
    
    for(int val : nums){
        int find = Integer.MAX_VALUE ^ val;//no which can make max int on xor with val
        //dream/desired number to make ans max
        
        int res = trie.query(find);//best no we can get in array
        max = Math.max(max, res ^ val);//update
    }

    return max;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine().trim());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine().trim());

    int result = findMaximumXOR(arr);
    System.out.println(result);

  }
}
