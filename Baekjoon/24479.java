import java.util.*;

public class Main {
    static ArrayList<Integer>[] adj;
    static int[] visited;
    static int order = 1;
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); //정점의 개수
        int M = sc.nextInt(); //간선의 개수
        int R = sc.nextInt(); //시작 정점
        adj = new ArrayList[N]; 
        visited = new int[N]; //몇 번째로 방문했는지 저장

        for(int i = 0; i < N; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            adj[x-1].add(y);
            adj[y-1].add(x);
        }

        for(int i = 0; i < N; i++){
            ArrayList<Integer> temp = adj[i];
            Collections.sort(temp);
        }

        dfs(R);
        for(int i = 0; i < N; i++){
            System.out.println(visited[i]);
        }
    }

    static void dfs(int s) {
        ArrayList<Integer> sAdj = adj[s-1]; //인접한 노드 리스트
        for(int i = 0; i < sAdj.size(); i++){
            int next = sAdj.get(i); //인접한 노드
            if(visited[next-1] == 0){
                order++;
                dfs(next);
            }
        }

    }
}
