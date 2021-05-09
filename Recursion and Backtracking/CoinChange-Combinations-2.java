import java.io.*;
import java.util.*;

public class Main {

    //i -> pointer on coins
    //amtsf -> amt so far
    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf){
        //base case
        if(amtsf == tamt){
            System.out.println(asf + ".");
            return;
        }
        
        //out of flow
        if(amtsf > tamt || i == coins.length){
            return;
        }
        
        int c = coins[i];
        
        //coin participate
        coinChange(i, coins, amtsf + c, tamt, asf + c + "-");
        //i bcz repeation is allowed any no. of time
        
        //coin does not participate
        coinChange(i + 1, coins, amtsf, tamt, asf);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        
        coinChange(0, coins, 0, amt, "");
    }
}
