import java.io.*;
import java.util.*;

public class Main {

  public static void combinations(int[] boxes, int ci, int ti, int lb){
    //base cases
    if(ci > ti){
        for(int i = 0; i < boxes.length; i++){
            if(boxes[i] == 0){
                System.out.print('-');
            }else{
                System.out.print('i');
            }
        }
        
        System.out.println("");
        return;
    }
    
     if(lb == boxes.length){
        return;
    }
    
    //if item goes in the box
    boxes[lb] = 1;
    combinations(boxes, ci + 1, ti, lb + 1);
    boxes[lb] = 0;
    
    //if item not goes in the box
    combinations(boxes, ci, ti, lb + 1);
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(new int[nboxes], 1, ritems, 0);
  }

}
