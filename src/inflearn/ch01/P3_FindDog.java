package inflearn.ch01;

import java.util.Arrays;

public class P3_FindDog {
    public int solution(int[][] board){
        int answer = 0;

        // 방향키
        int[] dx = { -1, 0, 1, 0 }; // 12시, 3, 6, 9시 방향
        int[] dy = { 0, 1, 0, -1 };
        int md = 0, dd = 0; // 나의 방향, 강아지의 방향 기본값 12시 방향

        // 나의 위치와 강아지의 위치 초기화
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;

        // 위치 초기화를 위해 지도 탐색
        for( int i = 0; i < 10; i++ ) { // 행
            for ( int j = 0; j < 10; j ++ ) { // 열
                // 현수
                if ( board[i][j] == 2 ) {
                    x1 = i; y1 = j;
                }
                // 강아지
                if ( board[i][j] == 3 ) {
                    x2 = i; y2 = j;
                }
            }
        }

        // 이동
        while( answer < 10000 ) {
            answer++;
            // 다음 위치값
            int nx1 = x1 + dx[md]; // 현수
            int ny1 = y1 + dy[md];
            int nx2 = x2 + dx[dd]; // 강아지
            int ny2 = y2 + dy[dd];

            // 회전 여부 플래그
            boolean isNotRotated = true;
            boolean isNotDogRotated = true;

            // 현수 > 장애물 있거나 지도 끝 -> 방향 전환
            if ( nx1 >= 10 || nx1 < 0
                || ny1 >= 10 || ny1 < 0
                || board[nx1][ny1] == 1
            ){
                md = (md + 1) % 4;
                isNotRotated = false;
            }

            // 강아지 > 장애 있거나 지도 끝 -> 방향 전환
            if ( nx2 >= 10 || nx2 < 0
                || ny2 >= 10 || ny2 < 0
                || board[nx2][ny2] == 1
            ){
                dd = (dd + 1) % 4;
                isNotDogRotated = false;
            }

            // 회전하지 않은 녀석만 이동
            if ( isNotRotated ) {
                x1 = nx1; y1 = ny1;
            }
            if ( isNotDogRotated ) {
                x2 = nx2; y2 = ny2;
            }

            // 이동한 현수 위치와 강아지 위치가 같으면 리턴
            if (x1 == x2 && y1 == y2) {
                System.out.println("===================");
                System.out.println( "x = " + nx1 );
                System.out.println( "y = " + ny1 );
                return answer;
            }
        }

        return 0;
    }

    public static void main(String[] args){
        P3_FindDog T = new P3_FindDog();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));

        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }

}
