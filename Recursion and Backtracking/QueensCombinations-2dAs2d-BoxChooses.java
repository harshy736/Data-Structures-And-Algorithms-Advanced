import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        //board complete
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }
            return;
        }
        
        //out of board on right side
        if(col == tq){
            queensCombinations(qpsf, tq, row + 1, 0, asf + "\n");
            return;
        }
        
        //queen is placed on box
        if(qpsf < tq)//only if we have queen
        {
            queensCombinations(qpsf + 1, tq, row, col + 1, asf + "q");
        }
        
        //queen is not placed
        queensCombinations(qpsf, tq, row, col + 1, asf + "-");
        
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
    
}
