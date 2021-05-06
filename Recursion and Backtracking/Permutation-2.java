import java.io.*;
import java.util.*;

public class Main {

  //reverse of permutaion - 1 in which we call fuction on the basis of items
  //in this we call funct on basis of boxes
  
  public static void permutations(int cb, int tb, int[] items, int ssf, int ts, String asf){
    //base case
    if(cb > tb){
        if(ssf == ts){
            System.out.println(asf);
        }
        return;
    }
    
    //item is place in box
    for(int i = 0; i < items.length; i++){
        if(items[i] == 0)//item is not placed anywherw
        {
            items[i] = cb;
            permutations(cb + 1, tb, items, ssf + 1, ts, asf + (i+1));
            items[i] = 0;
        }
    }
    
    
    //no item place in the box
    permutations(cb + 1, tb, items, ssf, ts, asf + '0');
    
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    permutations(1, nboxes, new int[ritems], 0, ritems, "");
  }

}
