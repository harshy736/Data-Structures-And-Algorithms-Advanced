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
  
  static int maxTime = 0;
  
  public static void burnTree(TreeNode node, int time) {
        if(node == null) return;
        
        maxTime = Math.max(maxTime, time);//update
        
        burnTree(node.left, time + 1);//burn left subtree
        burnTree(node.right, time + 1);//burn right subtree
  }

  public static int burningTree_(TreeNode root, int fireNode) {
    if(root == null) return -1;
    
    //fireNOde found
    if(root.val == fireNode){
        burnTree(root, 0);//burn nodes down to fireNode -> its children subtree
        return 1;//time taken to burn its parent
    }
    
    //time taken to burn this Node via subtree
    //-1 left subtree doesn't contain fireNode
    int timeLeft = burningTree_(root.left, fireNode);
    if(timeLeft != -1){//left subtree contain fireNOde
        burnTree(root.right, timeLeft + 1);//burn rigth subtree
        return timeLeft + 1;//time taken to burn its parent
    }
    
    int timeRight = burningTree_(root.right, fireNode);
    if(timeRight != -1){//right subtree contain fireNode
        burnTree(root.left, timeRight + 1);//burn left subtree
        return timeRight + 1;//time taken to burn its parent
    }
    
    return -1;//root doesnt contain fireNode 
  }
  
  public static int burningTree(TreeNode root, int fireNode){
      int t = burningTree_(root, fireNode);
      
      return maxTime;
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
    int fireNode = scn.nextInt();

    int ans = burningTree(root, fireNode);
    System.out.println(ans);

  }

  public static void main(String[] args) {
    solve();
  }
}
