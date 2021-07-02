/*
1. Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
2. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.

Notice that you should not modify the linked list.
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

    public static ListNode CycleNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head;//jump 1
        ListNode fast = head;//jump 2
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                break;
            }
        }
        
        //singly LL -> no cycle +nt
        if(slow != fast){
            return null;
        }
        
        //slow/fast reprsents the reference point in the cycle where they meet
        
        //To find start point of the cycle
        //we take 2 pointers -> 1 on head & other on referrrsence node
        //move bith by same speed -> they will definitely meet at start point of the cycle
        slow = head;//1st pointer
        //fast -> 2nd pointer
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;//cycle node or start node of cycle
    }

    public static ListNode takeInput() {
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }
        int idx = scn.nextInt();
        if (idx >= 0) {
            ListNode curr = dummy.next;
            while (idx-- > 0) {
                curr = curr.next;
            }
            prev.next = curr;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = takeInput();
        ListNode ans = CycleNode(head);
        System.out.println(ans!=null?ans.val:-1);
    }
}
