import java.io.*;
import java.util.*;

public class Main {
    
    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(String psf, int i, int j){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] values = new int[n];
        String str1 = br.readLine();
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(str1.split(" ")[i]);
        }

        int[] wts = new int[n];
        String str2 = br.readLine();
        for (int i = 0; i < n; i++) {
            wts[i] = Integer.parseInt(str2.split(" ")[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        //taking 2d DP array
        //row represents elements -> first row blank
        //col -> capacities
        
        //every (i, j) stores max value if the capacity is j and elements are allowed til ith element
        
        int[][] dp = new int[n + 1][cap + 1];
        //first row & first col stores 0.
        
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                int wg = wts[i - 1];
                
                if(j < wg){//item can not participate
                    dp[i][j] = dp[i - 1][j];//previous
                }else{
                    int val = values[i - 1];
                    
                    //element participation gives max value
                    if(val + dp[i - 1][j - wg] > dp[i - 1][j]){
                        dp[i][j] = val + dp[i - 1][j - wg];
                    }else{//participation doesn't give max value than prebios
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        
        //bottom right corner stores max value for cap and all items
        System.out.println(dp[n][cap]);
        
        Queue<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair("", n, cap));
        
        while(q.size() > 0){
            Pair rem = q.remove();
           
            
            if(rem.j == 0 || rem.i == 0){//capacity is completed
                System.out.println(rem.psf);
            }else{
                int val = values[rem.i - 1];
                int wg = wts[rem.i - 1];
                
                if(rem.j < wg){//not able to participate
                    q.add(new Pair(rem.psf, rem.i - 1, rem.j));
                }else{
                    
                    int exc = dp[rem.i - 1][rem.j];//excluded
                    int inc = val + dp[rem.i - 1][rem.j - wg];//included
                    
                    //previous has same value
                    if(dp[rem.i][rem.j] == exc){
                         q.add(new Pair(rem.psf, rem.i - 1, rem.j));
                    }
                    
                    //participation gives max value
                    if(dp[rem.i][rem.j] == inc){
                         q.add(new Pair((rem.i - 1) + " " + rem.psf, rem.i - 1, rem.j - wg));
                    }
                }
                
            }
        }
    }
}

