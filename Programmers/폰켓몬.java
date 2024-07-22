import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int N = nums.length;
        int vari = count(nums); //폰켓몬의 종류

//        N/2가 포켓몬의 종류보다 크면 정답은 포켓몬 종류의 개수
//        N/2가 포켓몬의 종류보다 작으면 정답은 N/2

        if(N/2 > vari) answer = vari;
        else answer = N/2;

        System.out.println("answer is " + answer);
        return answer;
    }
    
    static int count(int[] nums) {
        ArrayList<Integer> temp = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int now = nums[i];

            if(temp.contains(now)) {
                continue;
            }

            temp.add(now);
        }

        System.out.println("temp size is " + temp.size());
        return temp.size();
    }
}
