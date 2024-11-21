import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> tower = new Stack<>(); //높이와 인덱스
        int[] answer = new int[N];

        String[] numbers = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(numbers[i]);

            if(!tower.isEmpty()){
                while(!tower.isEmpty()){
                    int[] left = tower.peek();
                    int leftHeight = left[0];
                    int leftIndex = left[1];

                    if(leftHeight > x){
                        answer[i] = leftIndex + 1;
                        break;
                    }
                    else {
                        tower.pop();
                    }
                }
            }
            tower.push(new int[]{x, i});
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i = 0; i < N; i++){
            String x = Integer.toString(answer[i]);
            bw.write(x + " ");
        }

        bw.flush();
        bw.close();
    }
}
