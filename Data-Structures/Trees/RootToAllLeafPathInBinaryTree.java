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
  
  static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
  
  public static void rootToAllLeafPath(TreeNode node, ArrayList<Integer> path){
      if(node == null) return;
      
      path.add(node.val);//adding curr node
      
      if(node.left == null && node.right == null){//leaf node
          list.add(new ArrayList<>(path));
          //adding new arraylist same as path to list bcz if we add path -> its addrres saved not curr values
          
          for(int i = path.size() - 1; i >= 0; i--){
              if(path.get(i) == node.val){//backtrack
                  path.remove(i);
                  break;
              }
          }
          return;
      }
      
      rootToAllLeafPath(node.left, path);
      rootToAllLeafPath(node.right, path);
      
      for(int i = path.size() - 1; i >= 0; i--){
          if(path.get(i) == node.val){//backtrack
              path.remove(i);
              break;
          }
      }
      
  }

  public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
    // write your code.
    rootToAllLeafPath(root, new ArrayList<>());
    
    return list;
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

    ArrayList<ArrayList<Integer>> ans = rootToAllLeafPath(root);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> al : ans) {
      for (Integer ele : al)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
