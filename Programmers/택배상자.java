import java.util.*;
class Solution {
    
    public int solution(int[] order) {
        int answer = 0;
        int boxes = order.length; //택배의 개수
        int orderIdx = 0; //택배 기사의 요구 완료 진행도
        
        Stack<Integer> supportContainer = new Stack<>();
        ArrayList<Integer> truck = new ArrayList<>(); //트럭에 실은 택배
        
        for(int i = 0; i < boxes; i++) {
            int nowBox = -1; //컨테이너 위의 현재 박스
            
            if(order[orderIdx] == (i+1)) {
                truck.add(i+1);
                orderIdx++; //다음 요청으로 
            }
            else {
                nowBox = i;
            }
            
            while(!supportContainer.isEmpty() && 
                  supportContainer.peek() + 1 == order[orderIdx]){
                truck.add(order[orderIdx]);
                    orderIdx++;
                    supportContainer.pop();
            }
            if(nowBox >= 0) supportContainer.push(nowBox);  
        }
        answer = truck.size();
      
        return answer;
    }
}
