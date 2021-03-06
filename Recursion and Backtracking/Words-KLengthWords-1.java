        
import java.io.*;
import java.util.*;

public class Main {
    
  public static void generateWords(String str, int cs, int ts, int ssf, Character[] spots){
      if(ssf == ts){
          for(int i = 0; i < spots.length; i++){
              System.out.print(spots[i]);
          }
          System.out.println();
          return;
      }
      
      if(cs == str.length()){
          return;
      }
      
      char ch = str.charAt(cs);
      
      //if charcter is included
      for(int i = 0; i < spots.length; i++){
          if(spots[i] == null){
              spots[i] = ch;
              generateWords(str, cs + 1, ts, ssf + 1, spots);
              spots[i] = null;
          }
      }
      
      //character not included
      generateWords(str, cs + 1, ts, ssf, spots);
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
    
    Character[] spots = new Character[k];
    
    
    generateWords(ustr, 0, k, 0, spots);
    
  }

}
