import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] building = new int[N];
        long answer = 0;

        for(int i = 0; i < N; i++){
            building[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < N; i++){
            int cnt = 0;
            for(int j = i+1; j < N; j++){
                if(building[j] < building[i]){
                    cnt++;
                }
                else break;
            }
            answer += cnt;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String ans = Long.toString(answer);
        bw.write(ans);

        bw.flush();
        bw.close();
    }
}
