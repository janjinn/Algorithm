import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> que = new LinkedList<>();

        int back = -1;
        for(int i = 0; i < N; i++){
            String[] command = br.readLine().split(" ");

            if(command[0].equals("push")){
                int X = Integer.parseInt(command[1]);
                que.add(X);
                back = X;
            }
            else if(command[0].equals("pop")){
                int X = -1;
                if(!que.isEmpty()) X = que.poll();
                bw.write(Integer.toString(X) + "\n");
                if(que.isEmpty()) back = -1;
            }
            else if(command[0].equals("size")){
                int len = que.size();
                bw.write(Integer.toString(len) + "\n");
            }
            else if(command[0].equals("empty")){
                if(que.isEmpty()) bw.write("1" + "\n");
                else bw.write("0" + "\n");
            }
            else if(command[0].equals("front")){
                int X = -1;
                if(!que.isEmpty()) X = que.peek();
                bw.write(Integer.toString(X) + "\n");
            }
            else if(command[0].equals("back")){
                bw.write(Integer.toString(back) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
