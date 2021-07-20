/*
Design a stack which supports the following operations.

Implement the CustomStack class:

    1: void push(int x) Adds x to the top of the stack if the stack hasn't reached the maxSize.
    2: int pop() Pops and returns the top of stack or -1 if the stack is empty.
    3: void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, just increment all the elements in the stack
*/

import java.io.*;
import java.util.*;

public class Main {
    public static class CustomStack {
    
        int value[];
        int increment[];
        int index;//TOS
        
        public CustomStack(int maxSize) {
            value = new int[maxSize];
            increment = new int[maxSize];
            index=-1;
        }
        
        public void push(int x) {
            if(index == value.length - 1){//space -nt
                return;
            }
            
            index++;
            value[index] = x;
            increment[index] = 0;
        }
        
        public int pop() {
            if(index == -1){
                return -1;
            }
            
            int x = value[index];
            int inc = increment[index];
            index--;//pop
            
            if(index >= 0){
                increment[index] += inc;//all elements below TOS increase by this inc
            }
            
            return x + inc;
        }
        
        //O(1)
        public void increment(int k, int val) {
            int i = Math.min(index, k - 1);
            
            if(index >= 0){//elment exist
                increment[i] += val;//all elements below ith -> increase by val also
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int maxsize = Integer.parseInt(read.readLine());

        CustomStack cs = new CustomStack(maxsize);
        
        while(true){
            String task[] = read.readLine().split(" ");
            if(task[0].equals("push")){
                cs.push(Integer.parseInt(task[1]));
            }else if(task[0].equals("pop")){
                System.out.println(cs.pop());
            }else if(task[0].equals("increment")){
                cs.increment(Integer.parseInt(task[1]), Integer.parseInt(task[2]));
            }else{
                break;
            }
        }
        System.out.println("exit");
    }
}
