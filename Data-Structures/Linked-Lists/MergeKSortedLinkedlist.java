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
    
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
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
    

    public static ListNode mergeKLists(ListNode[] lists, int si, int ei) {
        if(si > ei) return null;//no node left
        
        //base case -> single node left -> sorted already
        if(si == ei) 
            return lists[si];
        
        int mid = (si + ei)/2;//middle pos
        
        ListNode left = mergeKLists(lists ,si, mid);//left array of nodes -> gives res LL whixh is sorted
        ListNode right = mergeKLists(lists , mid + 1, ei);//right array of nodes
        
        ListNode res = mergeTwoLists(left, right);//merge left LL & right LL which are sorted separately
        
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
        ListNode[] list = new ListNode[n];
        for (int i = 0; i < n; i++) {
            int m = scn.nextInt();
            list[i] = createList(m);
        }

        ListNode head = mergeKLists(list ,0, n - 1);
        printList(head);
    }
}
