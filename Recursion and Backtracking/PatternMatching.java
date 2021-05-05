import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, String pattern, HashMap<Character,String> map, String op){
		//base case
		if(pattern.length() == 0){
		    if(str.length() == 0){
	            HashSet<Character> alreadyPrinted = new HashSet<>();
	            
	            for(int i = 0; i < op.length(); i++){
	                char ch = op.charAt(i);
	                
	                if(alreadyPrinted.contains(ch) == false){
	                    alreadyPrinted.add(ch);
	                    System.out.print(ch + " -> " + map.get(ch) + ", ");
	                }
	            }
	            
	            System.out.println(".");
		    }
		    
		    return;
		}
		
		char ch = pattern.charAt(0);
		String rop = pattern.substring(1);//rest of pattern
		
		if(map.containsKey(ch)){
		    String mappedStr = map.get(ch);
		    
		    if(mappedStr.length() <= str.length()){
		        String left = str.substring(0, mappedStr.length());
		        String right = str.substring(mappedStr.length());
		        
		        if(mappedStr.equals(left)){
		            solution(right, rop, map, op);
		        }
		    }
		}else{
		    for(int i = 0; i < str.length(); i++){
		        String left = str.substring(0, i + 1);
		        String right = str.substring(i + 1);
		        
		        map.put(ch, left);
		        solution(right, rop, map ,op);
		        map.remove(ch);
		    }
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		String pattern = scn.next();
		HashMap<Character,String> map = new HashMap<>();
		solution(str,pattern,map,pattern);
	}
}
