import java.io.*;
import java.util.*;

public class Main {

	public static void solution(String str, int minRemoval, HashSet<String> ans) {
		//base case
		if(minRemoval == 0){
		    int mrem = getMin(str);
		    
		    //print is possible only if it is valid and never printed before
		    if(mrem == 0 && ans.contains(str) == false){
		        ans.add(str);
		        System.out.println(str);
		    }
		    return;
		}
		
		if(str.length() == 0){
		    return;
		}
		
		//removing closed brackets from front
		char ch = str.charAt(0);
		while(ch == ')'){
		    str = str.substring(1);
		    
		    if(str.length() == 0){
		        return;
		    }
		    ch = str.charAt(0);
		    minRemoval--;
		}
		
		for(int i = 0; i < str.length(); i++){
		    //ith chracter is removed or not passed
		    String left = str.substring(0, i);
		    String right = str.substring(i + 1);
		    
		    solution(left + right, minRemoval - 1, ans);
		}
	}
	

	public static int getMin(String str){
		Stack<Character> st = new Stack<>();
		
		for(int i = 0; i < str.length(); i++){
		    char ch = str.charAt(i);
		    
		    if(ch == '('){
		        st.push(ch);
		    }else{
		        if(st.size() == 0 || st.peek() == ')'){
		            st.push(ch);
    		    }else{ //peek == '('
    		        st.pop();
    		    }
		    }
		}
		
		return st.size();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str, getMin(str),new HashSet<>());
	}
		
}
