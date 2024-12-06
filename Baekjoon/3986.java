import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int test_case = 0; test_case < T; test_case++){
            String[] words = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            stack.push(words[0]);

            if(words.length % 2 != 0) continue;

            for(int i = 1; i < words.length; i++){
                String word = words[i];


                if(!stack.isEmpty() && word.equals(stack.peek())){
                    stack.pop();
                }
                else stack.push(word);
            }

            if(stack.isEmpty()) answer++;
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
