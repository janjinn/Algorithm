import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static  int N, M, H;
    static int[][][] tomatos;
    static Queue<int[]> tomatoNode;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] info = br.readLine().split(" ");
        M = Integer.parseInt(info[0]);
        N = Integer.parseInt(info[1]);
        H = Integer.parseInt(info[2]);
        tomatos = new int[H][N][M]; //높이, 행, 열
        tomatoNode = new LinkedList<>();
        int answer = 0;

        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                String[] tomato = br.readLine().split(" ");
                for(int m = 0; m < M; m++){
                    tomatos[h][n][m] = Integer.parseInt(tomato[m]);
                    if(tomatos[h][n][m] == 1) tomatoNode.add(new int[]{h,n,m});
                }
            }
        }

        bfs();

        Loop:
        for(int h = 0; h < H; h++){
            for(int n = 0; n < N; n++){
                for(int m = 0; m < M; m++){
                    if(tomatos[h][n][m] == 0){
                        answer = 0;
                        break Loop;
                    }
                    else {
                        answer = Math.max(answer, tomatos[h][n][m]);
                    }
                }
            }
        }

        bw.write(Integer.toString(answer-1));
        bw.flush();
        bw.close();
    }

    static void bfs(){
        int[] tx = {0, 0, 1, -1, 0, 0}; //행
        int[] ty = {1, -1, 0, 0, 0, 0}; //열
        int[] tz = {0, 0, 0, 0, 1, -1}; //위아래

        while(!tomatoNode.isEmpty()) {
            int[] now = tomatoNode.poll();
            int h = now[0];
            int n = now[1]; //행
            int m = now[2]; //열

            for (int i = 0; i < 6; i++) {
                int nextX = n + tx[i];
                int nextY = m + ty[i];
                int nextZ = h + tz[i];

                if (nextY < 0 || nextY >= M || nextX < 0 || nextX >= N || nextZ < 0 || nextZ >= H) {
                    continue;
                }

                if (tomatos[nextZ][nextX][nextY] == 0) {
                    tomatos[nextZ][nextX][nextY] = tomatos[h][n][m] + 1;
                    tomatoNode.add(new int[]{nextZ, nextX, nextY});
                }
            }
        }

        return;
    }
}
