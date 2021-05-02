import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean isPallindrome(String str, int s, int e){
        while(s < e){
            char chs = str.charAt(s);
            char che = str.charAt(e);
            
            if(chs != che){
                return false;
            }
            
            s++;
            e--;
        }
        
        return true;
    }

	public static void solution(String str, int s, String asf) {
		//write you code here
		if(s == str.length()){
		    System.out.println(asf);
		}else{
		    for(int i = s; i < str.length(); i++){
		        if(isPallindrome(str, s, i)){
		            solution(str, i + 1, asf + "(" + str.substring(s, i+1) + ") ");
		        }
		    }
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
		solution(str, 0, "");
	}

}
