/*
Given the head of a linked list, return the list after sorting it in increasing order.
Time Complexity : O(nlogn)
Space Complexity : constant space 
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
    
    public static ListNode middle(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){//fast only moves when atleast 2 nodes are +nt in forward
            slow = slow.next;//1 jump
            fast = fast.next.next;//2 jump
        }
        
        
        //n = odd, 2nd LL have 1 more node
        //n = even, both have same
        
        return slow;
    }
    
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        
        ListNode dummy = new ListNode(-1);//dummy node
        ListNode curr = dummy;
        
        ListNode c1 = l1;
        ListNode c2 = l2;
        
        while(c1 != null && c2 != null){
            if(c1.val <= c2.val){//LL1 has smaller node
                curr.next = c1;//link
                c1 = c1.next;//move
            }else{
                curr.next = c2;//link
                c2 = c2.next;//move
            }
            
            curr = curr.next;//move
        }
        
        if(c1 != null){
            curr.next = c1;
        }else if(c2 != null){
            curr.next = c2;
        }
        
        ListNode head = dummy.next;
        return head;
    }

    public static ListNode mergeSort(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode mid = middle(head);//mid node of LL
        //divide & conquer method
        //divide LL in 2 parts
        //sort parts separately and then merger them -> merge sort( O(NlogN) )
        
        ListNode nhead = mid.next;//node next to mid
        mid.next = null;//break link between 2 parts -> LL divided
        
        ListNode left = mergeSort(head);
        ListNode right = mergeSort(nhead);
        
        ListNode res = mergeTwoLists(left, right);
        
        return res;
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

        ListNode head = mergeSort(h1);
        printList(head);
    }
}
