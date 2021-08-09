/*
Design your implementation of the circular double-ended queue (deque).

Your implementation should support following operations:

1. MyCircularDeque(): Initializes the deque object.
2. insertFront(): Adds an item at the front of Deque.
3. insertLast(): Adds an item at the rear of Deque.
4. deleteFront(): Deletes the front item from the Deque and return it's value. If the deque is empty, return null.
5. deleteLast(): Deletes the last item from Deque and return it's value. If the deque is empty, return null.
6. getFront(): Gets the front item from the Deque. If the deque is empty, return null.
7. getRear(): Gets the last item from Deque. If the deque is empty, return null.
8. isEmpty(): Checks whether Deque is empty or not.
*/

import java.io.*;
import java.util.*;

public class Main {
  public static class MyCircularDeque<T> {  
    private class Node{
        T value;
        Node next, prev;
        
        Node(){
            value = null;
        }
        
        Node(T value){
            this.value = value;
        }
        
        private void delete(){
            prev.next = next;
            next.prev = prev;
            next = prev = null;
            size--;
        }
    }
    
    Node head, tail;
    int size;

    /** Initialize your data structure here.*/
    public MyCircularDeque() {
        head = new Node();//dummy nodes
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        
        size = 0;//dummy not included
    }

    /**
     * Adds an item at the front of Deque.
     */
    public void insertFront(T value) {
        Node node = new Node(value);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        size++;
    }

    /**
     * Adds an item at the rear of Deque.
     */
    public void insertLast(T value) {
        Node node = new Node(value);
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        size++;
    }

    /**
     * Deletes the front item from the Deque and return it's value. If the deque is empty, return null.
     */
    public T deleteFront() {
        if(size == 0) return null;
        
        Node node = head.next;
        T val = node.value;
        
        node.delete();
        
        return val;
    }

    /**
     * Deletes the last item from Deque and return it's value. If the deque is empty, return null.
     */
    public T deleteLast() {
        if(size == 0) return null;
        
        Node node = tail.prev;
        T val = node.value;
        
        node.delete();
        
        return val;
    }

    /** Gets the front item from the Deque. If the deque is empty, return null. */
    public T getFront() {
        if(size == 0) return null;
        
        Node node = head.next;
        T val = node.value;
        
        return val;
    }

    /** Gets the last item from Deque. If the deque is empty, return null. */
    public T getRear() {
        if(size == 0) return null;
        
        Node node = tail.prev;
        T val = node.value;
        
        return val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        if(size == 0){
            return true;
        }
        
        return false;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MyCircularDeque<Integer> obj = new MyCircularDeque<>();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");
      String s = inp[0];

      if (s.equals("insertLast")) {
        obj.insertLast(Integer.parseInt(inp[1]));
      } else if (s.equals("insertFront")) {
        obj.insertFront(Integer.parseInt(inp[1]));
      } else if (s.equals("deleteFront")) {
        System.out.println(obj.deleteFront());
      } else if (s.equals("deleteLast")) {
        System.out.println(obj.deleteLast());
      } else if (s.equals("getFront")) {
        System.out.println(obj.getFront());
      } else if (s.equals("getRear")) {
        System.out.println(obj.getRear());
      } else if (s.equals("isEmpty")) {
        System.out.println(obj.isEmpty());
      }
    }

  }
}
