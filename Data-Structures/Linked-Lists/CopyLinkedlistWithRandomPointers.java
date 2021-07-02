import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    
    //have to give a new LL which is a exact copy of given LL
    public static ListNode copyRandomList(ListNode head) {
        HashMap<ListNode, ListNode> map = new HashMap<ListNode, ListNode>();
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        
        ListNode curr = head;
        while(curr != null){
            prev.next = new ListNode(curr.val);
            prev = prev.next;
            
            map.put(curr, prev);//assign node of same pos in hashmap
            curr = curr.next;
            
            
        }
        
        ListNode nHead = dummy.next;
        
        ListNode c1 = head;
        ListNode c2 = nHead;
        
        while(c2 != null){
            c2.random = (map.get(c1.random) != null) ? map.get(c1.random) : null;
            
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return nHead;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}
