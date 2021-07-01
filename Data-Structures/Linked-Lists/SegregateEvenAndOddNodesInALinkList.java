/*
Given a singly linklist, modify the list such that all the even numbers appear before all the odd numbers in the modified list. The order of appearance of numbers within each segregation should be same as that in the original list.
*/

import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode even = new ListNode(-2);//dummy for even LL
        ListNode odd = new ListNode(-1);//dummy for even LL
        
        ListNode curr = head;
        ListNode ce = even;
        ListNode co = odd;
        
        ListNode forw = null;
        
        //iterate whole original LL
        while(curr != null){
            //Backup for remainning LL 
            forw = curr.next;
            
            //isolate this node
            curr.next = null;
            
            if(curr.val % 2 == 0){//even
                ce.next = curr;//link
                ce = ce.next;//move pointer
                
            }else{
                co.next = curr;//link
                co = co.next;//move pointer
            }
            
            //move pointer
            curr = forw;
        }
        
        //remove dummy nodes
        even = even.next;
        odd = odd.next;
        
        if(even == null){//no even element
            return odd;
        }else if(odd == null){//no odd lement
            return even;
        }
        
        //merge even & odd LL -> odd in last of even
        ce.next = odd;
        
        head = even;
        
        return head;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
