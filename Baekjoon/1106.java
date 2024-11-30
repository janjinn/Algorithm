import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
        //고객 수 C와 도시 수 T
        String[] setting = br.readLine().split(" ");
        int C = Integer.parseInt(setting[0]);
        int T = Integer.parseInt(setting[1]);
      
        int[] dp = new int[C+101];
        Arrays.fill(dp,987654321);
        dp[0] = 0;
        int answer = Integer.MAX_VALUE;

        for(int i=0; i < T; i++){
            String[] value = br.readLine().split(" ");
            int cost = Integer.parseInt(value[0]);
            int people = Integer.parseInt(value[1]);

            for(int j = people; j < C + 101; j++){
                dp[j] = Math.min(dp[j], cost+dp[j-people]);
            }
        }

        for(int i = C; i < C + 101; i++){
            answer = Math.min(answer, dp[i]);
        }

        bw.write(Integer.toString(answer));
        bw.flush();
        bw.close();
    }
}
