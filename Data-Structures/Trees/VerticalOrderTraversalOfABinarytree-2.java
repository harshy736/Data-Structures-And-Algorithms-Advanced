/*
1. Given a Binary Tree, print Vertical Order of it. 
2. For each node at position (row, col), its left and right 
   children will be at positions (row + 1, col - 1) and (row + 1, col + 1) 
   respectively. The root of the tree is at (0, 0).
3. The vertical order traversal of a binary tree is a list of top-to-bottom 
   orderings for each column index starting from the leftmost column and ending 
   on the rightmost column. There may be multiple nodes in the same row and same 
   column. In such a case, sort these nodes by their values.
4. For More Information Watch Question Video link below.
*/

import java.util.*;

public class Main {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class vPair implements Comparable<vPair>{
        TreeNode node;
        int hl;//horizontal level/line
        
        vPair(TreeNode node, int hl){
            this.node = node;
            this.hl = hl;
        }
        
        public int compareTo(vPair o){
            if(this.hl == o.hl){//HL diff
                return this.node.val - o.node.val;
            }
            
            return this.hl - o.hl;//HL same -> less value nod comes first
        }
    }
    
    
    public static void width(TreeNode root, int[] ans, int hl){
        if(root == null) return;
        
        ans[0] = Math.min(ans[0], hl);
        ans[1] = Math.max(ans[1], hl);
        
        width(root.left, ans, hl - 1);//left -> hl dec by 1
        width(root.right, ans, hl + 1);//right - hl + 1
    }


    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
        int[] maxMin = new int[2];
        //0th box -> stores min hl
        //1st box -> stores max hl
        
        //fill minMan array
        width(root, maxMin, 0);
        
        int w = maxMin[1] - maxMin[0] + 1;//width of tree
        
        ArrayList<ArrayList<Integer>> order = new ArrayList<ArrayList<Integer>>();
        
        //empty arrays for w horizontal levels
        for(int i = 0; i < w; i++){
            order.add(new ArrayList<>());
        }
        
        //By using level order traversal -> we get correct order
        Queue<vPair> q = new ArrayDeque<>();
        
        //taking leftmoet node level -> 0
        //root level increase by minHL from 0
        q.add(new vPair(root, Math.abs(maxMin[0])));
        
        while(q.size() > 0){
            int size = q.size();//no of nodes in a particular level
            PriorityQueue<vPair> pq = new PriorityQueue<>();
            //stores nodes of a level
            
            while(size-- > 0){
                vPair rp = q.remove();
                pq.add(rp);//add to pq
                
                TreeNode node = rp.node; 
                
                if(node.left != null){
                    q.add(new vPair(node.left, rp.hl - 1));
                }
                
                if(node.right != null){
                    q.add(new vPair(node.right, rp.hl + 1));
                }
            }
            
            //fill nodes in the correct horizontal order
            while(pq.size() > 0){
                vPair rp = pq.remove();
                
                order.get(rp.hl).add(rp.node.val);
            }
        }
        
        return order;

    }

    // input_section=================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
