import java.io.*;
import java.util.*;

public class Main {
    public static int[] nextGreaterElementII(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[nums.length];
        
        for(int i = nums.length - 2; i >= 0; i--){
            while(st.size() > 0 && nums[i] >= st.peek()){
                st.pop();
            }
            st.push(nums[i]);
        }
        
        for(int i = nums.length - 1; i >= 0; i--){
            while(st.size() > 0 && nums[i] >= st.peek()){
                st.pop();
            }
            
            nge[i] = (st.size() > 0) ? st.peek() : -1;
            st.push(nums[i]);
        }
        
        return nge;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(read.readLine());
        int nums[] = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = Integer.parseInt(read.readLine());
        }
        
        int ans[] = nextGreaterElementII(nums);

        n = ans.length;

        System.out.println(n);
        for(int e: ans){
            System.out.println(e);
        }
        
    }
}
