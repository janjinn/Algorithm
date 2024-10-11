import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dice = new int[6];

        int one = 50;
        int max = 0;
        for(int i = 0; i < 6; i++) {
            dice[i] = sc.nextInt();
            if(one > dice[i]) one = dice[i];
            if(max < dice[i]) max = dice[i];
        }

        int[] thr = {dice[0]+dice[1]+dice[2], dice[0]+dice[1]+dice[3], dice[0]+dice[2]+dice[4] ,dice[0]+dice[3]+dice[4],
                dice[1]+dice[2]+dice[5], dice[1]+dice[3]+dice[5], dice[2]+dice[4]+dice[5], dice[3]+dice[4]+dice[5]};
        long three = 150;
        for(int i = 0; i < 8; i++){
            if(three > thr[i]) three = thr[i];
        }

        int[] tw = {dice[0]+dice[1], dice[0]+dice[2], dice[0]+dice[3], dice[0]+dice[4],
        dice[1]+dice[2], dice[1]+dice[3], dice[1]+dice[5],
        dice[2]+dice[4], dice[2]+dice[5], dice[3]+dice[4], dice[3]+dice[5], dice[4]+dice[5]};
        long two = 100;
        for(int i = 0; i < 12; i++) {
            if(two > tw[i]) two = tw[i];
        }

        long answer = 0;
        if(N == 1) {
            for(int i = 0; i < 6; i++) {
                answer += dice[i];
            }
            answer -= max;
        }
        else if(N == 2) {
            answer = three * 4 + two * 4;
        }
        else {
            answer = one * (5L *N*N - 16L * N + 12) + two * (8L * N - 12) + three * 4;
        }

        System.out.println(answer);
    }
}
