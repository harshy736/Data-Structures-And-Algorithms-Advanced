/*
1. Given the head of a linked list, return the list after sorting it in increasing order.
2. You must apply quick sort.
3. Time Complexity : O(nlogn)
4. Space Complexity : constant space
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

    public static ListNode quickSort(ListNode head) {
        if(head == null || head.next == null) return head; //base
        
        //first element -> pivot -> head
        //partition LL into 2 parts acc to pivot element
        
        ListNode smaller = new ListNode(-1);
        ListNode ps = smaller;
        
        ListNode larger = new ListNode(-1);
        ListNode pl = larger;
        
        ListNode curr = head.next;//start after pivot element
        ListNode pivot = head;
        
        while(curr != null){
            if(curr.val <= pivot.val){//smaller
                ps.next = curr;
                ps = ps.next;
            }else{//larger
                pl.next = curr;
                pl = pl.next;
            }
            
            //move
            curr = curr.next;
        }
        
        ps.next = null;
        pl.next = null;//end
        
        //sort 2 parts independently by recursion
        smaller = quickSort(smaller.next);
        larger = quickSort(larger.next);
        
        ps = getTail(smaller);//tail os sorted smaller LL
        
        //link
        if(ps == null){//no smaller LL
            smaller = pivot;
        }else{
            ps.next = pivot;
        }
        
        pivot.next = larger;
        
        return smaller;
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

        ListNode head = quickSort(h1);
        printList(head);
    }
}
