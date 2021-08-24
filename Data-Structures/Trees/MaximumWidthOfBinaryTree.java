/*
1. Given the root of a binary tree, return the maximum width of the given tree.
2. The maximum width of a tree is the maximum width among all levels.
3. The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes between the end-nodes are also counted into the length calculation.
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
  
  public static class vPair{
      TreeNode node;
      int hl;//horizontal level;
      
      vPair(TreeNode node, int hl){
          this.node = node;
          this.hl = hl;
      }
  }

  public static int widthOfBinaryTree(TreeNode root) {
    //By level order traversal
    if(root == null) return 1;
    
    Queue<vPair> que = new ArrayDeque<>();
    que.add(new vPair(root, 0));
    
    int maxWidth = 0;
    
    while(que.size() > 0){
        int minHL = 0, maxHL = 0;
        
        int size = que.size();
        for(int i = 0; i < size; i++){
            vPair rp = que.remove();
            
            if(i == size - 1){//rightmost node in this level
                maxHL = rp.hl;
            }
            
            if(i == 0){//leftmost node in this level
                minHL = rp.hl;
            }
            
            //adding children nodes
            if(rp.node.left != null)
                que.add(new vPair(rp.node.left, 2 * rp.hl));
            if(rp.node.right != null)
                que.add(new vPair(rp.node.right, 2 * rp.hl + 1));
        }
        
        //width of this level
        int width = maxHL - minHL + 1;
        
        maxWidth = Math.max(maxWidth, width);
    }
    
    return maxWidth;
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

    int ans = widthOfBinaryTree(root);
    System.out.println(ans);
  }

  public static void main(String[] args) {
    solve();
  }
}
