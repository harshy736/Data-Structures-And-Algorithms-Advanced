import java.io.*;
import java.util.*;

public class Main {

	public static int solution(int[] arr, int x, int y){
		//stores cummulative sum for the array
        int[] csum = new int[arr.length];
        csum[0] = arr[0];
        
        for(int i = 1; i < csum.length; i++){
            csum[i] = csum[i - 1] + arr[i]; 
        }
        
        //use dp
        
        int[] xdp = new int[arr.length];
        //ith block stores the sum of subarray of length x & end at i element
        
        //first subarray of length x
        xdp[x - 1] = csum[x - 1];
        
        for(int i = x; i < xdp.length; i++){
            xdp[i] = csum[i] - csum[i - x];
        }
        
        int[] ydp = new int[arr.length];
        //ith block stores the sum of subarray of length y & end at i element
        
        //first subarray of length y
        ydp[y - 1] = csum[y - 1];
        
        for(int i = y; i < ydp.length; i++){
            ydp[i] = csum[i] - csum[i - y];
        }
        
        int msum = 0;
        
        //sove by taking x as refrence
        for(int i = x - 1; i < xdp.length; i++){
            //taking possible subarray of length y to the subarray of length X having ith element as end
            for(int j = y - 1; j < ydp.length; j++){
                //overlapping condition
                if(j > i - x && j < i + y){
                    continue;
                }else{
                    int sum = xdp[i] + ydp[j];
                    
                    if(sum > msum){
                        msum = sum;
                    }
                }
            }
        }

		return msum;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = scn.nextInt();
		}
		int x = scn.nextInt();
		int y = scn.nextInt();
		System.out.println(solution(arr,x,y));
	}

}
