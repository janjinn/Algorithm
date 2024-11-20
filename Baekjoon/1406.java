import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Stack<Character> origin = new Stack<>();
        Stack<Character> temp = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = br.readLine().split("");

        for(int i=0;i<arr.length;i++) {
            origin.push(arr[i].charAt(0));
        }

        int o = Integer.parseInt(br.readLine());
        for(int i = 0; i < o; i++){
            String order[] = br.readLine().split(" ");
            char control = order[0].charAt(0);

            if(control == 'P'){
                char x = order[1].charAt(0);
                origin.push(x);
            }
            else if(control == 'L' && !origin.isEmpty()){
                char top = origin.pop();
                temp.push(top);
            }
            else if(control == 'D' && !temp.isEmpty()) {
                char top = temp.pop();
                origin.push(top);
            }
            else if(control == 'B' && !origin.isEmpty()){
                origin.pop();
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(!origin.isEmpty()) {
            temp.push(origin.pop());
        }
        while(!temp.isEmpty()) {
            bw.write(temp.pop());
        }
        bw.flush();
        bw.close();
    }
}
