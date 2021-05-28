/*
1. You are given a boolean expression with symbols T,F, and operators &,|,^ , where
   T represents True
   F represents False
   & represents boolean AND
   | represents boolean OR
   ^ represents boolean XOR.
2. You have to find the number of ways in which the expression can be parenthesized so that the value of expression evaluates to true.
*/

import java.io.*;
import java.util.*;

public class Main {

	public static int solution(String str1, String str2) {
		//S1 -> contains T and F only
		//S2 -> contains all operations between the operands in sequence
		//length of S2 = length of S1 - 1
		
		//e.g S1 -> TFTF, S2 -> ^|&, expression => T ^ F | T & F 
		//we have to find no of ways in which the expression can be parenthesized for value TRUE
		
		//we have to use gas strategy, both sides having S1
		//row -> start, col -> end
		//between -> operator
		
		//to solve an expression : E = (L) op (R)
		//op -> operation b/w them
		//for the value of True, we have to consider all the values of L and R according to the operator
		
		//lt = count of left true, lf - count of false left L
		//rt = count of right true, rf - count of false right R
		
		//tc = true count, fc = false count of expression F
		
		//we have 3 operators
		
		//1. | (OR)
		//tc = lt. rt + lt. rf + lf. rt, TT + TF + FT
		//fc = lf. rf, FF
		
		//2. & (AND)
		//tc = lt. rt , TT
		//fc = lt. rf + lf. rt + lf. rf , TF + FT + FF
		
		//3. ^ (XOR)
		//tc = lt. rf + lf. rt  , TF + FT
		//fc = lt. rt + lf. rf ,  TT + FF
		
		//Whole problrm is based on these formula
		
		//Use 2 dp to store the no of ways of values for string
		
		//1 for true , 1 for false
		
		//True Dp -> to store no of ways for true
		int[][] dpt = new int[str1.length()][str1.length()];
		
		//False Dp -> to store no of ways for false
		int[][] dpf = new int[str1.length()][str1.length()];
		
		//fill both these dp array in a single loop
		
		for(int g = 0; g < dpt.length; g++){
		    for(int i = 0, j = g; j < dpt[0].length; i++, j++){
		        if(g == 0){
		            if(str1.charAt(j) == 'T'){
		                dpt[i][j] = 1;
		                dpf[i][j] = 0;
		            }else{
		                dpt[i][j] = 0;
		                dpf[i][j] = 1;
		            }
		        }else{
		            
		            
		            for(int k = i; k < j; k++){
		                
		                char oprtr = str2.charAt(k);
		                
		                int ltc = dpt[i][k];
		                int rtc = dpt[k + 1][j];
		                
		                int lfc = dpf[i][k];
		                int rfc = dpf[k + 1][j];
		                
		                
		                if(oprtr == '|'){
		                    //true -> TT + TF + FT
		                    dpt[i][j] += ltc * rtc + ltc * rfc + lfc * rtc;
		                    
		                    //false - FF
		                    dpf[i][j] += lfc * rfc;
		                    
    		            }else if(oprtr == '&'){
    		                 //true - TT
		                    dpt[i][j] += ltc * rtc;
		                    
		                    //false - TF + FT + FF
		                    dpf[i][j] += ltc * rfc + lfc * rtc + lfc * rfc;
		                    
    		            }else{// ^
    		                //true -> TF + FT
		                    dpt[i][j] += ltc * rfc + lfc * rtc;
		                    
		                    //false - TT + FF
		                    dpf[i][j] += ltc * rtc + lfc * rfc;
    		            }
		            }
		        }
		    }
		}

        //true for whole expression
		return dpt[0][dpt[0].length - 1];
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1, s2));
	}

}
