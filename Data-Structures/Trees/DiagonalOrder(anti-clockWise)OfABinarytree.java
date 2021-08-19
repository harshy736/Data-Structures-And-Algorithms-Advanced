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

    //anti clockwise diagonal
    //diagonal start from right to left
    //start from right most node in a vertical level
    //traverse top right to bottom left
    public static ArrayList<ArrayList<Integer>> diagonalOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new ArrayDeque<>();
        
        //from a node
        //its left child belongs in its diagonal
        //& right child belongs to next diagonal
        
        que.add(root);
        
        while(que.size() > 0){
            int size = que.size();
            
            ArrayList<Integer> diagonal = new ArrayList<>();
            
            while(size-- > 0){
                TreeNode rn = que.remove();//removed node
                
                while(rn != null){
                    if(rn.right != null)
                        que.add(rn.right);//for next diagonal
                        
                    diagonal.add(rn.val);//storing this diagonal
                    rn = rn.left;//next node in the diagonal
                } 
            }
            
            ans.add(diagonal);//adding diagonal
        }
        
        return ans;
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

        ArrayList<ArrayList<Integer>> ans = diagonalOrder(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}
