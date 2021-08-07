import java.io.*;
import java.util.*;

public class Main {
  public static int calculate(String s) {
    Stack<Integer> st = new Stack<>();
    char sign = '+';//default
    
    for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                int val = 0;
                //val complete for any no fo digits 
                while(i < s.length() && Character.isDigit(s.charAt(i))){
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;//staying for non digit character bcz i++ by loop -> stays at i
                
                if(sign == '+'){
                    st.push(val);
                }else if(sign == '-'){
                    st.push(-val);
                }else if(sign == '*'){
                    int a = st.pop();
                    int ans = a * val;
                    st.push(ans);
                }else if(sign == '/'){
                    int a = st.pop();
                    int ans = a / val;
                    st.push(ans);
                }
            }else if(ch != ' '){
                sign = ch;
            }
    }
    
    int sum = 0;
    while(st.size() > 0){
        sum += st.pop();
    }

    return sum;
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int result = calculate(read.readLine());
    System.out.println(result);

  }
}
