import java.io.*;
import java.util.*;

public class Main {
    //iterate over positions
    //cs -> current pos, ps -> total pos
  public static void generateWords(String str, HashSet<Character> used, int cs, int ts,  String asf){
      if(cs == ts){
          System.out.println(asf);
          return;
      }
      
      
      //every char can place on pos
      for(char ch : str.toCharArray()){
          //char not used already
          if(used.contains(ch)){
              used.remove(ch);
              generateWords(str, used, cs + 1, ts, asf + ch);
              used.add(ch);
          }
            
      }
      
  }

 

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashSet<Character> unique = new HashSet<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.contains(ch) == false) {
        unique.add(ch);
        ustr += ch;
      }
    }
    
   
    generateWords(ustr, unique, 0, k, "");
    
  }

}
