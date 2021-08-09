/*
Design a max stack data structure that supports the stack operations and supports finding the stack's maximum element.

Implement the MaxStack class:
1. MaxStack() Initializes the stack object.
2. void push(int x) Pushes element x onto the stack.
3. int pop() Removes the element on top of the stack and returns it.
4. int top() Gets the element on the top of the stack without removing it.
5. int peekMax() Retrieves the maximum element in the stack without removing it.
6. int popMax() Retrieves the maximum element in the stack and removes it. If there is more than one maximum element, only remove the top-most one.
*/

import java.io.*;
import java.util.*;

public class Main {
  public static class MaxStack {
    Stack<Integer> st , max;
    

    public MaxStack() {
        st = new Stack<>();
        max = new Stack<>();
    }

    public void push(int x) {
        st.push(x);
        int m = (max.size() == 0) ? x : Math.max(x, max.peek());
        
        max.push(m);//maximum upto xth element
    }

    public int pop() {
      max.pop();
      return st.pop();
    }

    public int top() {
      return st.peek();
    }

    public int peekMax() {
      return max.peek();
    }

    public int popMax() {
      Stack<Integer> helper = new Stack<>();
      int tbr = max.peek();//maximum element
      
      while(st.peek() != tbr){
          helper.push(pop());//fill into helper
      }
      
      pop();//remove max element
      
      //fill remainning elements back to stack
      while(helper.size() > 0){
          int x = helper.pop();
          push(x);
      }
      
      
      return tbr;
    }

  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MaxStack maxst = new MaxStack();

    while (read.ready()) {
      String []inp = read.readLine().split(" ");

      switch (inp[0]) {
        case "pop":
          System.out.println(maxst.pop());
          break;
        case "top":
          System.out.println(maxst.top());
          break;
        case "popMax":
          System.out.println(maxst.popMax());
          break;
        case "peekMax":
          System.out.println(maxst.peekMax());
          break;
        case "push":
          maxst.push(Integer.parseInt(inp[1]));
          break;
      }

    }

  }
}
