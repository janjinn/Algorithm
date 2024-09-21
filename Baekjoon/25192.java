import java.util.HashSet;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //채팅방 기록 개수
        sc.nextLine();
        HashSet<String> history = new HashSet<>(); //채팅방 기록
        int sum = 0;

        for(int i = 0; i < N; i++) {
            String s = sc.nextLine(); //기록
            if(s.equals("ENTER")) {
                sum += history.size();
                history.clear();
            }
            else {
                history.add(s);
            }
        }
        sum += history.size();

        System.out.println(sum);
    }
}
