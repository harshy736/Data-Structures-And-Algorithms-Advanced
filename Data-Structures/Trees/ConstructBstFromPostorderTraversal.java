/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given PostOrder Traversal.
3. you will be given an array representing a valid PostOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
*/

import java.util.Scanner;

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
    
    
    public static void bstFromPostorder_(TreeNode root, int data){
        if(root == null) return;
        
         if(data < root.val){//left subtree
            if(root.left == null){//left child not exist
                root.left = new TreeNode(data);
            }else{//pass to left subtree
                bstFromPostorder_(root.left, data);
            }
        }else{//right subtree
            if(root.right == null){//right child not exist
                root.right = new TreeNode(data);
            }else{//pass to right subtree
                bstFromPostorder_(root.right, data);
            }
        }
    }

    public static TreeNode bstFromPostorder(int[] postorder) {
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        //last elemnet in postord s root of the tree
        
        for(int i = postorder.length - 2; i >= 0; i--){
            bstFromPostorder_(root, postorder[i]);
        }
        
        return root;
    }

    // input_section=================================================

    public static void display(TreeNode node) {
        if (node == null)
            return;

        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());

        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
