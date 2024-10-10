import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        ArrayList<Character> s = new ArrayList<>();
        int zero = 0;
        int one = 0;

        for(int i = 0; i < S.length(); i++) {
            s.add(S.charAt(i));
            if(s.get(i) == '0') zero++;
            else if(s.get(i) == '1') one++;
        }
        zero = zero / 2;
        one = one / 2;

        for(int i = 0; i < one; i++) {
            int idx = s.indexOf('1');
            s.remove(idx);
        }

        Collections.reverse(s);
        for(int i = 0; i < zero; i++) {
            int idx = s.indexOf('0');
            s.remove(idx);
        }

        Collections.reverse(s);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.size(); i++) {
            sb.append(s.get(i));
        }

        System.out.println(sb);
    }
}
