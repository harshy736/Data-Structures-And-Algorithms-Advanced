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
  
  public static void burnTree(TreeNode node, TreeNode blockNode, int time, ArrayList<ArrayList<Integer>> ans) {
        if(node == null || node == blockNode) return;
        
        //this node burn in time = time
        //put this node in ans arraylist at index time
        if(time == ans.size()){
            ans.add(new ArrayList<>());
            //add empty arraylist for that time
        }
        
        ans.get(time).add(node.val);
        
        burnTree(node.left, blockNode, time + 1, ans);//burn left subtree
        burnTree(node.right, blockNode,  time + 1, ans);//burn right subtree
  }

  public static int burningTree_(TreeNode root, int fireNode, ArrayList<ArrayList<Integer>> ans) {
    if(root == null) return -1;
    
    //fireNOde found
    if(root.val == fireNode){
        burnTree(root,null, 0, ans);//burn nodes down to fireNode -> its children subtree
        return 1;//time taken to burn its parent
    }
    
    //time taken to burn this Node via subtree
    //-1 left subtree doesn't contain fireNode
    int timeLeft = burningTree_(root.left, fireNode, ans);
    if(timeLeft != -1){//left subtree contain fireNode
        
        
        burnTree(root, root.left, timeLeft, ans);//burn right subtree
        return timeLeft + 1;//time taken to burn its parent
    }
    
    int timeRight = burningTree_(root.right, fireNode, ans);
    if(timeRight != -1){//right subtree contain fireNode
        
        burnTree(root, root.right, timeRight, ans);//burn left subtree
        return timeRight + 1;//time taken to burn its parent
    }
    
    return -1;//root doesnt contain fireNode 
  }

  public static ArrayList<ArrayList<Integer>> burningTree(TreeNode root, int data) {
      ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
      
      int t = burningTree_(root, data, ans);
      
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
    int fireNode = scn.nextInt();

    ArrayList<ArrayList<Integer>> ans = burningTree(root, fireNode);
    if (ans.size() == 0)
      System.out.println();
    for (ArrayList<Integer> ar : ans) {
      for (Integer ele : ar)
        System.out.print(ele + " ");
      System.out.println();
    }
  }

  public static void main(String[] args) {
    solve();
  }
}
