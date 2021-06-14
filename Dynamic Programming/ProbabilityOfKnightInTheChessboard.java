import java.io.*;
import java.util.*;

public class Main {
    public static boolean isValid(int r, int c, int n){
        if(r >= 0 && c >= 0 && r < n && c < n){
            return true;
        }
        
        return false;
    }

	public static void solution(int r, int c, int n, int k) {
		//use dp
		//every box stores the probability of knight on that box after m moves
		
		double[][] curr = new double[n][n];
		double[][] next = new double[n][n];
		
		//use 2 dp arrays to find probability after m moves
		
		curr[r][c] = 1;
		//initial prob
		
		for(int m = 0; m < k; m++){
		    for(int i = 0; i < n; i++){
		        for(int j = 0; j < n; j++){
		            if(curr[i][j] != 0){//knight is prsent on i, j -> make next move
		                int ni = 0, nj = 0;
		                
		                //8 moves -> every move have equal prob
		                
		                ni = i - 2;
		                nj = j + 1;
		                if(isValid(ni, nj, n)){
		                    next[ni][nj] += curr[i][j]/8.0;
		                }
		                
		                ni = i - 1;
		                nj = j + 2;
		                if(isValid(ni, nj, n)){
		                    next[ni][nj] += curr[i][j]/8.0;
		                }
		                
		                ni = i + 1;
		                nj = j + 2;
		                if(isValid(ni, nj, n)){
		                    next[ni][nj] += curr[i][j]/8.0;
		                }
		                
		                ni = i + 2;
		                nj = j + 1;
		                if(isValid(ni, nj, n)){
		                    next[ni][nj] += curr[i][j]/8.0;
		                }
		                
		                ni = i + 2;
		                nj = j - 1;
		                if(isValid(ni, nj, n)){
		                    next[ni][nj] += curr[i][j]/8.0;
		                }
		                
		                ni = i + 1;
		                nj = j - 2;
		                if(isValid(ni, nj, n)){
		                    next[ni][nj] += curr[i][j]/8.0;
		                }
		                
		                ni = i - 1;
		                nj = j - 2;
		                if(isValid(ni, nj, n)){
		                    next[ni][nj] += curr[i][j]/8.0;
		                }
		                
		                ni = i - 2;
		                nj = j - 1;
		                if(isValid(ni, nj, n)){
		                    next[ni][nj] += curr[i][j]/8.0;
		                }
		            }
		        }
		    }
		    
		    //update for next move
		    curr = next;
		    next = new double[n][n];
		}
		
		double prob = 0;
		for(int i = 0; i < n; i++){
		    for(int j = 0; j < n; j++){
		        prob += curr[i][j];
		    }
		}
		
		System.out.println(prob);
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int r = scn.nextInt();
		int c = scn.nextInt();
		solution(r, c, n, k); 
	}

}
