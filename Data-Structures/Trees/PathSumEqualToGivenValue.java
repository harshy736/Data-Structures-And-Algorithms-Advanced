/*
1. Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
2. The path does not need to start or end at the root or a leaf,path can start from any where but it must go downwards
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
  
  static int count;
  
  public static void pathSum_(TreeNode root, int k) {
    if(root == null) return;
   
    //if root is in path -> path has started
    helper(root.left, k - root.val);
    helper(root.right, k - root.val);
    
    //if root is not in path -> path not started yet
    pathSum_(root.left, k);
    pathSum_(root.right, k);
  }
  
  //path started all nodes participated until path or null found
  public static void helper(TreeNode root, int k){
    if(root == null) return;
    
    //pathsum find
    if(root.val == k){
        count++;
    }
    
    //if root is in path
    helper(root.left, k - root.val);
    helper(root.right, k - root.val);
  }

  public static int pathSum(TreeNode root, int K) {
    count = 0;
    pathSum_(root, K);
    
    return count;
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

  public static int idx = 0;

  private static TreeNode deserialize(String[] arr) {
    if (idx >= arr.length || arr[idx].equals("null")) {
      idx++;
      return null;
    }

    TreeNode node = new TreeNode(Integer.parseInt(arr[idx++]));
    node.left = deserialize(arr);
    node.right = deserialize(arr);

    return node;
  }

  public static TreeNode deserialize(String str) {
    String[] arr = str.split(" ");
    return deserialize(arr);
  }

  public static void solve() {
    String str = scn.nextLine();
    TreeNode root = deserialize(str);
    int tar = scn.nextInt();

    int ans = pathSum(root, tar);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}
