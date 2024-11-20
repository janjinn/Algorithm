import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());

        for(int i = 0; i < test_case; i++){
            String password[] = br.readLine().split("");
            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for(int j = 0; j < password.length; j++){
                char order = password[j].charAt(0);

                if(order == '<'){
                    if(!left.isEmpty()){
                        char x = left.pop();
                        right.push(x);
                    }
                }
                else if(order == '>'){
                    if(!right.isEmpty()){
                        char x = right.pop();
                        left.push(x);
                    }
                }
                else if(order == '-'){
                    if(!left.isEmpty()){
                        left.pop();
                    }
                }
                else {
                    left.push(order);
                }
            }

            while(!left.isEmpty()) {
                right.push(left.pop());
            }
            while(!right.isEmpty()) {
                bw.write(right.pop());
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
