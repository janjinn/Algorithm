import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        int x = sc.nextInt();
        arr.sort(Comparator.naturalOrder());

        int answer = 0;
        int LP = 0;
        int RP = n - 1;

        for(int i = 0; i < n; i++){
            if(RP-LP <= 0) break;

            int sum = arr.get(LP) + arr.get(RP);
            //System.out.println("LP is " + arr.get(LP) + " RP is " + arr.get(RP) + " sum is " + sum);

            //합이 x와 같으면 answer++
            if(sum == x) {
                answer++;
                RP--;
                LP++;
            }
            //합이 x보다 크면 오른쪽 포인터를 앞으로 이동
            else if(sum > x) RP--;
            //합이 y보다 작으면 왼쪽 포인터를 뒤로 이동
            else LP++;
        }

        System.out.println(answer);
    }
}
