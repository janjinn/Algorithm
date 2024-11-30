import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N];
        int answer = 0;

        for(int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 2; i >= 0; i--){
            if(scores[i+1] <= scores[i]) {
                answer += (scores[i] - scores[i+1] + 1);
                scores[i] = scores[i+1] - 1;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
