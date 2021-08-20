/*
1. Given a Binary Tree, print Vertical Order Sum of it. 
2. For more Information watch given video link below.
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
    
    public static class vPair{
        TreeNode node;
        int hl;
        
        vPair(TreeNode node, int hl){
            this.node = node;
            this.hl = hl;
        }
    }
    
    
    public static void width(TreeNode root, int hl, int[] maxMin){
        if(root == null) return;
        
        maxMin[0] = Math.min(hl, maxMin[0]);
        maxMin[1] = Math.max(hl, maxMin[1]);
        
        width(root.left, hl - 1, maxMin);
        width(root.right, hl + 1, maxMin);
    }

    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        ArrayList<Integer> vsum = new ArrayList<>();
        if(root == null) return vsum;
        
        int[] maxMin = new int[2];
        width(root, 0, maxMin);
        
        int w = maxMin[1] - maxMin[0] + 1;//width of tree
        
        //intializing sum for all w HL with zero
        for(int i = 0; i < w; i++){
            vsum.add(0);
        }
        
        Queue<vPair> que = new ArrayDeque<>();
        
        //adding root
        que.add(new vPair(root, Math.abs(maxMin[0])));
        
        while(que.size() > 0){
            int size = que.size();//nodes in a single level
            
            while(size-- > 0){
                vPair rp = que.remove();
                
                int prevSum = vsum.get(rp.hl);
                int newSum = prevSum + rp.node.val;//adding this node value
                vsum.set(rp.hl, newSum);//updating in arraylist
                
                if(rp.node.left != null){
                    que.add(new vPair(rp.node.left, rp.hl - 1));
                }
                if(rp.node.right != null){
                    que.add(new vPair(rp.node.right, rp.hl + 1));
                }
            }
        }
        
        return vsum;
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

        ArrayList<Integer> ans = verticalOrderSum(root);
        for (Integer j : ans)
            System.out.println(j);

    }

    public static void main(String[] args) {
        solve();
    }
}
