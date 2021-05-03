import java.io.*;
import java.util.*;

public class Main {
    
    public static String reverse(String s){
        StringBuilder sb = new StringBuilder();
 
        // append a string into StringBuilder
        sb.append(s);
 
        // reverse StringBuilder
        sb.reverse();
 
        // return reversed String
        return sb.toString();
    }
    
    
    //cs - current spot
    //ts - total spot
	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
	    //permutation completed
        if (cs == ts + 1) {
            String revs = reverse(asf);//reversed string
            
            if(oddc != null){
                asf += oddc + "";
            }
            
        	System.out.println(asf + revs);
        	return;
        }
    
        for(char ch : fmap.keySet()){ 
            int freq = fmap.get(ch);
            
            
        	if (freq > 0) {
        		fmap.put(ch, freq - 1);
        		generatepw(cs + 1, ts, fmap, oddc, asf + ch);
        		fmap.put(ch, freq);
        	}
        }
    }

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}
		
		//write your code here
    	int ofc = 0;
        Character oddchar = null;
        int length = 0;
        
        for(char ch : fmap.keySet()){
    		int freq = fmap.get(ch);
    		if (freq % 2 != 0) {
         		oddchar = ch;
    		    ofc++;
    		}
    		
    		if (ofc > 1) {//no pallindrome possible
    		    System.out.println("-1");
    		    return;
    		}
    		
    		fmap.put(ch, freq/2);
    		length += (freq / 2);
        }
        
        generatepw(1, length, fmap, oddchar, "");
		
		
	}
	
}
