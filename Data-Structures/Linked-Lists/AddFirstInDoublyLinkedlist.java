/*
1. You are given a partially written DoublyLinkedList class.
2. You are required to complete the body of addFirst function. This function is supposed to add an element to the front of LinkedList. You are required to update head, tail and size as required.
3. Input and Output is managed for you. Just update the code in addFirst function.

Note -> Use the code snippet and follow the algorithm discussed in question video. The judge can't 
        force you but the intention is to teach a concept. Play in spirit of the question.
*/

import java.util.*;

class Main {

  public static class DoublyLinkedList {
    private class Node {
      int data = 0;
      Node prev = null;
      Node next = null;

      Node(int data) {
        this.data = data;
      }

    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node curr = this.head;
      sb.append("[");
      while (curr != null) {
        sb.append(curr.data);
        if (curr.next != null)
          sb.append(", ");
        curr = curr.next;
      }
      sb.append("]");

      return sb.toString();
    }

    public void addFirst(int val) {
        Node node = new Node(val);
        
        if(head == null){
            head = tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        
        size++;
    }

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    DoublyLinkedList dll = new DoublyLinkedList();

    String str = scn.nextLine();
    while (!str.equals("stop")) {
      String[] s = str.split(" ");
      if (s[0].equals("addFirst"))
        dll.addFirst(Integer.parseInt(s[1]));

      str = scn.nextLine();
    }
    System.out.println(dll);
  }
}
