import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str) {
		//like kadane's
	
		int cdiff = 0;
		int mdiff = 0;
		
		for(char ch : str.toCharArray()){
		    if(ch == '0'){
		        cdiff++;
		    }else{
		        cdiff--;
		    }
		    
		    if(cdiff > mdiff){
		        mdiff = cdiff;
		    }
		    
		    //sequence not worth it to add in new element
		    //restore it to 0 
		    if(cdiff < 0){
		        cdiff = 0;
		    } 
		}
		
		//all are 1
		if(mdiff == 0){
		    return -1;
		}

		return mdiff;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}
