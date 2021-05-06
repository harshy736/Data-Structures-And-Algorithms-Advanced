import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        //board complete
        if(qpsf == tq){
            for(int r = 0; r < chess.length; r++){
                for(int c = 0; c < chess[0].length; c++){
                    if(chess[r][c] == true){
                        System.out.print("q" + "\t");
                    }else{
                        System.out.print("-" + "\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        //out of board right
        if(j == tq){
            queensCombinations(qpsf, tq, chess, i + 1, 0);
            return;
        }
        
        //out of board down
        if(i == tq){
            return;
        }
        
        //queen sit on the box
        chess[i][j] = true;
        queensCombinations(qpsf + 1, tq, chess, i, j + 1);
        chess[i][j] = false;
        
        //queen not sit
        queensCombinations(qpsf, tq, chess, i, j + 1);
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, 0);
    }
}
