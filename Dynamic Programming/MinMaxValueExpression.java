/*
1. You are given a string that represents an expression containing numbers and two operators + and *.
2. You have to find the minimum and maximum value which can be obtained by evaluating this expression by different parenthesization.
*/
import java.io.*;
import java.util.*;

public class Main {

	public static int[] solution(String str1, String str2) {
	    int[] num = new int[str1.length()];
	    for(int i = 0; i < num.length; i++){
	        num[i] = str1.charAt(i) - '0';
	    }
	    
	    
	    
		//write your code here
		int[][] dpmax = new int[str1.length()][str1.length()];
		//row -> start, col -> end
		//gap strategy
		//every(i, j)th stores max value can be obtained in str1.substring(i, j + 1)
		
		int[][] dpmin = new int[str1.length()][str1.length()];
		//row -> start, col -> end
		//gap strategy
		//every(i, j)th stores min value can be obtained in str1.substring(i, j + 1)
		
		for(int g = 0; g < dpmin.length; g++){
		    for(int i = 0, j = g; j < dpmin[0].length; j++, i++){
		        if(g == 0){//SINGLE Element
		            dpmin[i][j] = num[i];
		            dpmax[i][j] = num[i];
		        }else{
		            int min = Integer.MAX_VALUE, max = 0;
		            
		            //iterate over every parenthesis comb 
		            for(int k = i; k < j; k++){
		                char op = str2.charAt(k);//operator
		                int valmax = 0, valmin = 0;
		                
		                //val = (left) op (right)
		                //left & right is iterated
		                //left + right = exp
		                //left -> i, k
		                //right -> k + 1, j
		                
		                if(op == '+'){//add
		                    valmax = dpmax[i][k] + dpmax[k + 1][j];
		                    valmin = dpmin[i][k] + dpmin[k + 1][j];
		                }else{//* -> mul
		                    valmax = dpmax[i][k] * dpmax[k + 1][j];
		                    valmin = dpmin[i][k] * dpmin[k + 1][j];
		                }
		                
		                max = Math.max(max, valmax);
		                min = Math.min(min, valmin);
		            }
		            
		            dpmax[i][j] = max;
		            dpmin[i][j] = min;
		        }
		    }
		}
		
		
		int[] ans = new int[2];
		ans[0] = dpmin[0][dpmax.length - 1];
		ans[1] = dpmax[0][dpmin.length - 1];

		return ans;
	}

	public static void main(String[] args) {
	    
		Scanner scn = new Scanner(System.in);
		String s = scn.next();
		String str1 = "";
		String str2 = "";
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == '+' || ch == '*') {
				str2 += ch;
			} else {
				str1 += ch;
			}
		}
		int[] arr = solution(str1, str2);
		System.out.println("Minimum Value -> " + arr[0]);
		System.out.println("Maximum Value -> " + arr[1]);
	}

}
