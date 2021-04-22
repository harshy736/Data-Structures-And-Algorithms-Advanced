import java.io.*;
import java.util.*;

public class Main {

	public static void solution(char[][] arr, String[] words, int vidx){
		//all words are placed
		if(vidx == words.length){
		    print(arr);
		    return;
		}
		
		String word = words[vidx];
		
		for(int i = 0; i < arr.length; i++){
		    for(int j = 0; j < arr[0].length; j++){
		        if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)){
		            
		            //horizontally
		            if(canPlaceHorizontally(arr, word, i, j)){
		                boolean[] visited = placeHorizontally(arr, word, i, j);
		                solution(arr, words, vidx + 1);
		                unplaceHorizontally(arr, word, i, j, visited);
		            }
		            
		            //vertically
		            if(canPlaceVertically(arr, word, i, j)){
		                boolean[] visited = placeVertically(arr, word, i, j);
		                solution(arr, words, vidx + 1);
		                unplaceVertically(arr, word, i, j, visited);
		            }
		        }
		    }
		}

	}
	
	
	public static boolean canPlaceHorizontally(char[][] arr, String word, int i, int j){
	    //check backward
	    if(j - 1 >= 0 && arr[i][j - 1] != '+'){
	        return false;
	    }
	    
	    //check front
	    if(j + word.length() <= arr[0].length - 1 && arr[i][j + word.length()] != '+'){
	        return false;
	    }
	    
	    for(int jj = 0; jj < word.length(); jj++){
	        if(j + jj == arr[0].length){
	            return false;
	        }
	        
	        if(arr[i][j + jj] == '-' || arr[i][j + jj] == word.charAt(jj)){
	            continue;
	        }else{
	            return false;
	        }
	    }
	    
	    return true;
	}
	

    public static boolean canPlaceVertically(char[][] arr, String word, int i, int j){
	    //check upward
	    if(i - 1 >= 0 && arr[i - 1][j] != '+'){
	        return false;
	    }
	    
	    //check downward
	    if(i + word.length() <= arr[0].length - 1 && arr[i + word.length()][j] != '+'){
	        return false;
	    }
	    
	    for(int ii = 0; ii < word.length(); ii++){
	        if(i + ii == arr.length){
	            return false;
	        }
	        
	        if(arr[i + ii][j] == '-' || arr[i + ii][j] == word.charAt(ii)){
	            continue;
	        }else{
	            return false;
	        }
	    }
	    
	    return true;
	}
	
	public static boolean[] placeHorizontally(char[][] arr, String word, int i, int j){
	    boolean[] visited = new boolean[word.length()];
	    
	    for(int jj = 0; jj < word.length(); jj++){
	        if(arr[i][j + jj] == '-'){
	            visited[jj] = true;
	            arr[i][j + jj] = word.charAt(jj);
	        }
	    }
	    
	    return visited;
	}
	
	
	public static void unplaceHorizontally(char[][] arr, String word, int i, int j, boolean[] visited){   
	    for(int jj = 0; jj < word.length(); jj++){
	        if(visited[jj] = true){
	            arr[i][j + jj] = '-';
	        }
	    }
	}
	
	
	public static boolean[] placeVertically(char[][] arr, String word, int i, int j){
	    boolean[] visited = new boolean[word.length()];
	    
	    for(int ii = 0; ii < word.length(); ii++){
	        if(arr[i + ii][j] == '-'){
	            visited[ii] = true;
	            arr[i + ii][j] = word.charAt(ii);
	        }
	    }
	    
	    return visited;
	}
	
	
	public static void unplaceVertically(char[][] arr, String word, int i, int j, boolean[] visited){   
	    for(int ii = 0; ii < word.length(); ii++){
	        if(visited[ii] == true){
	            arr[i + ii][j] = '-';
	        }
	    }
	}
	
	public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}
		
		solution(arr, words, 0);

	}
}
