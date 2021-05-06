import java.io.*;
import java.util.*;

public class Main {
    //iterate through boxes
    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        //chess board complete
        if(row == tq){
            if(qpsf == tq){//all queens are placed
                System.out.println(asf + "\n");
            }
            return;
        }
        
        if(qpsf > tq){
            return;
        }
        
        //out of chess on right 
        if(col == tq){
            queensPermutations(qpsf, tq, row + 1, 0, asf + "\n", queens);
            return;
        }
        
        //every box have choice to fill any remaining queen
        for(int i = 0; i < tq; i++){
            if(queens[i] == false){
                queens[i] = true;
                queensPermutations(qpsf + 1, tq, row, col + 1, asf + "q" + (i + 1) + "\t", queens);
                queens[i] = false;
            }
        }
        
        //box have no queen
        queensPermutations(qpsf, tq, row, col + 1, asf + "-" + "\t", queens);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
