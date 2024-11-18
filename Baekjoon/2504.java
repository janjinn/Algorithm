import java.util.*;

public class Main {
    static int N;
    static int L;
    static int R;
    static int[][] A;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        boolean closed = false; //연속된 닫힘 체크용

        int tmp = 1;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[') { //여는 괄호이면
                closed = false;
                //스택에 넣고
                stack.add(c);
                //곱셈 연산 실행
                if(c == '(') tmp *= 2;
                else tmp *= 3;
            }

            else { //닫는 괄호이면
                if(stack.isEmpty()) {
                    answer = 0;
                    break;
                }
                char now = stack.peek();

                //둘이 짝꿍이면
                if((c == ')' && now == '(') || (c == ']' && now == '[')){
                    stack.pop();

                    if(!closed) answer += tmp;

                    if(c == ')'){
                        tmp /= 2;
                    }
                    else tmp /= 3;

                    closed = true;
                }
                else {
                    answer = 0;
                    break;
                }
            }
        }

        if(!stack.isEmpty()) answer = 0;

        System.out.println(answer);
    }
}
