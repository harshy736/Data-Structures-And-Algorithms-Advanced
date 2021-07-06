/*
1. Given a singly linklist, Segregate Node of LinkedList over pivot index and return starting node of linkedlist.
2. pivot will be any random index in range of 0 to length Of Linkedlist
3. After segregation pivot Element should have to be present at correct position as in sorted linkedlist.
*/

import java.util.*;

class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
  
  public static ListNode getPivot(ListNode head, int pivotIdx){
      int idx = 0;
      ListNode curr = head;
      
      while(idx != pivotIdx && curr != null){
          curr = curr.next;
          idx++;
      }
      
      return curr;//pivot
  }

  public static ListNode segregate(ListNode head, int pivotIdx) {
    if(head == null || head.next == null) return head;
      
    ListNode pivot = getPivot(head, pivotIdx);//pivot node
    ListNode curr = head;
    
    ListNode smaller = new ListNode(-1);
    ListNode ps = smaller;
    
    ListNode larger = new ListNode(-1);
    ListNode pl = larger;
    
    while(curr != null){
        if(curr == pivot){//placed after smaller portion
            curr = curr.next;
            continue;
        }else if(curr.val <= pivot.val){//smaller
            ps.next = curr;
            ps = ps.next;
        }else{//larger
            pl.next = curr;
            pl = pl.next;
        }
        
        //move
        curr = curr.next;
    }
    
    //link
    ps.next = pivot;
    pivot.next = larger.next;
    pl.next = null;
    
    return smaller.next;
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode createList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    ListNode h1 = createList(n);
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}
