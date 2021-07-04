/*
1. Given the heads of two singly linked-lists headA and headB
2. Return the node at which the two lists intersect. 
3. If the two linked lists have no intersection, return null.
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
    
    public static int length(ListNode head){
        int len = 0;
        ListNode curr = head;
        
        while(curr != null){
            len++;
            curr = curr.next;
        }
        
        return len;
    }
    
    public static ListNode reduceLL(ListNode head, int len, int clen){
        ListNode curr = head;
        
        while(len != clen){//until len != clen
            curr = curr.next;
            len--;
        }
        
        return curr;
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        int lenA = length(headA);//length of A
        int lenB = length(headB);//length of B
        
        int clen = Math.min(lenA, lenB);//common length -> shortest LL
        //reduce large LL to this LL -> bcz intersection point lie on both LL
        
        if(lenA > clen){//A -> large LL
            headA = reduceLL(headA, lenA, clen);
        }else if(lenB > clen){//B -> large LL
            headB = reduceLL(headB, lenB, clen);
        }
        
        ListNode currA = headA;
        ListNode currB = headB;
        //move both pointer with same speed
        //common node -> intersection node
        
        while(currA != null){
            if(currA == currB){
                break;
            }
            
            //move
            currA = currA.next;
            currB = currB.next;
        }
        
        if(currA == null){//no common node
            return null;
        }
        
        return currA;//common node on which loop break
    }

    // Input_code===================================================

    public static ListNode makeList(int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = makeList(scn.nextInt());

        int idx = scn.nextInt();

        ListNode head2 = makeList(scn.nextInt());

        if (idx >= 0) {
            ListNode curr = head1;
            while (idx-- > 0)
                curr = curr.next;

            ListNode prev = head2;
            while (prev.next != null)
                prev = prev.next;

            prev.next = curr;
        }

        ListNode ans = IntersectionNodeInTwoLL(head1, head2);
        System.out.println(ans != null ? ans.val : -1);
    }
}
