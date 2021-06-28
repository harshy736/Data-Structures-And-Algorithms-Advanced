/*
Given a singly linkedlist : l0 -> ln -> l1 -> ln-1 -> l2 -> ln-2 -> l3 -> ln-3 -> ..... 
reorder it :  l0 -> l1 -> l2 -> l3 -> l4 -> l5 -> l6 ..... -> ln-1 -> ln
for more information watch video.
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


    public static ListNode reverse(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode prev = null;
        ListNode forw = null;//forward
        
        while(curr != null){
            forw = curr.next;//goes to next node
            curr.next = prev;//reverse
            
            prev = curr;//update prev for next node
            curr = forw;//update curr
        }
        
        return prev;//stores last node of original LL
    }


    public static void unfold(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        
        ListNode sh = head.next;//second hand
        
        ListNode c1 = head;//first LL
        ListNode c2 = sh;//2nd LL
        ListNode f = null;//forward
        
        while(c2 != null && c2.next != null){//for odd & even LL , even -> avoid null pointer excp
            f = c2.next;//Backup -> forward
            
            //Links
            c1.next = f;
            c2.next = f.next;
            
            //move
            c1 = f;
            c2 = f.next;
        }
        c1.next = null;
        sh = reverse(sh);//reverse of 2nd LL
        
        //merge 2 LL
        c1.next = sh;
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
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

        ListNode head = dummy.next;
        unfold(head);
        printList(head);
    }
}
