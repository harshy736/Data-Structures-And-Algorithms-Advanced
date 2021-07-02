/*
1. Given a singly linklist, Reverse a linkedlist from position starting position to end position.
2. Do it in one-pass. without using any extra space.
3. Indexing start from numeric 1.
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
    
    static ListNode th = null;
    static ListNode tt = null;//temporary LL pointers
    public static void addFirstNode(ListNode node){
        if(th == null){//empty LL
            th = node;
            tt = node;
        }else{
            node.next = th;//attach node on left/start
            th = node;//move head on left by 1 node
        }
    }


    public static ListNode reverseInRange(ListNode head, int n, int m) {
        if(head == null || head.next == null || n > m){
            return head;
        }
        
        ListNode curr = head;
        ListNode forw = null;
        
        
        for(int i = 1; i < n - 1; i++){//n - 2 jumps
            curr = curr.next;
        }
        ListNode prevTail = curr;//n - 1 th node
        
        if(n > 1){
            curr = curr.next;//nth node
        }
        
        for(int i = n; i <= m; i++){
            forw = curr.next;
            curr.next = null;
            addFirstNode(curr);
            
            curr = forw;//move
        }
        
        //add post rem LL
        
        tt.next = curr;
        
        //link with pre LL
        if(n == 1){//no pre LL exists
            head = th;
        }else{
            prevTail.next = th;
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
        int sz = scn.nextInt();
        ListNode h1 = createList(sz);

        int m = scn.nextInt();
        int n = scn.nextInt();

        h1 = reverseInRange(h1, m, n);
        printList(h1);
    }
}
