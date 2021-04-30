import java.io.*;
import java.util.*;

public class Main {
  static int counter = 1;

  public static void solution(int i, int n, boolean[] used, String asf) {
    //base case
    if(i > n){
        System.out.println(counter + "." + asf);
        counter++;
        return;
    }
      
    //if friend already pair
    if(used[i] == true){
        solution(i+1, n, used, asf);
        return;
    }
    
    used[i] = true;
    
    //single
    solution(i+1, n, used, asf + "(" + i + ") ");
    
    //pair
    for(int x = i + 1; x <= n; x++){
        if(used[x] == false){
            used[x] = true;
            solution(i+1, n, used, asf + "(" + i + "," + x + ") ");
            used[x] = false;
        }
    }
    
    used[i] = false;
    
    
  }

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    boolean[] used = new boolean[n + 1];
    solution(1, n, used, "");
  }
}
