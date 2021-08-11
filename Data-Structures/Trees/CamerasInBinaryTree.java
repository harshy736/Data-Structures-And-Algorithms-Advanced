/*
1. You are given a partially written function to solve.
2. You are required to complete the body of MinCamerasInBT_ function. The function is expected to return integer value representing minimum number of camera(s) required for the coverage of complete tree.
3.A camera is placed on any node will ensure coverage of parent-node as well as it's child-node(s), if any.
4. Input and Output is managed for you.

*/


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
    
    
    static int cameras = 0;
    
    
    //Return to the parent
    // -1 if node needs a camera
    // 0 node having camera -> parent is also covered
    // 1 if node is covered -> parent is not covered
    public static int MinCamerasInBT_(TreeNode node){
        if(node == null) return 1;//no need of camera
        
        int lchild = MinCamerasInBT_(node.left);
        int rchild = MinCamerasInBT_(node.right);
        
        if(lchild == -1 || rchild == -1){//one child node needs a urgent camera
            cameras++;
            return 0;//node used a camera
        }else if(lchild == 0 || rchild == 0){//node is covered by its child
            return 1;
        }else{//lchild == 1 && rchild == 1
            return -1;//node needs a camera -> pass it to the parent
        }
    }

    public static int MinCamerasInBT(TreeNode root) {
        
        int pnode = MinCamerasInBT_(root);
        if(pnode == -1){//root needs a camera 
            cameras++;
        }
        
        return cameras;
    }

    // input_Section_====================================================================

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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
        System.out.println(MinCamerasInBT(root));

    }

    public static void main(String[] args) {
        solve();
    }
}
