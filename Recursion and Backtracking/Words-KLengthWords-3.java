import java.io.*;
import java.util.*;

public class Main {
    public static void generateWords(int cc, String str, int ssf, int ts, Character[] spots, HashMap<Character, Integer> lastOccurence) {

        if (cc == str.length()) { // when we traverse through all characters
            if (ssf == ts) { // when we fill all slots
                for (char ch : spots) {
                    System.out.print(ch);
                }
                System.out.println();
            }
            return;
        }

        char ch = str.charAt(cc); // we choose for this character
        int lo = lastOccurence.get(ch); // note its last occurence
        for (int i = lo + 1; i < spots.length; i++) { // we choose a spot
            if (spots[i] == null) { // if it is empty
                spots[i] = ch; // put character here
                lastOccurence.put(ch, i); // update its last occurence
                generateWords(cc + 1, str, ssf + 1, ts, spots, lastOccurence); // call for next level
                lastOccurence.put(ch, lo); // undo while backtracking
                spots[i] = null; // undo while backtracking
            }
        }
        
        if (lo == -1) { // only when (lo == -1) so that no repetation
            generateWords(cc + 1, str, ssf, ts, spots, lastOccurence); // we don't put this character
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        Character[] spots = new Character[k];
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for (char ch : str.toCharArray()) {
            lastOccurence.put(ch, -1);
        }

        generateWords(0, str, 0, k, spots, lastOccurence);
    }
}
