//we have to count set bits in a number

import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    
    //no. of set bits in the number
    int bits = 0;
    
    //using Right most set Bit mask
    //get right most set bit one by one from right to left
    //subtract that rsb integer from n until it becomes 0 and increase bits
    while(n > 0){
        int rsb = n & -n;//rsb bit
        bits++;
        n -= rsb;
    }
    
    System.out.println(bits);
  }

}
