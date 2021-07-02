/*
1. Given a singly linklist. determine if the linked list has a cycle in it.
2. There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
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

    public static boolean isCyclePresentInLL(ListNode head) {
        
        ListNode slow = head;//jump 1
        ListNode fast = head;//jump 2
        
        //slow & fast meet only if there is a cycle
        //fast speed must be twice to slow pointer
        
        boolean isCycle = false;
        
        while(fast != null && fast.next != null){
            slow = slow.next;//move
            fast = fast.next.next;
            
            if(slow == fast){//cyvle is there
                isCycle = true;
                break;
            }
        }

        return isCycle;
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
        System.out.println(isCyclePresentInLL(head));
    }
}
