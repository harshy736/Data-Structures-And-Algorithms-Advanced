/*
1. Given a singly linklist, Segregate 01 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and followed by ones node.
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

    public static ListNode segregate01(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode one = null;//points to starting of 1's in the LL
        //no one exists before one
        //if 0 found -> swap 0 with this one node
        
        while(curr != null){
            if(curr.val == 1){
                if(one == null)//1st one found in the LL
                    one = curr;
            }else{//0
                if(one != null){//1 exist prior to 0 -> swap with it
                    curr.val = 1;
                    one.val = 0;//swap
                    
                    //move
                    one = one.next;//next 1 belongs to exactly right of one
                }
            }
            
            curr = curr.next;//move
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
        h1 = segregate01(h1);
        printList(h1);
    }
}
