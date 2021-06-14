/*
1. You are given an array(arr) of integers.
2. You have to find maximum subarray sum in the given array.
3. The subarray must have at least one element.
*/
import java.io.*;
import java.util.*;

public class Main {
    
    //solve in O(n)
  public static int solution(int[] arr) {
    int csum = 0;
    int osum = Integer.MIN_VALUE;
    
    //csum -> sum of previous subarray to the element
    
    for(int i = 0; i < arr.length; i++){
        //+ve -> prev seq is beneficial -> attach with it
        if(csum >= 0){
            csum += arr[i];
        }else{//-ve -> prev subarray reduce sum -> not used
            //make new sequence
            //adding with prev seq results in less sum
            
            csum = arr[i];
        }
        
        //update for maximum subarray sum
        if(csum > osum){
            osum = csum;
        }
    }

    return osum;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = scn.nextInt();
    }
    System.out.println(solution(arr));
  }
}
