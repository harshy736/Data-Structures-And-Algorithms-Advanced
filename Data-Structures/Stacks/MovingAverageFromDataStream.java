/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Implement the MovingAverage class:
1. MovingAverage(int size) Initializes the object with the size of the window size.
2. double next(int val) Returns the moving average of the last size values of the stream.
*/

import java.io.*;
import java.util.*;

public class Main {
  public static class MovingAverage {
    Queue<Integer> q;
    int size, sum;
    
    public MovingAverage(int size) {
        q = new ArrayDeque<>();
        this.size = size;//max size
        sum = 0;
    }

    public double next(int val) {
        q.add(val);
        sum += val;
        
        if(q.size() > size){//remove from starting
            sum -= q.remove();
        }
        
        double avg = ((double)sum)/q.size();
        return avg;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(read.readLine());
    MovingAverage obj = new MovingAverage(size);
    PrintWriter out = new PrintWriter(System.out);
    while (read.ready()) {
      int val = Integer.parseInt(read.readLine());
      double avg = obj.next(val);

      StringBuilder ans = new StringBuilder(String.format("%.5f", avg));
      while (ans.charAt(ans.length() - 2) != '.' && ans.charAt(ans.length() - 1) == '0') {
        ans.deleteCharAt(ans.length() - 1);
      }
      out.println(ans);
    }
    out.close();
  }
}
