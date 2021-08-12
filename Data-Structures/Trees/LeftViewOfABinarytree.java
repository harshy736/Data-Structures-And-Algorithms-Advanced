/*
1. Given a Binary Tree, print left view of it. 
2. Left view of a Binary Tree is set of nodes visible when tree is viewed from left side.
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
    
   

    public static ArrayList<Integer> leftView(TreeNode root) {
        ArrayList<Integer> left = new ArrayList<>();
        
        Queue<TreeNode> q = new ArrayDeque<>();
        
        if (root != null)
            q.add(root);//first level
         
         
        //we use level order traversal & first node of a level is in the left view   
        while (q.size() > 0) {
            int n = q.size();//no of nodes in a level
            
            //add nodes of next level
            for (int i = 0; i < n; i++) {//remove this leve;
                TreeNode t = q.remove();
                if (i == 0)//first element
                    left.add(t.val);
                
                //add child nodes if they exist
                if (t.left != null)
                    q.add(t.left);
                if (t.right != null)
                    q.add(t.right);
            }
        }
        
        return left;
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

        ArrayList<Integer> ans = leftView(root);
        for(Integer i : ans) System.out.println(i); 
    }

    public static void main(String[] args) {
        solve();
    }
}
