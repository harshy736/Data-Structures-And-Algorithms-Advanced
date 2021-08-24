/*
1. You are given a partially written function to solve.
2. You are required to complete the body of maxPathSum function. The function is expected to return Integer value depending upon maximum leaf-to-leaf paths sum.
3. Input and Output is managed for you.
*/


//same as diameter of BT
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
  
  public static int maxSum = 0;
  
  public static int maxPathSum_(TreeNode root){
    if(root == null) return 0;
    
    int lsum = maxPathSum_(root.left);//max sum in left subtree from leaf node
    int rsum = maxPathSum_(root.right);//max sum in right subtree from leaf node
    
    //including root -> max sum b/w 2 leaf nodes
    int csum = lsum + rsum + root.val;
    
    maxSum = Math.max(csum , maxSum);
    
    return Math.max(lsum, rsum) + root.val;
  }

  public static int maxPathSum(TreeNode root) {
    int s = maxPathSum_(root);
    
    return maxSum;
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
    System.out.println(maxPathSum(root));
  }

  public static void main(String[] args) {
    solve();
  }
}
