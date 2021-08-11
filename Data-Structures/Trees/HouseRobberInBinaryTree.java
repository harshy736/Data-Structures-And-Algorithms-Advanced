/*
1. You are given a partially written function to solve.
2. The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". 
It will automatically contact the police if two directly-linked houses were broken into on the same night.
Determine the maximum amount of money the thief can rob tonight without alerting the police.
3. Input and Output is managed for you.
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
    
    
    public static class housePair{
        int withRobbery;//max amt if house was robbed 
        int withoutRobbery;//max amt if house wasn't robbed
        
        housePair(){
            withRobbery = 0;
            withoutRobbery = 0;
        }
    }
    
    //child returns both the max amt if it is robbed or not
    public static housePair HouseRobber_(TreeNode house){
        if(house == null) return new housePair();
        
        housePair lchild = HouseRobber_(house.left);
        housePair rchild = HouseRobber_(house.right);
        
        housePair myAns = new housePair();
        
        //if this house is roobed -> lchild & rchild was not robbed
        myAns.withRobbery = lchild.withoutRobbery + rchild.withoutRobbery + house.val;
        
        //if this house is not robbed -> get maximum amt from lchild & rchild
        myAns.withoutRobbery = Math.max(lchild.withRobbery, lchild.withoutRobbery) + Math.max(rchild.withRobbery, rchild.withoutRobbery);
        
        return myAns;
    }

    public static int HouseRobber(TreeNode root) {
        housePair res = HouseRobber_(root);
        
        return Math.max(res.withRobbery, res.withoutRobbery);
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
