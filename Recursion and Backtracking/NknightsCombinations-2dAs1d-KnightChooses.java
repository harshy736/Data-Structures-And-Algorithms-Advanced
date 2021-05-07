import java.io.*;
import java.util.*;

public class Main {
    
    public static boolean IsKnightThere(boolean[][] chess, int i, int j) {
        if(i < 0 || j < 0 || i >= chess.length || j >= chess.length){
            return true;
        }
        
        if(chess[i][j] ==  true){
            return false;
        }
        return true;
    }
    

    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
        //check on 8 positions in circular motion
        
        boolean k1 = IsKnightThere(chess, i - 2, j + 1);
        boolean k2 = IsKnightThere(chess, i - 1, j + 2);
        boolean k3 = IsKnightThere(chess, i - 1, j - 2);
        boolean k4 = IsKnightThere(chess, i - 2, j - 1);
        
        if(!k1 || !k2 || !k3 || !k4){
            return false;
        }
        
        return true;
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsKnightSafe(chess, row, col)) {
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}
