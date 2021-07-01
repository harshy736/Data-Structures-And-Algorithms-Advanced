/*
Given a singly linklist, remove the nth node from the end of the list and return its head.
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

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    //wee take 2 pointers
    
    //first -> head node of the LL
    ListNode first = head;
    
    //Intially second also points to head node
    //But it aims to point (N + 1)th node from beginning
    ListNode second = head;
    
    //Take second listnode to Nth node from beginning
    for(int i = 1; i <= n; i++){//i -> second comes ->ith node
        // N is greater than size of LL, size <= n
        if(second.next == null){
            if(i == n){//total N nodes -> remove head node
                return head.next;
            }
            
            return new ListNode(-1);
        }
        
        second = second.next;
    }
    
    //first -1st node , second -> (n + 1)th node from begin
    
    //We move both nodes at same speed until second reaches to last node
    //i.e first reaches (N+1)th node from end
    //Then delete first node
    
    while(second.next != null){
        first = first.next;
        second = second.next;
    }
    
    //remove node
    first.next = first.next.next;//nth node removed
    
    return head;
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

    int m = scn.nextInt();
    h1 = removeNthFromEnd(h1, m);
    printList(h1);
  }
}
