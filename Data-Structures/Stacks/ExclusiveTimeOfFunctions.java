/*
1: On a single-threaded CPU, we execute a program containing n functions. Each function has a unique ID between 0 and n-1.
2: You are required to find the total execution time of each function.
3: You are given len number of logs, where logs[i] represents the ith log message formatted as a string "{function_id}:{"start" | "end"}:{timestamp}", telling start or end time of function with id function_id.

Note that a function can be called multiple times, possibly recursively.
*/

import java.io.*;
import java.util.*;

public class Main {
    public static class Pair{
        int id;
        int s;//start time
        int ct;//child time -> execution time of the children functions
        
       
    }

    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        // use read for taking input
        
        Stack<Pair> st = new Stack<>();
        
        int n = Integer.parseInt(read.readLine());
        int len = Integer.parseInt(read.readLine());
        
        int[] exTime = new int[n];//execution time for n functions
        
        for(int i = 0; i < len; i++){
            String[] log = read.readLine().split(":");//0 -> id, 1 -> start, end, 2->  stamp
            if(log[1].equals("start")){
                Pair p = new Pair();
                p.id = Integer.parseInt(log[0]);
                p.s = Integer.parseInt(log[2]);
                p.ct = 0;//no child in starting phase
                
                st.push(p);//add
            }else{//end
                Pair p = st.pop();//remove starting Pair of this function
                int interval =Integer.parseInt(log[2]) - p.s + 1;//total time function +nt in memory
                int time = interval - p.ct;//execution time if this funct by removing its child function time
                
                exTime[p.id] += time;
                
                //if this func has parent process -> update their child time
                if(st.size() > 0){
                    st.peek().ct += interval;
                }
            }
        }
        
        for(int e : exTime){
            System.out.println(e);
        }
    }
}
