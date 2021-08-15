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
    
    
    public static void width_(TreeNode root, int hl, int[] ans){
        if(root == null) return;
        
        ans[0] = Math.min(hl, ans[0]);
        ans[1] = Math.max(hl, ans[1]);
        
        width_(root.left, hl - 1, ans);//left child
        width_(root.right, hl + 1, ans);//right child
    }

    public static int width(TreeNode root) {
        int[] ans = new int[2];
        //0th -> minHL
        //1th -> maxHL
        //HL - horizontal level
        
        //treating root as 0 horizontal level
        //minHL -> leftmost node's HL
        //maxHL -> rightmost node's HL
        
        //width = maxHL - minHL + 1
        
        width_(root, 0, ans);
       
        return ans[1] - ans[0] + 1;//width
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

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
