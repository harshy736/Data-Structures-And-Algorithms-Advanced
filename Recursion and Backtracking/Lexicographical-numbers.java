import java.io.*;
import java.util.*;

public class Main {
    
    public static void solution(int n, int x){
        System.out.println(x);
        
        for(int i = 0; i < 10; i++){
            if(x*10 + i > n){
                break;
            }
            
            solution(n, x*10 + i);
        }
    }
    
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		for(int i = 1; i < 10; i++){
            solution(n, i);
        }
	}
	
}
