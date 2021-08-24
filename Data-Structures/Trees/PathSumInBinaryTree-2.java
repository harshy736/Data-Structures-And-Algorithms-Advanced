/*
1. You are given a partially written function to solve.
2. You are required to complete the body of PathSum function. The function is expected to return all root-to-leaf paths where each path's sum equals targetSum.
3. Input and Output is managed for you.
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
  
  public static void pathSum_(TreeNode root, int targetSum, ArrayList<ArrayList<Integer>> list, ArrayList<Integer> al){
      if(root == null || targetSum < 0){
          return;
      }
      
      //leaf node
      if(root.left == null && root.right == null){//add al in path
          if(root.val == targetSum){
            al.add(root.val);
            list.add(new ArrayList<>(al));
            al.remove(al.size() - 1);
          }
          return;
      }
      
      al.add(root.val);
      pathSum_(root.left, targetSum - root.val, list, al);
      pathSum_(root.right, targetSum - root.val, list, al);
      al.remove(al.size() - 1);
  }

  public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int targetSum) {
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    
    pathSum_(root, targetSum, list, new ArrayList<>());
    
    return list;
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
    int tar = scn.nextInt();
    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);
    ArrayList<ArrayList<Integer>> ans = pathSum(root, tar);
    if (ans.size() == 0) System.out.println(" ");
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar) {
        System.out.print(ele + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
