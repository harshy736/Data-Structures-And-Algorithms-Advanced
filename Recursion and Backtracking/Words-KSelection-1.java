import java.io.*;
import java.util.*;

public class Main {
    
    //ssf -> selection so far
    //cc -. current char
  public static void generateWords(String str, int cc, int k, int ssf, String asf){
      //desired output
      if(ssf == k){
          System.out.println(asf);
          return;
      }
      
      //string complete
      if(cc == str.length()){
          return;
      }
      
      char ch = str.charAt(cc);
      
      //charcter included
      generateWords(str, cc + 1, k, ssf + 1, asf + ch);
         
      
      //charcter excluded
      generateWords(str, cc + 1, k, ssf, asf);
      
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
    
    
    generateWords(ustr, 0, k, 0, "");
  }

}
