/*
1. Given a singly linklist, Segregate Node of LinkedList over lastindex and return pivot node of linkedlist.
2. pivot is always be last index of linkedlist.
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
    
    public static ListNode getTail(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode tail = head;
        
        while(tail.next != null){
            tail = tail.next;
        }
        
        return tail;
    }
    
    //remove nodes having value less than last element
    public static ListNode segregateOnLastIndex(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode tail = getTail(head);
        
        ListNode curr = head;
        
        //smaller LL -> left to pivot
        ListNode smaller = new ListNode(-1);
        ListNode ps = smaller;
        
        //right to pivot
        ListNode larger = new ListNode(-1);
        ListNode pl = larger;
        
        
        while(curr != null){
            if(curr.val <= tail.val){//smaller than pivot -> left
                ps.next = curr;
                ps = ps.next;
            }else{//right -> larger than pivot
                pl.next = curr;
                pl = pl.next;
            }
            
            curr = curr.next;//move
        }
        
        //last elemnt is the last element of smaller LL
        
        //link
        ps.next = larger.next;
        pl.next = null;//end
        
        return ps;//from pivot
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
        h1 = segregateOnLastIndex(h1);
        printList(h1);
    }
}
