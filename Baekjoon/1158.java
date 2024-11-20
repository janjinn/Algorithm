import java.util.*;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] A;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //사람 수
        int k = sc.nextInt(); //제거할 인덱스
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            arr.add(i);
        }

        int[] answer = new int[n];
        int cnt = 0; //제거된 숫자 수
        int point = 0; //제거할 인덱스

        while(!arr.isEmpty()){
            point += (k-1);
            if(point >= arr.size()){
                point = point % arr.size();
            }

            int x = arr.remove(point);
            answer[cnt] = x;
            cnt++;
        }

        System.out.print("<");
        for(int i = 0; i < n-1; i++){
            System.out.print(answer[i] + ", ");
        }
        System.out.println(answer[n-1]+">");
    }
}
