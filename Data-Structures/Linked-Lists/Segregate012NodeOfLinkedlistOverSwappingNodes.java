/*
1. Given a singly linklist, Segregate 012 Node of LinkedList and return pivot node of linkedlist.
2. After segregation zero nodes should come first and then ones node followed by two's nodes.
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
        if(head == null || head.next == null) return null;
        
        ListNode zero = new ListNode(-1);
        ListNode pz = zero;
        
        ListNode one = new ListNode(-1);
        ListNode po = one;
        
        ListNode two = new ListNode(-1);
        ListNode pt = two;
        
        ListNode curr = head;
        
        while(curr != null){
            if(curr.val == 0){
                pz.next = curr;//add node in zero LL
                pz = pz.next;//move
            }else if(curr.val == 1){
                po.next = curr;
                po = po.next;
            }else{//2
                pt.next = curr;
                pt = pt.next;
            }
            
            //move
            curr = curr.next;
        }
        
        //finish 2 Ll
        pt.next = null;
        
        //link
        po.next = two.next;//1 -> 2 link first , bcz if no 1 is there , it also cannot link to 2
        pz.next = one.next;
        
        
        //removing dummy node of -1
        return zero.next;
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
