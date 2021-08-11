/*
1. You are given a partially written function to solve.
2. Determine if it is a valid binary search tree (BST).

3. A valid BST is defined as follows:
   3.1 The left subtree of a node contains only nodes with keys less than the node's key.
   3.2 The right subtree of a node contains only nodes with keys greater than the node's key.
   3.3 Both the left and right subtrees must also be binary search trees.
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
    
    
    static TreeNode prev = null;
    
    //Using Inorder traversal of the BST
    //bcz inorder traversal of a BST is always sorted
    

    public static boolean isValidBST(TreeNode root) {
        if(root == null)return true;
        
        //lc -> not BST
        if(!isValidBST(root.left)) return false;
        
        if(prev != null && prev.val >= root.val){//not sorted
            return false;
        }
        prev = root;
        
        //rc -> not BST
        if(!isValidBST(root.right)) return false;
        
        return true;
    }

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        System.out.println(isValidBST(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
