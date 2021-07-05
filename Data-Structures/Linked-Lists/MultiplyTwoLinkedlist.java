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
    
    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode forw = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
            
        ListNode head = new ListNode(-1), temp = head, c1 = l1, c2 = l2;
        
        int carry = 0;
        while (c1 != null || c2 != null || carry != 0) {
            //operation
            int sum = (c1 != null ? c1.val : 0) + (c2 != null?c2.val : 0) + carry;
            carry = sum / 10;
            sum = sum % 10;
            
            temp.next = new ListNode(sum);//assign value
            
            //move
            temp = temp.next;
            c1 = (c1 != null) ? c1.next : null;//move only iff next node available
            c2 = (c2 != null) ? c2.next : null;
        }
        
        //removing dummy node
        return head.next;
    }
    
    public static ListNode multiplyLLWithDigit(ListNode head, int mul){
        if(head == null) return head;
        
        ListNode dummy = new ListNode(-1);
        ListNode ac = dummy;//ans pointer
        ListNode curr = head;
        
        int carry = 0;
        while(curr != null){
            int sum = carry + mul * curr.val;
            carry = sum/10;
            int digit = sum % 10;//single digit in node
            
            ac.next = new ListNode(digit);
            
            //move
            curr = curr.next;
            ac = ac.next;
        }
        
        //if carry > 0
        if(carry > 0){
            ac.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
    

    public static ListNode multiplyTwoLL(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        ListNode c2 = l2;
        
        while(c2 != null){
            ListNode prod = multiplyLLWithDigit(l1, c2.val);//multiply eith digit in l2 one by one
           
            prev.next = addTwoNumbers(prod, prev.next);
           
            //move prev -> as X in real multiplication
            prev = prev.next;
            c2 = c2.next;
        }
        
        return reverse(dummy.next);
    }

    // Input_code===================================================

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

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
        ListNode head2 = makeList(scn.nextInt());

        ListNode ans = multiplyTwoLL(head1, head2);
        printList(ans);
    }

}
