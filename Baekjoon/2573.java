import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");
        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);
        map = new int[N][M]; //높이, 행, 열

        for(int i = 0; i < N; i++){
            info = br.readLine().split(" ");
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(info[j]);
            }
        }

        int answer = 0;
        while(true){
            int result = melt();
            //bw.write(Integer.toString(result)+"\n");

            answer++;

            if(result <= 0){
                if(result <= -1) answer = 0;
                break;
            }
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }

    //빙하가 녹는 걸 체크
    static int melt() {
        int[][] temp = new int[N][M];
        for(int i = 0; i < N; i++) temp[i] = map[i].clone();

        int result = 0;
        int[] tx = {1, -1, 0, 0};
        int[] ty = {0, 0, 1, -1};

        //처음부터 분리된 빙하이면, main 메소드에서 연산 불필요
        result = bfs(temp);
        if(result == 0) return -2;

        //빙하 녹이기
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0) continue;

                int water = 0;
                for(int t = 0; t < 4; t++){
                    int nextX = i + tx[t];
                    int nextY = j + ty[t];

                    if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                    if(map[nextX][nextY] == 0) water++;
                }
                if(water < map[i][j]) temp[i][j] -= water;
                else temp[i][j] = 0;
            }
        }

        result = bfs(temp);
        for(int i = 0; i < N; i++) map[i] = temp[i].clone();

        return result;
    }

    //빙하가 분리됐는지 체크
    static int bfs(int[][] temp){
        //이어진 빙하조각
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        int[] tx = {1, -1, 0, 0};
        int[] ty = {0, 0, 1, -1};

        int total = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(temp[i][j] == 0) continue;
                if(que.isEmpty()) {
                    que.add(new int[]{i,j});
                    visited[i][j] = true;
                }
                total += temp[i][j];
            }
        }

        //빙하가 다 녹았지만 하나의 덩어리일 경우
        if(total == 0) return -1;

        int piece = 0;
        while(!que.isEmpty()){
            int[] now = que.poll();
            int nowX = now[0];
            int nowY = now[1];
            piece += temp[nowX][nowY];

            for(int t = 0; t < 4; t++){
                int nextX = nowX + tx[t];
                int nextY = nowY + ty[t];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
                if(temp[nextX][nextY] != 0 && !visited[nextX][nextY]) {
                    que.add(new int[]{nextX,nextY});
                    visited[nextX][nextY] = true;
                }
            }
        }

        //전체 빙하의 높이와 특정 빙하 조각의 높이의 합이 일치하면 빙하가 하나의 덩어리
        //조각남
        if(piece < total) return 0;
        else return piece;
    }
}
