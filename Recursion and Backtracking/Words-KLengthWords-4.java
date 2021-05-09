import java.io.*;
import java.util.*;

public class Main {
    //we have to itearte on pos/boxes
    
    //ts -> total length  - k
    //ssf -> selected so far char
  public static void generateWords(String str, int ts, int ssf, HashMap<Character, Integer> unique, String asf){
      //desired word of length ts
      if(ssf == ts){
          System.out.println(asf);
          return;
      }
    
      for(char ch : str.toCharArray()){
          int freq = unique.get(ch);
              
               
          if(freq > 0){
              unique.put(ch, freq - 1);
              generateWords(str, ts, ssf + 1, unique, asf + ch);
              unique.put(ch, freq);
          }
      }
      
  }

  
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int k = Integer.parseInt(br.readLine());

    HashMap<Character, Integer> unique = new HashMap<>();
    String ustr = "";
    for (char ch : str.toCharArray()) {
      if (unique.containsKey(ch) == false) {
        unique.put(ch, 1);
        ustr += ch;
      } else {
        unique.put(ch, unique.get(ch) + 1);
      }
    }
    
    generateWords(ustr, k, 0, unique, "");
   
  }

}
