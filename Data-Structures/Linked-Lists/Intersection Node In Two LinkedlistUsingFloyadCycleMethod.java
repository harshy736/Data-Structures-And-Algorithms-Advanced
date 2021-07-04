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
    
    public static ListNode startingNodeOfCycle(ListNode head){
        if(head == null || head.next == null) return null;
        
        ListNode slow = head;
        ListNode fast = head;
        
        //to find cycle or reference node
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) break;//reference point -> cycle +nt
        }
        
        if(slow != fast){//no cycle +nt
            return null;
        }
        
        //move from head & reference point with same speed -> meet pointer -> starting node
        slow = head;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }

    public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;//no intersection possible
        
        //In this approach, we try to make a cycle by linking 2 LL
        //and intersetion point is the starting point of cycle in the resultant LL
        //link LL A then LL B
        
        ListNode tail = headA;//tail of LL A
        
        while(tail.next != null){
            tail = tail.next;
        }
        
        //link both LL
        tail.next = headB;
        
        //now intersection point is the starting point of cycle
        // if no cycle formed -> no intersection point exists
        
        ListNode ans = startingNodeOfCycle(headA);
        
        tail.next = null;//separate LL
        
        return ans;//intersection node
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
