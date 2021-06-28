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
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        head.next = prev;
        return head;
    }

    public static void fold(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode mid = midNode(head); //first middle of LL
        ListNode nhead = mid.next;//backup next node to mid
        mid.next = null;//limiting first LL to only half size -> divide LL
        
        //if n = odd, first LL has 1 node extra in comp to 2nd LL
        //n = even -> both LL has same number of nodes

        nhead = reverse(nhead);//reverse 2nd part of LL

        ListNode c1 = head, c2 = nhead;
        
        ListNode f1 = null, f2 = null;


        while (c2 != null) {//c2 has always less or equal length than c1
            //Backup
            f1 = c1.next;
            f2 = c2.next;
            
            //Links
            c1.next = c2;
            c2.next = f1;
            
            //Move to next nodes -> changing pointer 
            c1 = f1;
            c2 = f2;
        }
       
    }

    static void printList(ListNode node) {
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
        fold(head);
        printList(head);
    }
}
