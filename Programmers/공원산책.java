import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2]; 
        char[][] parkMap = new char[park.length][park[0].length()];
        
        for(int i = 0; i < park.length; i++) { 
            for(int j = 0; j < park[i].length(); j++) { 
                if(park[i].charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
                parkMap[i][j] = park[i].charAt(j);
            }
        }
        
        for(int i = 0; i < routes.length; i++) {
            char op = routes[i].charAt(0); 
            int n = Character.getNumericValue(routes[i].charAt(2)); 
            int saveX = answer[1]; //routes를 실행하기 전 강아지 위치를 저장
            int saveY = answer[0]; //routes를 실행하기 전 강아지 위치를 저장
            
            for(int j = 0; j < n; j++) {
                int nowX = answer[1]; 
                int nowY = answer[0]; 
              
                switch(op) {
                    case 'E': 
                        if(nowX + 1 >= parkMap[0].length || parkMap[nowY][nowX + 1] == 'X') {
                            answer[1] = saveX;
                            answer[0] = saveY;
                            j = n;
                        }
                        else {
                            answer[1] = nowX + 1;
                            answer[0] = nowY; 
                        }
                        break;
                        
                        case 'W': 
                        if(nowX - 1 < 0 || parkMap[nowY][nowX - 1] == 'X') {
                            answer[1] = saveX;
                            answer[0] = saveY;
                            j = n;
                        }
                        else {
                            answer[1] = nowX - 1;
                            answer[0] = nowY; 
                        }
                        break;
                        
                        case 'N': 
                        if(nowY - 1 < 0 || parkMap[nowY - 1][nowX] == 'X') {
                            answer[1] = saveX;
                            answer[0] = saveY;
                            j = n;
                        }
                        else {
                            answer[1] = nowX;
                            answer[0] = nowY - 1; 
                        }
                        break;
                        
                        case 'S':
                        if(nowY + 1 >= parkMap.length || parkMap[nowY + 1][nowX] == 'X') {
                            answer[1] = saveX;
                            answer[0] = saveY;
                            j = n;
                        }
                        else {
                            answer[1] = nowX;
                            answer[0] = nowY + 1; 
                        }
                        break;
                }
            }
        }
        
        return answer;
    }
}
