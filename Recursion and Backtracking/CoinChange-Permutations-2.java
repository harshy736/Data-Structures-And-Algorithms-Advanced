import java.io.*;
import java.util.*;

public class Main {
    // no need of noolean array used bcz any coin can be used anytime

    public static void coinChange(int[] coins, int amtsf, int tamt, String asf) {
        //base case
        if(amtsf == tamt){
           System.out.println(asf + ".");
           return;
       }
       
       if(amtsf > tamt){
           return;
       }
       
       for(int i = 0; i < coins.length; i++){
               int c = coins[i];
                coinChange(coins, amtsf + c, tamt, asf + c +"-");
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
        coinChange(coins, 0, amt, "");
    }
}
