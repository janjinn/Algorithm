import java.util.*;

public class Main {
    static int W, H;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer;
        W = -1; H = -1;
        map = new int[50][50];
        visited = new boolean[50][50];
        queue = new LinkedList<>();

        while(W != 0 && H != 0){
            answer = 0;
            W = sc.nextInt();
            H = sc.nextInt();
            if(W == 0 && H == 0){
                return;
            }

            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    map[i][j] = sc.nextInt();
                    if(map[i][j] == 0) visited[i][j] = true;
                    else visited[i][j] = false;
                }
            }

            for(int i = 0; i < H; i++){
                for(int j = 0; j < W; j++){
                    if(map[i][j] == 1 && !visited[i][j]) {
                        int result = bfs(i, j);
                        answer += result;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    static int bfs(int x, int y){
        queue.clear();
        visited[x][y]= true;
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int X = now[0]; int Y = now[1];
            int nX = 0; int nY = 0;

            //상하좌우
            nX = X-1; nY = Y;
            if(nX >= 0 && map[nX][nY] == 1 && !visited[nX][nY]){
                queue.add(new int[]{nX,nY});
                visited[nX][nY] = true;
            }
            nX = X+1;
            if(nX < H && map[nX][nY] == 1 && !visited[nX][nY]){
                queue.add(new int[]{nX,nY});
                visited[nX][nY] = true;
            }
            nX = X; nY = Y-1;
            if(nY >= 0 && map[nX][nY] == 1 && !visited[nX][nY]) {
                queue.add(new int[]{nX,nY});
                visited[nX][nY] = true;
            }
            nY = Y+1;
            if(nY < W && map[nX][nY] == 1 && !visited[nX][nY]){
                queue.add(new int[]{nX,nY});
                visited[nX][nY] = true;
            }
            //대각선
            //좌상,우상,좌하,우하
            nX = X-1; nY = Y-1;
            if(nX >= 0 && nY >= 0 && map[nX][nY] == 1 && ! visited[nX][nY]) {
                queue.add(new int[]{nX,nY});
                visited[nX][nY] = true;
            }
            nX = X-1; nY = Y+1;
            if(nX >= 0 && nY < W && map[nX][nY] == 1 && ! visited[nX][nY]) {
                queue.add(new int[]{nX,nY});
                visited[nX][nY] = true;
            }
            nX = X+1; nY = Y-1;
            if(nX < H && nY >= 0 && map[nX][nY] == 1 && ! visited[nX][nY]) {
                queue.add(new int[]{nX,nY});
                visited[nX][nY] = true;
            }
            nX = X+1; nY = Y+1;
            if(nX < H && nY < W && map[nX][nY] == 1 && ! visited[nX][nY]) {
                queue.add(new int[]{nX,nY});
                visited[nX][nY] = true;
            }
        }

        return 1;
    }
}
