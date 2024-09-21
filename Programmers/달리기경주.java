import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        //선수 등수 조회를 쉽게 하기 위한 hashmap
        HashMap<String, Integer> answer = new HashMap<>();
        for(int i = 0; i < players.length; i++){
            answer.put(players[i], i);
        }
        
        for(int i = 0; i < callings.length; i++) {
            int idx = answer.get(callings[i]); //불린 선수의 현재 위치
            String front = players[idx-1]; //역전당한 선수
          
            players[idx-1] = callings[i];
            players[idx] = front;
            
            answer.put(callings[i], idx-1);
            answer.put(front, idx);
        }
        
        return players;
    }
}
