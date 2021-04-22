// import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    // base case -> sudoku comleted
    if(i == board.length){
        display(board);
        return;
    }
    
    int ni = i;
    int nj = j + 1;
    
    //if a row completed & we have to move to the next row
    if(nj == board[0].length){
        nj = 0;
        ni = i + 1;
    }
     
    //already filled -> no need to change anything    
    if(board[i][j] != 0){
        solveSudoku(board, ni, nj);
        return;
    }
    
    //0 +nt -> try every digit at this position from 1 to 9
    for(int k = 1; k <= 9; k++){
        if(isValid(board, i, j, k) == true){
            board[i][j] = k;
            solveSudoku(board, ni, nj);
            board[i][j] = 0;
        }
    }
  }
  
  
  public static boolean isValid(int[][] board, int i, int j, int val){
      //row wise
      for(int c = 0; c < board[0].length; c++){
          if(board[i][c] == val){
              return false;
          }
      }
      
      //column wise
      for(int r = 0; r < board.length; r++){
          if(board[r][j] == val){
              return false;
          }
      }
      
      //sub - matrix
      int r = (i/3) * 3;
      int c = (j/3) * 3;
      
      for(int x = r; x < r + 3; x++){
          for(int y = c; y < c + 3; y++){
              if(board[x][y] == val){
                  return false;
              }
          }
      }
      
      return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
