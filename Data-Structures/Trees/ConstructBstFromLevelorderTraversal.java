/*
1. You are given a partially written function to solve(Refer question video).
2. Task : Construct Binary Search Tree from given LevelOrder Traversal.
3. you will be given an array representing a valid LevelOrder of a Binary Search Tree. Program is required to create a unique Binary Search Tree.
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
    
    
    public static void bstFromLevelOrder_(TreeNode root, int data){
        if(root == null) return;
        
        if(data <= root.val){//left subtree
            if(root.left == null){//left child not exist
                root.left = new TreeNode(data);
            }else{//pass to left subtree
                bstFromLevelOrder_(root.left, data);
            }
        }else{//right subtree
            if(root.right == null){//right child not exist
                root.right = new TreeNode(data);
            }else{//pass to right subtree
                bstFromLevelOrder_(root.right, data);
            }
        }
    }
    

    public static TreeNode constructBSTFromLevelOrder(int[] LevelOrder){
        TreeNode root = new TreeNode(LevelOrder[0]);
        
        for(int i = 1;i < LevelOrder.length; i++){
            bstFromLevelOrder_(root, LevelOrder[i]);
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
        int[] level = new int[n];
        for (int i = 0; i < n; i++)
            level[i] = scn.nextInt();

        TreeNode root = constructBSTFromLevelOrder(level);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
