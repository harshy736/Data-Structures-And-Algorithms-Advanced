import java.io.*;
import java.util.*;

public class Main {
	
	public static void solution(int[][] arr, boolean[][] visited, int row, int col, ArrayList<Integer> bag){
	    
	    if(row < 0 || col < 0 || row == arr.length || col == arr[0].length || arr[row][col] == 0 || visited[row][col] == true){
	        return;
	    }
	    
	    visited[row][col] = true;
	    bag.add(arr[row][col]);
	    
	    solution(arr, visited, row - 1, col, bag);//up
	    solution(arr, visited, row + 1, col, bag);//down
	    solution(arr, visited, row , col - 1, bag);//left
	    solution(arr, visited, row , col + 1, bag);//right
	    
	}
	
	
	public static void getMaxGold(int[][] arr){
		//write your code here
		int maxGold = 0;
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		
		for(int r = 0; r < arr.length; r++){
		    for(int c = 0; c < arr[0].length; c++){
		        if(arr[r][c] != 0 && visited[r][c] == false){
		            ArrayList<Integer> bag = new ArrayList<>();
		            int sum = 0;
		            solution(arr, visited, r, c, bag);
		            
		            for(int gold : bag){
		                sum += gold;
		            }
		            
		            if(sum > maxGold){
		                maxGold = sum;
		            }
		        }
		    }
		        
		}
		
		System.out.println(maxGold);
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
		getMaxGold(arr);
	}
		
}
