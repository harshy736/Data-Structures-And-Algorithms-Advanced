/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Tree from PostOrder and InOrder Traversal.
3. you will be given two arrays representing a valid PostOrder & InOrder of a Binary Tree. Program is required to create a unique Binary Tree.
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
    
    
    public static TreeNode buildTree_(int postEnd, int inStart, int inEnd, int[] inorder, int[] postorder) {
        //base case
        if(postEnd < 0 || inStart > inEnd){
            return null;
        }
        
        //end of postorder will be the root of the binary tree
        TreeNode root = new TreeNode(postorder[postEnd]); 
        
        int index = inStart;
        for( ; index <= inEnd; ){
            if(inorder[index] == root.val){//root found
                break;
            }
            index++;
        }
        
        //left to index -> left subtree
        //right to index -> right subtree
        
        root.left = buildTree_(postEnd - 1 - inEnd + index, inStart, index - 1, inorder, postorder);
        
        root.right = buildTree_(postEnd - 1, index + 1, inEnd, inorder, postorder);
        
        return root;
    }
    

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = buildTree_(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
        
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
        int[] post = new int[n];
        for (int i = 0; i < n; i++)
            post[i] = scn.nextInt();

        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = buildTree(in, post);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
