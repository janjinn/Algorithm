import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static  int L,R,C;
    static int[][][] building;
    static Queue<int[]> rooms;
    static int[] escape;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");
        L = Integer.parseInt(info[0]);
        R = Integer.parseInt(info[1]);
        C = Integer.parseInt(info[2]);
        building = new int[L][R][C]; //높이, 행, 열

        while(!(L == 0 && R == 0 && C == 0)){
            building = new int[L][R][C]; //높이, 행, 열
            rooms = new LinkedList<>();
            escape = new int[3];
            int answer = 0;

            for(int l = 0; l < L; l++){
                for(int r = 0; r < R; r++){
                    String[] room = br.readLine().split("");
                    for(int c = 0; c < C; c++){
                        String s = room[c];
                        if(s.equals("S")) {
                            rooms.add(new int[]{l,r,c}); //시작점 저장
                            building[l][r][c] = 1;
                        }
                        else if(s.equals("#")) building[l][r][c] = -1;
                        else if(s.equals("E")){
                            building[l][r][c] = 0;
                            escape[0] = l;
                            escape[1] = r;
                            escape[2] = c;
                        }
                        else building[l][r][c] = 0;
                    }
                }
                br.readLine();
            }

            bfs();

            answer = building[escape[0]][escape[1]][escape[2]];
            if(answer == 0) bw.write("Trapped!\n");
            else bw.write("Escaped in " + Integer.toString(answer-1) + " minute(s).\n");

            info = br.readLine().split(" ");
            L = Integer.parseInt(info[0]);
            R = Integer.parseInt(info[1]);
            C = Integer.parseInt(info[2]);
        }

        bw.flush();
        bw.close();
    }

    static void bfs(){
        int[] tx = {0, 0, 1, -1, 0, 0}; //행
        int[] ty = {1, -1, 0, 0, 0, 0}; //열
        int[] tz = {0, 0, 0, 0, 1, -1}; //위아래

        while(!rooms.isEmpty()) {
            int[] now = rooms.poll();
            int h = now[0];
            int n = now[1]; //행
            int m = now[2]; //열

            for (int i = 0; i < 6; i++) {
                int nextX = n + tx[i];
                int nextY = m + ty[i];
                int nextZ = h + tz[i];

                if (nextY < 0 || nextY >= C || nextX < 0 || nextX >= R || nextZ < 0 || nextZ >= L) {
                    continue;
                }

                if (building[nextZ][nextX][nextY] == 0) {
                    building[nextZ][nextX][nextY] = building[h][n][m] + 1;
                    rooms.add(new int[]{nextZ, nextX, nextY});
                }
                else if(nextZ == escape[0] && nextX == escape[1] && nextY == escape[2]) break;
            }
        }
    }
}
