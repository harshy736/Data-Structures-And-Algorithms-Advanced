/*
1. You are given a partially written function to solve.
2. You are required to complete the body of diameterOfBinaryTree function. The function is expected to return diameter of binary tree.
3. Input and Output is managed for you.
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
  
  
  static int maxDia = 0;
  
  //returns max height
  public static int diameter(TreeNode root){
    if(root == null) return -1;
    
    int lh = diameter(root.left);//max left height
    int rh = diameter(root.right);//max right height
    
    //if root is part of diameter
    int dia = lh + rh + 2;
    
    maxDia = Math.max(maxDia, dia);
    
    return Math.max(lh, rh) + 1;//1 for this node
  }
  public static int diameterOfBinaryTree(TreeNode root) {
    int h = diameter(root);
    
    return maxDia;
  }

  // input_Section=================================================

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
    System.out.println(diameterOfBinaryTree(root));
  }

  public static void main(String[] args) {
    solve();
  }
}
