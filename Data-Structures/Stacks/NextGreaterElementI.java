import java.io.*;
import java.util.*;

public class Main {
    public static int[] nextGreaterElement(int[] nums, int[] query) {
        int[] nge = nextGreater(nums);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length ; i++){
            map.put(nums[i], nge[i]);//putting nge corresponding to the element
        }
        
        //for query array
        int[] ans = new int[query.length];
        
        for(int i = 0; i < ans.length; i++){
            ans[i] = map.get(query[i]);//nge corresponding to element
        }
        
        return ans;
    }
    
    public static int[] nextGreater(int[] nums){
        Stack<Integer> st = new Stack<>();
        
        int[] ans = new int[nums.length];
        
        for(int i = nums.length - 1; i >= 0; i--){
            
            while(st.size() > 0 && nums[i] > st.peek()){
                st.pop();//remove smaller elements
            }
            //if stacj is not empty -> TOS contain next greater ele,emt fpr ith element
            ans[i] = (st.size() > 0) ? st.peek() : -1;
            st.push(nums[i]);//push element -> candidate for nge for next element
        }
        
        return ans;
    }

    public static int[] getArr(String s){
        String nums[] = s.split(" ");
        int n = nums.length;
        int ar[] = new int[n];
        for(int i=0;i<n;i++){
            ar[i] = Integer.parseInt(nums[i]);
        }
        return ar;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        int query[] = getArr(read.readLine());
        int nums[] = getArr(read.readLine());
        
        int ans[] = nextGreaterElement(nums, query);

        int n = ans.length;

        System.out.println(n);
        for(int e: ans){
            System.out.println(e);
        }
        
    }
}
