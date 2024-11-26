import java.io.*;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] pipeLine = br.readLine().split("");
        Stack<String> pipe = new Stack<>();
        boolean flag = false; //파이프가 끝났는지 판단
        int answer = 0;

        for(int i = 0; i < pipeLine.length; i++){

            if(pipeLine[i].equals("(")){
                pipe.push(pipeLine[i]);
                flag = false;
            }
            else {
                pipe.pop();
                if(!flag){
                    answer += pipe.size();
                }
                else answer++; //여기가 중요! 파이프가 끝났을 경우에 파이프 꼬다리 부분을 더해줘야 한다
                flag = true;
            }
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}
