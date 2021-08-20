/*
Diagonal Order Sum Of A Binary Tree

1. Given a Binary Tree, print Diagonal order sum of it. 
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
  
  
  //clockwise diagonal
  public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
    ArrayList<Integer> dsum = new ArrayList<>();
    if(root == null) return dsum;
    
    Queue<TreeNode> que = new ArrayDeque<>();
    que.add(root);
    
    while(que.size() > 0){
        int size = que.size();
        int sum = 0;//sum of a diagonal
        
        //for 1 diagonal
        while(size-- > 0){
            TreeNode rn = que.remove();
            
            while(rn != null){
                sum += rn.val;//adding value
                
                //for next diagonal
                if(rn.left != null){
                    que.add(rn.left);
                }
                
                //next node in this diagonal linked to rn
                rn = rn.right;
            }
        }
        
        dsum.add(sum);//storing sum of the diagonal
    }
    
    
    return dsum;
  }

  // input_section=================================================

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

    ArrayList<Integer> ans = diagonalOrderSum(root);
    for (Integer j : ans)
      System.out.print(j + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}

