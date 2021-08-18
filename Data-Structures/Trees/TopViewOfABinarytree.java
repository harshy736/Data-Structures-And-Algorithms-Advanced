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
        int hl;//horizontal level/line
        
        vPair(TreeNode node, int hl){
            this.node = node;
            this.hl = hl;
        }
    }
    
    
    public static void width(TreeNode root, int[] ans, int hl){
        if(root == null) return;
        
        ans[0] = Math.min(ans[0], hl);
        ans[1] = Math.max(ans[1], hl);
        
        width(root.left, ans, hl - 1);//left -> hl dec by 1
        width(root.right, ans, hl + 1);//right - hl + 1
    }


    public static ArrayList<Integer> TopView(TreeNode root) {
        
        ArrayList<Integer> top = new ArrayList<>();
        if(root == null){
            return top;
        }
        
        int[] maxMin = new int[2];
        //0th box -> stores min hl
        //1st box -> stores max hl
        
        //fill minMan array
        width(root, maxMin, 0);
        
        int w = maxMin[1] - maxMin[0] + 1;//width of tree
        
        //empty arrays for bottom element on w horizontal levels
        for(int i = 0; i < w; i++){
            top.add(null);
        }
        
        int level = 0;//levels which get their top node
        
        
        //By using level order traversal -> we get correct order
        Queue<vPair> q = new ArrayDeque<>();
        
        //taking leftmost node level -> 0
        //root level increase by minHL from 0
        q.add(new vPair(root, Math.abs(maxMin[0])));
        
        while(q.size() > 0){
            int size = q.size();//no of nodes in a particular level
            
            while(size-- > 0){
                vPair rp = q.remove();
                TreeNode node = rp.node;
                
                if(top.get(rp.hl) == null){//top not found 
                    top.set(rp.hl, node.val);
                    level++;
                }
                
                if(node.left != null){
                    q.add(new vPair(node.left, rp.hl - 1));
                }
                
                if(node.right != null){
                    q.add(new vPair(node.right, rp.hl + 1));
                }
            }
            
            if(level == w){//all top values found
                break;
            }
        }
        
        
        return top;

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

        ArrayList<Integer> ans = TopView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
