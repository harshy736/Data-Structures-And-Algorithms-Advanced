import java.io.*;
import java.util.*;

public class Main {
    
    static int counter = 1;
    
    public static void print(ArrayList<ArrayList<Integer>> ans){
        System.out.print(counter + ". ");
        counter++;
        
        for(int i  = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}
		
		System.out.println("");
    }
    

	public static void solution(int i, int n, int k, int rssf, ArrayList<ArrayList<Integer>> ans) {
		//work done
		if(i == n + 1){
		    if(rssf == k){
    		    print(ans);
		    }
		    return;
		}
		
		for(int j = 0 ; j < ans.size(); j++) {
        	if(ans.get(j).size() == 0) {//form new group
        	    ans.get(j).add(i);
        	    solution(i + 1,n,k,rssf + 1,ans);
        	    ans.get(j).remove(ans.get(j).size() - 1);
        	    break;
        	}
        	else//with already formed group
        	{
        	    ans.get(j).add(i);
        	    solution(i + 1, n, k, rssf, ans);
        	    ans.get(j).remove(ans.get(j).size() - 1);
        	}
        } 
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		for(int i  = 0; i < k; i++) {
			ans.add(new ArrayList<>());
		}
		solution(1, n, k, 0, ans);

	}

}
