import java.io.*;
import java.util.*;

public class Main {
    
    //cs - current spot
    //ts - total spot
	public static void generatepw(int cs, int ts, HashMap fmap, Character oddc, String asf) {
	    //permutation completed
        if (cs == ts + 1) {
        	System.out.println(asf + (oddc == null ? "" : oddc) + reverse(asf));
        	return;
        }
    
        for (char ch : fmap.keySet()) {
        	if (fmap.get(ch) > 0) {
        		fmap.put(ch, fmap.get(ch) - 1);
        		generatepw(cs + 1, ts, fmap,oddc, asf + ch);
        		fmap.put(ch, fmap.get(ch) + 1);
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
        
        for (int i = 0; i < 26; i++) {
        	char ch = (char) ('a' + i);
        	if (fmap.containsKey(ch)) {
        		int freq = fmap.get(ch);
        		if (freq % 2 != 0) {
             		oddchar = ch;
        		    ofc++;
        		}
        		
        		if (ofc > 1) {//no pallindrome possible
        		    System.out.println("-1");
        		    return;
        		}
        		
        		fmap.put(ch, freq / 2);
        		length += (freq / 2);
        	}
        }
        
        generatepw(1, length, fmap, oddchar, "");
		
		
	}
	
}
