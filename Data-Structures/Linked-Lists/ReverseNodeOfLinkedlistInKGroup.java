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
    
    public static int length(ListNode node){
        int len = 0;
        ListNode curr = node;
        
        while(curr != null){
            curr = curr.next;
            len++;
        }
        
        return len;
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

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        
        ListNode curr = head;
        ListNode forw = null;
        ListNode oh = null;//original head of res LL
        ListNode ot = null;//original tail of res LL
        
        int len = length(head);//length of LL
        
        while(len >= k){//if remainning LL size > k : group can form
            int tempK = k;
            
            //remove nodes & add in reverse order to get reversed order
            while(tempK-- > 0){//k nodes removed
                forw = curr.next;//Backup for remainning LL
                curr.next = null;//isloate node
                addFirstNode(curr);//add first in tempoary LL
                
                curr = forw;//move
                //tempK--;
            }
            
            //add reversed group of size K in res LL
            if(oh == null){//empty LL
                oh = th;
                ot = tt;
            }else{//LL exists
                ot.next = th;//merge
                ot = tt;
            }
            
            //reset temp LL
            th = null;
            tt = null;
            
            len -= k;//k nodes removed from LL -> size dec by k
        }
        
        //add remainning LL into res LL -> which is less in size K -> not reversed
        ot.next = curr;
        
        return oh;
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

        int k = scn.nextInt();
        h1 = reverseInKGroup(h1, k);
        printList(h1);
    }
}
