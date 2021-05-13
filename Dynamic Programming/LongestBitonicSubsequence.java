//length of longest Bitionic sequence
//Bitonic seq -> Increasing seq then Decreasing seq
//we have to find a num which the sum of (inreaseing + decreasing) seq has become maximum , the increasing seq end on that num & decreasing seq starts from that num

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    int[] arr = new int[n];
    for(int i = 0; i < n; i++){
        arr[i] = scn.nextInt();
    }
    
    //dp array of Length of longest Incresaing seq
    int[] inc = new int[n];
    inc[0] = 1;//1st no -> length = 1
    
    //dp blocks stores the length of Long Inc Subseq which ends with that particular number in array
    
    for(int i = 1; i < n; i++){
        int max = 0;//max length of LIS pf that particular no
        
        for(int j = 0; j < i; j++){
            if(arr[i] >= arr[j]){
                if(inc[j] > max){
                    max = inc[j];
                }
            }
        }
        
        inc[i] = max + 1;
    }
    
    
    //dp array of Length of longest Deccresaing seq
    int[] dec = new int[n];
    dec[n - 1] = 1;//last number (always decreasing) -> length = 1
    
    //dp blocks stores the length of Long Dec Subseq which starts with that particular number in array
    
    //from right to left -> reverse direction from increasing seq
    for(int i = n - 2; i > 0; i--){
        int max = 0;//max length of LDS pf that particular no
        
        for(int j = n - 1; j > i; j--){
            if(arr[i] >= arr[j]){// left one is big for decreasing seq
                if(dec[j] > max){
                    max = dec[j];
                }
            }
        }
        
        dec[i] = max + 1;
    }
    
    //Maximize the sum of length of increasing & decreasing sequence for a partivular number
    int maxLen = 0;
    for(int i = 0; i < n; i++){
        maxLen = Math.max(maxLen, inc[i] + dec[i] - 1);//inc + dec - 1, here -1 is bcz to overcome the repeation of that number
    }
    
    
    System.out.println(maxLen);
   
  }

}
