import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int K, W, H;
    static int[][] map;
    static int[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        String[] info = br.readLine().split(" ");
        W = Integer.parseInt(info[0]);
        H = Integer.parseInt(info[1]);
        map = new int[H][W];
        visited = new int[K+1][H][W];

        for(int i = 0; i < H; i++){
            info = br.readLine().split(" ");
            for(int j = 0; j < W; j++){
                map[i][j] = Integer.parseInt(info[j]);
            }
        }

        int answer = Integer.MAX_VALUE;
        if(W == 1 && H == 1) answer = 0;
        else {
            bfs();
            for(int i = 0; i <= K; i++){
                if(visited[i][H-1][W-1] != 0 && answer > visited[i][H-1][W-1]){
                    answer = visited[i][H-1][W-1];
                }
            }
            if(answer == Integer.MAX_VALUE) answer = -1;
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }

    static void bfs(){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, 0, 0}); // x, y, k

        Scanner sc = new Scanner(System.in);

        int[] tx = {1, -1, 0, 0};
        int[] ty = {0, 0, 1, -1};
        int[] hx = {2, 2, 1, -1, -2, -2, 1, -1};
        int[] hy = {1, -1, 2, 2, 1, -1, -2, -2};

        while(!que.isEmpty()){
            int[] now = que.poll();
            int nowX = now[0];
            int nowY = now[1];
            int nowK = now[2];

            for(int t = 0; t < 4; t++){
                int nextX = nowX + tx[t];
                int nextY = nowY + ty[t];

                if(nextX >= H || nextX < 0 || nextY >= W || nextY < 0) continue;

                if(map[nextX][nextY] != 1 && (visited[nowK][nextX][nextY] == 0 || visited[nowK][nextX][nextY] > visited[nowK][nowX][nowY] + 1)){
                    visited[nowK][nextX][nextY] = visited[nowK][nowX][nowY] + 1;
                    if(!(nextX == H - 1 && nextY == W -1)) que.add(new int[]{nextX, nextY, nowK});
                }
            }

            if(nowK + 1 <= K){
                for(int t = 0; t < 8; t++){
                    int nextX = nowX + hx[t];
                    int nextY = nowY + hy[t];

                    if(nextX >= H || nextX < 0 || nextY >= W || nextY < 0) continue;

                    if(map[nextX][nextY] != 1 && (visited[nowK+1][nextX][nextY] == 0 || (visited[nowK+1][nextX][nextY] > visited[nowK][nowX][nowY] + 1))){
                        visited[nowK+1][nextX][nextY] = visited[nowK][nowX][nowY] + 1;
                        if(!(nextX == H - 1 && nextY == W -1)) que.add(new int[]{nextX, nextY, nowK + 1});
                    }
                }
            }
        }
    }
}
