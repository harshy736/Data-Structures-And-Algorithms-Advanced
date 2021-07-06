/*
1. Given a singly linklist, Segregate 012 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and then ones node followed by two's nodes.
3. You are only allowed to swap data not swap nodes.
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

    public static ListNode segregate012(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode one = null;
        ListNode two = null;
        ListNode curr = head;
        
        //separate 0 on the left -> treat 1,2 as non - zero
        //one -> starting of 1 or 2 -> anyone
        while(curr != null){
            if(curr.val == 0){
                if(one != null){//non zero elem exist before this 0
                    curr.val = one.val;//store val in one node -> 1 or 2
                    one.val = 0;//place zero
                    
                    one = one.next;//move
                }
            }else{
                if(one == null) one = curr;//first non zero element
            }
            
             curr = curr.next;
        }
        
        //Now we have to separate 1 & 2 in the remainning LL
        curr = one;//remain LL start from here
        
        while(curr != null){
            if(curr.val == 1){
                if(two != null){//2 exist before this 1
                    two.val = 1;
                    curr.val = 2;
                    
                    two = two.next;
                }
            }else{
                if(two == null) two = curr;
            }
            
            curr = curr.next;
        }
        
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
        h1 = segregate012(h1);
        printList(h1);
    }
}
