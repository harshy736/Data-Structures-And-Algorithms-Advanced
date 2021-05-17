import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        
        //every block stores the count of distinct subsequences possible if ith char is the last char 
        long[] dp = new long[str.length() + 1];
        dp[0] = 1;//blank/null string
        
        //stores the position of every char and update that if its come again
        HashMap<Character, Integer> lastOccurence = new HashMap<>(); 
        
        for(int i = 1; i < dp.length; i++){
            char ch = str.charAt(i - 1);
            dp[i] = dp[i - 1] * 2;
            
            if(lastOccurence.containsKey(ch)){
                Integer pos = lastOccurence.get(ch);//last occurence of this char
                
                //dp[pos - 1] -> only these subsequences can be repeated i.e er remove that once for no repeation
                dp[i] = dp[i] - dp[pos - 1];
            }
            
            //update or put last occurence pos of char
            lastOccurence.put(ch, i);
            
        }
        
        //last block have count for whole str
        long count = dp[dp.length - 1] - 1;
        // -1 for removing empty subsequence
        
        System.out.println(count);

    }
}
