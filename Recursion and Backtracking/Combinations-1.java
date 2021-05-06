import java.io.*;
import java.util.*;

public class Main {

  //cb -> current box, tb -> total boxes, ssf-> item placed, ts -> total item
  public static void combinations(int cb, int tb, int ssf, int ts, String asf){
    //base case
    if(cb > tb){
        if(ssf == ts){
            System.out.println(asf);
        }
        return;
    }
    
    //items are not availble to placed
    if(ssf > ts){
        return;
    }
    
    //item is placed in the box
    combinations(cb + 1, tb, ssf + 1, ts, asf + "i");
    
    //item is not placed in the box
    combinations(cb + 1, tb, ssf, ts, asf + "-");
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int nboxes = Integer.parseInt(br.readLine());
    int ritems = Integer.parseInt(br.readLine());
    combinations(1, nboxes, 0, ritems, "");
  }

}
