import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int answer = 0;
        String[] location = br.readLine().split(" ");
        int N = Integer.parseInt(location[0]);
        int K = Integer.parseInt(location[1]);
        visited = new int[100001];

        bfs(N, K);
        answer = visited[K];

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }

    static void bfs(int X, int K){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);

        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == K) break;

            if(now-1 >= 0 && visited[now-1] == 0) {
                visited[now-1] = visited[now] + 1;
                queue.add(now-1);
            }
            if(now+1 < 100001 && visited[now+1] == 0){
                visited[now+1] = visited[now] + 1;
                queue.add(now+1);
            }
            if(2*now < 100001 && visited[2*now] == 0){
                visited[2*now] = visited[now] + 1;
                queue.add(2*now);
            }
        }
    }
}
