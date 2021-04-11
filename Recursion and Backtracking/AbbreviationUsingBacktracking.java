import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf,int count, int pos){
        //write your code here
        if(pos == str.length()){
            if(count != 0){
                asf += count + "";
            }
            System.out.println(asf);
            return;
        }
        
        //if this pos char participate
        if(count == 0){
            solution(str, asf + str.charAt(pos), 0, pos + 1);
        }else{
            solution(str, asf + count + str.charAt(pos), 0, pos + 1);
        }
        
        // if this pos char not particpate
        solution(str, asf, count + 1, pos + 1);
    }
    
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0, 0);
    }
    
    
}
