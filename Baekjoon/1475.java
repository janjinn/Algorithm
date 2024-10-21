import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //방문 번호
        String NS = Integer.toString(N);
        int[] number = new int[10]; //6과 9는 빼고 저장
        int sixNine = 0; //6 또는 9의 개수

        for(int i = 0; i < NS.length(); i++){
            int now = Character.getNumericValue(NS.charAt(i));
            if(now == 6 || now == 9) sixNine++;
            else number[now]++;
        }

        int x = 0; //6과 9를 제외한 숫자들 중 겹치는 숫자가 가장 많은 경우
        int y = 0; //6과 9를 만들 수 있는 숫자판 개수

        for(int i = 0; i < 10; i++){
            if(x < number[i]) x = number[i];
        }

        y = sixNine / 2;
        if(sixNine % 2 == 1) y++;

        int answer = Math.max(x, y);

        System.out.println(answer);
    }
}
