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
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int tar = Integer.parseInt(br.readLine());

        //row -> represents elements of arr
        //col -> represents target -> range from 0 to tar
        
        //every (i, j) block stores possibility of target 'j' in a subset upto ith element
        
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];
        //arr index = dp.row - 1
        //bcz dp first row for blank element
        //means 1st row of dp represents 0th element of arr
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                if(j == 0){
                    dp[i][j] = true;
                }else if(i == 0){
                    dp[i][j] = false;
                }else{
                   int val = arr[i - 1];
                   
                   if(j < val){//element doesn't make ant diff
                       dp[i][j] = dp[i - 1][j];//previous answer
                   }else if(dp[i - 1][j - val] == true){//elemnet participated to achieve target
                       dp[i][j] = true;
                   }else{//participation of this element not able to make tar
                       dp[i][j] = dp[i - 1][j];//depends on previous
                   }
                }
            }
        }
        
        
        System.out.println(dp[dp.length - 1][dp[0].length - 1]);
        
        Queue<Pair> q = new ArrayDeque<>();
        
        q.add(new Pair("", dp.length - 1, dp[0].length - 1));
        
        while(q.size() > 0){
            Pair rem = q.remove();
           
            
            if(rem.j == 0){//target is completed
                System.out.println(rem.psf);
            }else{
                int val = arr[rem.i - 1];
                
                if(rem.j >= val){//eleemt able participate
                    boolean inc = dp[rem.i - 1][rem.j - val];
                    if(inc == true){//included
                        q.add(new Pair((rem.i - 1) + " " + rem.psf, rem.i - 1, rem.j - val));
                    }
                    
                }
                   
                boolean exc = dp[rem.i - 1][rem.j];//excluded
                
                if(exc == true){
                    q.add(new Pair(rem.psf, rem.i - 1, rem.j));//not participate
                }
                
            }
        }

    }
}


                        


                        
