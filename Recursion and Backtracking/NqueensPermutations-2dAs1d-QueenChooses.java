import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {

        //horizontally
        for(int j = 0; j < chess[0].length; j++){
            if(chess[row][j] != 0){
                return false;
            }
        }
        
         //vertically
        for(int i = 0; i < chess.length; i++){
            if(chess[i][col] != 0){
                return false;
            }
        }
        
        //left diagonal up
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j] != 0){
                return false;
            }
        }
        
        //left diagonal down
        for(int i = row + 1, j = col + 1; i < chess.length && j < chess.length; i++, j++){
            if(chess[i][j] != 0){
                return false;
            }
        }
        
        
        //right diagonal up
        for(int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++){
            if(chess[i][j] != 0){
                return false;
            }
        }
        
        //right diagonal down
        for(int i = row + 1, j = col - 1; i <  chess.length && j >= 0; i++, j--){
            if(chess[i][j] != 0){
                return false;
            }
        }
        
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        //base
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    if(chess[row][col] != 0){
                        System.out.print("q" + chess[row][col] + "\t");
                    }else{
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        
        //try to place queen on every box
         for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    if(chess[row][col] == 0 && IsQueenSafe(chess, row, col)){
                        chess[row][col] = qpsf + 1;
                        nqueens(qpsf + 1, tq, chess);
                        chess[row][col] = 0;
                    }
                }
            }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
