import java.util.*;

public class Main {
    static int R;
    static int C;
    static char[][] map;
    static int[][] route;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new char[R][C];
        int answer = 0;

        sc.nextLine();

        for(int i = 0; i < R; i++){
            String row = sc.nextLine();
            for(int j = 0; j < C; j++){
                map[i][j] = row.charAt(j);
            }
        }


        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(map[i][j] == 'L'){
                    route = new int[R][C];
                    int result = bfs(i,j);
                    if(result > answer) answer = result;
                }
            }
        }

        System.out.println(answer);
    }

    //시작점을 다시 탐색하는 경우를 막아야함
    static int bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        route[x][y] = 0;
        queue.add(new int[]{x,y});
        int[] tx = {-1, 1, 0, 0};
        int[] ty = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int t = 0; t < 4; t++){
                int nextX = nowX + tx[t];
                int nextY = nowY + ty[t];

                if(nextX >= 0 && nextX < R && nextY >= 0 && nextY < C && route[nextX][nextY] == 0 && !(nextX == x && nextY == y)){
                    if(map[nextX][nextY] == 'L'){
                            route[nextX][nextY] = route[nowX][nowY] + 1;
                            queue.add(new int[]{nextX, nextY});

                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i < R; i++){
            for(int j = 0; j < C; j++){
                if(route[i][j] > max){
                    max = route[i][j];
                }
            }
        }

        return max;
    }
}
