/*1. You are given a number n, representing the number of rows.
2. You are given a number m, representing the number of columns.
3. You are given n*m numbers, representing elements of 2d array a, which represents a maze.
4. You are standing in top-left cell and are required to move to bottom-right cell.
5. You are allowed to move 1 cell right (h move) or 1 cell down (v move) in 1 motion.
6. Each cell has a value that will have to be paid to enter that cell (even for the top-left and bottom-right cell).
7. You are required to traverse through the matrix and print the cost of the path which is least costly.
8. Also, you have to print all the paths with minimum cost.
*/

import java.io.*;
import java.util.*;

public class Main {

   private static class Pair {
      String psf;
      int i;
      int j;

      public Pair(String psf, int i, int j) {
         this.psf = psf;
         this.i = i;
         this.j = j;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(br.readLine());
      int m = Integer.parseInt(br.readLine());
      int[][] arr = new int[n][m];

      for (int i = 0; i < n; i++) {
         String str = br.readLine();
         for (int j = 0; j < m; j++) {
            arr[i][j] = Integer.parseInt(str.split(" ")[j]);
         }
      }

      //every (i, j) box stores the min cost to go to bottom right corner
      int[][] dp = new int[arr.length][arr[0].length];
      
      for (int i = n - 1; i >= 0 ; i--) {
         for (int j = m - 1; j >= 0; j--) {
            if(i == n - 1 && j == m - 1){//bottom right element
                dp[i][j] = arr[i][j];
            }
            else if(i == n - 1){//bottom row -> only horizontal move
                dp[i][j] = dp[i][j + 1] + arr[i][j];
            }else if(j == m - 1){//right column -> only we get here by vertical move
                dp[i][j] = dp[i + 1][j] + arr[i][j];
            }else{
                dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                //choosing path which have min cost
                //horizontal or vertcal
            }
         }
      }
      
      int mc = dp[0][0];//min cost of top left corner to bottom right corner
      System.out.println(mc);
      
      Queue<Pair> q = new ArrayDeque<>();
      
      //adding top left corner
      q.add(new Pair("", 0, 0));
      
      while(q.size() > 0){
          Pair rem = q.remove();
          
          if(rem.i == dp.length - 1 && rem.j == dp[0].length - 1){//bottom right corner
              System.out.println(rem.psf);
          }else if(rem.i == dp.length - 1){//horizontal moves allowed only
              q.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
          }else if(rem.j == dp[0].length - 1){//vertcal moves allowed only
              q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
          }else{
              //vertical -> V move gives the path of min cost
              if(dp[rem.i + 1][rem.j]  < dp[rem.i][rem.j + 1]){
                  q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
              }else if(dp[rem.i][rem.j + 1] < dp[rem.i + 1][rem.j]){////horizontal -> H move gives the path of min cost
                  q.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
              }else{//both pah have same cost
                  q.add(new Pair(rem.psf + "V", rem.i + 1, rem.j));
                  q.add(new Pair(rem.psf + "H", rem.i, rem.j + 1));
              }
              
          }
          
      }
      
   }

}
