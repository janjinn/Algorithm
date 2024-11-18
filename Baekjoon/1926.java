import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] paper;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        paper = new int[n][m];
        visited = new boolean[n][m];

        int cnt = 0;
        int max = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                paper[i][j] = sc.nextInt();
                if(paper[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(paper[i][j] == 1 && !visited[i][j]){
                    cnt++;
                    int result = bfs(i,j);
                    if(max < result) max = result;
                }
            }
        }

        System.out.println(cnt+"\n"+max);
    }

    static int bfs(int x, int y){
        int size = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            //상하좌우
            int[] tx = {-1, 1, 0, 0};
            int[] ty = {0, 0, -1, 1};

            for(int i = 0; i < 4; i++){
                int nX = nowX + tx[i];
                int nY = nowY + ty[i];

                if(nX >= 0 && nX < n && nY >= 0 && nY < m){
                    if(paper[nX][nY] == 1 && !visited[nX][nY]){
                        size++;
                        queue.add(new int[]{nX,nY});
                        visited[nX][nY] = true;
                    }
                }
            }
        }

        return size;
    }
}
