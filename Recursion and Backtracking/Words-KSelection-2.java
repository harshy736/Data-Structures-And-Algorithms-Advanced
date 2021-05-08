import java.io.*;
import java.util.*;

public class Main {
    
    //lc -> last char selected from string
    //cs -> charcter selected, ts -> total char to select = k  
  public static void generateWords(String str, int cs, int ts, int lc, String asf){
      //desired output -> word complete of length k
      if(cs == ts){
          System.out.println(asf);
          return;
      }
      
      //starts from lc bcz if we start from 0 it gives us duplicate
      for(int i = lc + 1; i < str.length(); i++){
          char ch = str.charAt(i);
          generateWords(str, cs + 1, ts, i, asf + ch);
      }
      
  }


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());
    
    String ustr = "";//unique str -> no duplicates
    
    HashSet<Character> set = new HashSet<>();
    for(int i = 0; i < str.length(); i++){
        char ch = str.charAt(i);
        if(set.contains(ch) == false){
            ustr += ch;
            set.add(ch);
        }
    }

    generateWords(ustr, 0, k, -1, "");
  }

}
