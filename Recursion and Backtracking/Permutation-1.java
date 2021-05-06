import java.io.*;
import java.util.*;

public class Main {

  //ci -> current item, ti -> total items
  public static void permutations(int[] boxes, int ci, int ti){
    //base case -> all items are filled in boxes
    if(ci > ti){
        for(int i = 0; i < boxes.length; i++){
            System.out.print(boxes[i]);
        }
        System.out.println("");
        return;
    }
    
    //place item in every empty box and call function for next item
    for(int i = 0; i < boxes.length; i++){
        if(boxes[i] == 0){//empty box
            boxes[i] = ci;
            
            permutations(boxes, ci + 1, ti);
            boxes[i] = 0;//backtrack
        }
    }
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(new int[nboxes], 1, ritems);
  }

}
