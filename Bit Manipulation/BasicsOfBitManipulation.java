import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    //Creating Mask for every number
    int ith = 1 << i;
    int jth = 1 << j;
    int kth = 1 << k;
    int mth = 1 << m;
    
    //setting ith bit -> OR operation is used : 1 + _ = 1
    System.out.println(n | ith);
    
    //unsetting jth bit -> AND op used with ~jth -> 0 & _ = 0
    System.out.println(n & ~jth);
    
    //Toggling kth bit -> XOR used : we know it toggles
    System.out.println(n ^ kth);
    
    //Checking mth bit -> AND is used
    System.out.println((n & mth) == 0 ? false : true);
    
    
  }

}
