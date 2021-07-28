/*
1. You are given an array asteroids of integers representing asteroids in a row.
2. For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left).
3. Each asteroid moves at the same speed.
4. You need to find out the state of the asteroids after all collisions.
5. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
*/

import java.io.*;
import java.util.*;

public class Main {

  public static int[] asteroidCollision(int[] asteroids) {
    // complete this function
    Stack<Integer> st = new Stack<>();
    //stack stores asteroid those are remainning
    
    for(int val : asteroids){
        //+ve can not collide with previous left dir -> it only collides with upcoming left
        if(val > 0){
            st.push(val);
        }else{//asteroid is in left direction
            while(st.size() > 0 && st.peek() > 0 && st.peek() < -val){//+ve are smaller -> explode
                st.pop();
            }
            
            if(st.size() > 0 && st.peek() == -val){//both explode
                st.pop();
            }else if(st.size() > 0 && st.peek() > -val){//val explode -> smaller -> not push element
                
            }else{//size == 0 or peek -> -ve no
                st.push(val);
            }
        }
    }
    
    //fill answer in array
    int[] res = new int[st.size()];
    for(int i = res.length - 1; i >= 0; i--){//in input array order
        res[i] = st.pop();
    }
    
    return res;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());
    int arr[] = new int[n];
    for (int i = 0; i < n; i++)arr[i] = Integer.parseInt(read.readLine());
    int result[] = asteroidCollision(arr);

    System.out.println(result.length);
    for (int e : result) {
      System.out.println(e);
    }

  }
}
