import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    //right modt set bit -> the set bit(1) from the rightmost and all the other bits are 0.
    
    //To calcutae this , rsb = n & 2's comp of n
    //2's comp of n = -n
    
    int rsb = n & -n;
    
    //but we need answer in binary format,
    //so convert int into binary string
    System.out.println(Integer.toBinaryString(rsb));
  }

}
