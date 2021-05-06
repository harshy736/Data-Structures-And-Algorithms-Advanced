import java.io.*;
import java.util.*;

public class Main {

	static String max;
	public static void findMaximum(String str, int k) {
		//better ans
		if(Integer.parseInt(str) > Integer.parseInt(max)){
		    max = str;
		}
		
		//base case
		if(k == 0){
		    return;
		}
		
		for(int i = 0; i < str.length() - 1; i++){
		   char ith = str.charAt(i);
		   for(int j = i + 1; j < str.length(); j++){
		        char jth = str.charAt(j);
		        
		        //function call only when jth is grater than ith
		        if(jth > ith){
		            str = swap(str, i, j);
		            
		            findMaximum(str, k - 1);
		            str = swap(str, i, j);//backtrack = restore str
		        }
		   }
		}
	}
	
	
	public static String swap(String str, int i, int j){
	    char ith = str.charAt(i);
	    char jth = str.charAt(j);
	    
	    String left = str.substring(0, i);
        String mid = str.substring(i + 1, j);
        String right = str.substring(j + 1);
        
        str = left + jth + mid + ith + right;
        
        return str;
	}
	
	

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		max = str;
		findMaximum(str, k);
		System.out.println(max);
	}

}
