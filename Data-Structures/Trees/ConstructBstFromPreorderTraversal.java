/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given PreOrder Traversal.
3. you will be given an array representing a valid PreOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
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
    
    
    public static void bstFromPreorder_(TreeNode root, int data){
        if(root == null) return;
        
        if(data <= root.val){//left subtree
            if(root.left == null){//left child not exist
                root.left = new TreeNode(data);
            }else{//pass to left subtree
                bstFromPreorder_(root.left, data);
            }
        }else{//right subtree
            if(root.right == null){//right child not exist
                root.right = new TreeNode(data);
            }else{//pass to right subtree
                bstFromPreorder_(root.right, data);
            }
        }
    }

    public static TreeNode bstFromPreorder(int[] preOrder) {
        TreeNode root = new TreeNode(preOrder[0]);
        
        for(int i = 1; i < preOrder.length; i++){
            bstFromPreorder_(root, preOrder[i]);
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

        TreeNode root = bstFromPreorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
