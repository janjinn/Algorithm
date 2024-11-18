import java.util.*;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] A;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //지도의 크기
        L = sc.nextInt(); //최소 인구 차
        R = sc.nextInt(); //최대 인구 차
        A = new int[N][N]; //인구 수
        int day = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                A[i][j] = sc.nextInt();
            }
        }

        int cnt = 2; //그날 연합국의 개수

        while(cnt > 1){ //날짜 변경
            cnt = 0;
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j]){ //연합여부가 판단되지 않았다면
                        visited[i][j] = true;
                        int result = bfs(i, j);
                        cnt += result;
                    }
                }
            }
            if(cnt == 0) break;
            if(cnt > 1) day++;
        }

        System.out.println(day);
    }

    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> together = new LinkedList<>();
        queue.add(new int[]{x,y});
        int[] tx = {-1, 1, 0, 0};
        int[] ty = {0, 0, -1, 1};
        int sum = 0; //연합국의 전체 인구 수

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            together.add(now);
            int nowX = now[0];
            int nowY = now[1];
            sum += A[nowX][nowY];

            for(int t = 0; t < 4; t++){
                int nextX = nowX + tx[t];
                int nextY = nowY + ty[t];

                if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || visited[nextX][nextY]){
                    continue;
                }


                int popu = Math.abs(A[nextX][nextY]-A[nowX][nowY]); //인구 수 차이
                if(popu >= L && popu <= R){
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        int togetherSize = together.size();
        if(togetherSize == 1) return 0;

        int newPopu = sum / togetherSize;

        for(int i = 0; i < togetherSize; i++){
            int[] ab = together.poll();
            int a = ab[0];
            int b = ab[1];
            A[a][b] = newPopu;
        }

        return togetherSize;
    }
}
