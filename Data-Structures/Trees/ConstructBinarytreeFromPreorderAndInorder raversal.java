/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PreOrder and InOrder Traversal.
3. you will be given two arrays representing a valid PreOrder & InOrder of a Binary Tree. Program is required to create a unique Binary Tree.
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
    
    
    public static TreeNode buildTree_(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart >= preorder.length || inStart > inEnd){
            return null;
        }
        
        int index = inStart;
        //first element of preorder is the root now
        TreeNode root = new TreeNode(preorder[preStart]);
        
        for(; index <= inEnd; ){
            if(inorder[index] == root.val){
                break;
            }
            index++;
        }
        //index pointed to first element
        //left to it is the left subtree
        //right to it is the right subtree
        
        root.left = buildTree_(preStart + 1, inStart, index - 1, preorder, inorder);//left subtree
        root.right = buildTree_(preStart + 1 + index - inStart, index + 1, inEnd, preorder, inorder);//right subtree
        
        return root;
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = buildTree_(0, 0, inorder.length - 1, preorder, inorder);
        
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

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(pre, in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
