/*
1. Given a Binary Tree, return inorder Traversal of it. 
2. For more Information watch given video link below.
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
  
  
  public static TreeNode getRightmostNode(TreeNode leftNode, TreeNode curr){
      while(leftNode.right != null && leftNode.right != curr){
          leftNode = leftNode.right;
      }
      
      return leftNode;
  }

  public static ArrayList<Integer> morrisInTraversal(TreeNode root)   {
    ArrayList<Integer> ans = new ArrayList<>();
    
    TreeNode curr = root;
    
    while(curr != null){
       TreeNode leftNode = curr.left;
       
       if(leftNode == null){//no left child exist -> jump to right child
           ans.add(curr.val);
           curr = curr.right;//right child
       }else{
           TreeNode rightmostNode = getRightmostNode(leftNode, curr);
           
           if(rightmostNode.right == null){//create thread to attach with next node in inorder traversal
               rightmostNode.right = curr;//thread -> link to backtrack
               curr = curr.left;//iterate in left subtree
           }
           else{//cut thread -> left subtree already completely processes
                rightmostNode.right = null;//cut
                ans.add(curr.val);//add in ans
                curr = curr.right;
           }
       }
        
    }
    
    
    return ans;
  }

  // input_section=================================================

  public static TreeNode createTree(int[] arr, int[] IDX) {
    if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
      IDX[0]++;
      return null;
    }
    TreeNode Treenode = new TreeNode(arr[IDX[0]++]);
    Treenode.left = createTree(arr, IDX);
    Treenode.right = createTree(arr, IDX);

    return Treenode;
  }

  public static void solve() {
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++)
      arr[i] = scn.nextInt();

    int[] IDX = new int[1];
    TreeNode root = createTree(arr, IDX);

    ArrayList<Integer> ans = morrisInTraversal(root);
    for (Integer i : ans)
      System.out.print(i + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
