import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    boolean[][] board = new boolean[n][n];
    //write your code here
    boolean[] cols = new boolean[n];
    
    //no. of diagonals = 2 * n - 1
    boolean[] ndiag = new boolean[2 * n - 1];//low to high diagnoal -> row + col
    boolean[] rdiag = new boolean[2 * n - 1];//high to low diagonal -> row - col + board.length - 1
    solve(board, 0, cols, ndiag, rdiag, "");
  }
  
  public static void solve(boolean[][] board, int row, boolean[] cols, boolean[] ndiag, boolean[] rdiag, String asf){
      if(row == board.length){
          asf += ".";
          System.out.println(asf);
          return;
      }
      
      for(int c = 0; c < board.length; c++){
          if(cols[c] == false && ndiag[row + c] == false && rdiag[row - c + board.length - 1] == false){
              
              board[row][c] = true;
              cols[c] = true;
              ndiag[row + c] = true;
              rdiag[row - c + board.length - 1] = true;
              
              solve(board, row + 1, cols, ndiag, rdiag, asf + row + "-" + c + ", ");
              
              board[row][c] = false;
              cols[c] = false;
              ndiag[row + c] = false;
              rdiag[row - c + board.length - 1] = false;
          }
      }
  }
}
