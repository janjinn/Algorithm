import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int K = sc.nextInt();
        int[] answer = new int[K];
        for(int test_case = 0; test_case < K; test_case++){
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            answer[test_case] = makeSum(i, j, x, y, arr);
        }

        for(int test_case = 0; test_case < K; test_case++){
            System.out.println(answer[test_case]);
        }
    }

    static int makeSum(int i, int j, int x, int y, int[][] arr){
        int sum = 0;
        for(int a = i; a <= x; a++){
            for(int b = j; b <= y; b++){
                sum += arr[a][b];
            }
        }

        return sum;
    }
}
