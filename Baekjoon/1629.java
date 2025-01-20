import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");
        int A = Integer.parseInt(info[0]);
        int B = Integer.parseInt(info[1]);
        int C = Integer.parseInt(info[2]);

        long answer = recur(A, B, C);
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
    }

    static long recur(int A, int B, int C){
        if(B == 0) return 1;
        if(B == 1) return A % C;

        long half = recur(A, B / 2, C);
        if(B % 2 == 0) return half * half % C;
        else return half * half % C * A % C;
    }
}
