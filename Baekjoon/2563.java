import java.util.Scanner;

public class Main {
    static int[][] map = new int[100][100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //사각형의 개수
        int[][] square = new int[N][2]; //사각형의 왼쪽 하단 모서리
        int minX = 100;
        int maxX = 0;
        int minY = 100;
        int maxY = 0;

        for(int i = 0; i < N; i++) {
            //사각형의 x값
            square[i][0] = sc.nextInt();
            //사각형의 y값
            square[i][1] = sc.nextInt();

            if(square[i][0] < minX) {
                minX = square[i][0];
            }
            if(square[i][0] > maxX) {
                maxX = square[i][0];
            }
            if(square[i][1] < minY) {
                minY = square[i][1];
            }
            if(square[i][1] > maxY) {
                maxY = square[i][1];
            }
        }
        maxY += 10;
        maxX += 10;

        for(int i = 0; i < N; i++){
            drawMap(square[i][0], square[i][1]);
        }

        int result = countPaint(minX, maxX, minY, maxY);
        System.out.println("result is " + result);
    }

    static void drawMap(int x, int y) {
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++){
                //범위에 맞는 위치 색칠
                map[x+i][y+j]++;
            }
        }
    }

    static int countPaint(int startX, int endX, int startY, int endY) {
        int sum = 0;
        for(int i = startX; i < endX; i++) {
            for(int j = startY; j < endY; j++) {
                if(map[i][j] > 0) sum++;
            }
        }

        return sum;
    }
}
