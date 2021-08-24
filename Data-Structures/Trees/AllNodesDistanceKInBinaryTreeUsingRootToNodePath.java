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
  
  public static ArrayList<TreeNode> rootToNodePath(TreeNode node, int target){
      ArrayList<TreeNode> p = new ArrayList<>();
      
      if(node == null) return p;
      
      if(node.val == target){
          p.add(node);
          return p;
      }
      
      ArrayList<TreeNode> l1 = rootToNodePath(node.left, target);
      if(l1.size() > 0){
          l1.add(0, node);
          return l1;
      }
      
      ArrayList<TreeNode> l2 = rootToNodePath(node.right, target);
      if(l2.size() > 0){
          l2.add(0, node);
          return l2;
      }
      
      return p;
  }
  
  public static void findNode(TreeNode node, int dist, ArrayList<Integer> ans){
      if(node == null) return;
      
      if(dist == 0){
          ans.add(node.val);
          return;
      }
      
      findNode(node.left, dist - 1, ans);
      findNode(node.right, dist - 1, ans);
  }

  public static ArrayList<Integer> distanceK(TreeNode root, int target, int k) {
    ArrayList<Integer> ans = new ArrayList<>();
    
    //root to node path
    ArrayList<TreeNode> path = rootToNodePath(root, target);
    if(k == 0){
        ans.add(path.get(path.size() - 1).val);
        return ans;
    }
    
    
    //removing nodes from path which can not contribute to ans
    while(path.size() > k + 1){//dist already more than k
        path.remove(0);
    }
    
    
    for(int i = path.size() - 2; i >= 0; i--){
        TreeNode node = path.get(i); 
        int reqDist = k - path.size() + i + 1;
        
        if(reqDist == 0){
            ans.add(node.val);
        }else if(node.left != path.get(i + 1)){
            findNode(node.left, reqDist - 1, ans);
        }else{
            findNode(node.right, reqDist - 1, ans);
        }
        
    }
    
    //down tp target node
    TreeNode node = path.get(path.size() - 1); 
    findNode(node, k, ans);
    
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
    int target = scn.nextInt();
    int k = scn.nextInt();

    ArrayList<Integer> ans = distanceK(root, target, k);
    if (ans.size() == 0)
      System.out.println();
    for (Integer ele : ans)
      System.out.println(ele + " ");

  }

  public static void main(String[] args) {
    solve();
  }
}
