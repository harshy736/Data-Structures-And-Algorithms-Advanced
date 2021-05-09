import java.io.*;
import java.util.*;

public class Main {
    //iterate through pos

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf, boolean[] used){
       //base
       if(amtsf == tamt){
           System.out.println(asf + ".");
           return;
       }
       
       if(amtsf > tamt){
           return;
       }
       
       for(int i = 0; i < coins.length; i++){
           if(used[i] == false){
               int c = coins[i];
               used[i] = true;
               coinChange(coins, amtsf + c, tamt, asf + c +"-", used);
               used[i] = false;
           }
           
       }
    }
    
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        boolean[] used = new boolean[coins.length];
        coinChange(coins, 0, amt, "", used);
    }
}
