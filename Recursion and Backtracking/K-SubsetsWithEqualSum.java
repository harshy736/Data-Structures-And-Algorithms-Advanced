import java.io.*;
import java.util.*;

public class Main {
    public static void print(ArrayList<ArrayList<Integer>> ans){
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("");
    }

	public static void solution(int[] arr, int vidx,int n , int k, int tar, int[] subsetSum,int sssf, ArrayList<ArrayList<Integer>> ans) {
		//base case
		if(vidx == n){
		    print(ans);
		    return;
		}
		
		//element goes with already form subsets
		for(int i = 0; i < sssf; i++){
		    if(arr[vidx] + subsetSum[i] <= tar){
		        subsetSum[i] += arr[vidx];
		        ans.get(i).add(arr[vidx]);
		        solution(arr,vidx + 1 , n, k, tar, subsetSum,sssf,ans);
		        ans.get(i).remove(ans.get(i).size() - 1);
		        subsetSum[i] -= arr[vidx];
		    }
		}
		
		//element form new subset
		if(sssf < k){
		    subsetSum[sssf] += arr[vidx];
		    ans.get(sssf).add(arr[vidx]);
		    solution(arr,vidx + 1 , n, k, tar, subsetSum, sssf + 1,ans);
		    ans.get(sssf).remove(ans.get(sssf).size() - 1);
		    subsetSum[sssf] -= arr[vidx];
		}
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		
		int sum = 0;
		for(int i =  0 ; i < arr.length; i++) {
			arr[i] = scn.nextInt();
			sum += arr[i];
		}
		
		int k = scn.nextInt();
		// if k is equal to 1, then whole array is your answer 
		if(k == 1) {
			System.out.print("[");
			for(int i = 0 ; i  < arr.length; i++) {
				System.out.print(arr[i] + ", ");
			}
			System.out.println("]");
			return;
		}
		//if there are more subsets than no. of elements in array or sum of all elements is not divisible by k
		if(k > n || sum % k != 0) {
			System.out.println("-1");
			return;
		}
		
		int[] subsetSum = new int[k];
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		
		solution(arr,0,n,k,sum/k, subsetSum,0,ans);
	}
	
	

}
