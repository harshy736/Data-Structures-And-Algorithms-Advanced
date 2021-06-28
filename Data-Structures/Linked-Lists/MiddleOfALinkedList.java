/*
given a singly linked list with head node head, return a middle node of linked list.
if there is 2 mid node then return first mid node.
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

    public static ListNode midNode(ListNode head) {
        //LL of 0, 1 or 2 size
        if(head == null || head.next == null || head.next.next == null){
            return head;
        }
        
        ListNode ford = head;//forward -> fast - 2x
        ListNode mid = head;//mid node -> slow - x
        
        while(ford.next != null && ford.next.next != null){//2 nodes are +nt tp jump
            mid = mid.next;//jump by 1
            ford = ford.next.next;//jump by 2 to make mid as middle node
            //ford -> jumps twice than mid -> mid is always middle b/w head & forward node
        }
    
        return mid;
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

        ListNode head = midNode(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
