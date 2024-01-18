package inflearn.ch01;

import java.util.Arrays;

/**
 * 로봇 청소기 격자 문제
 */
public class P2_Clean {
    public int[] solution(int[][] board, int k){

        // 최종 결과값
        int[] answer = new int[2];
        int x = 0, y = 0;

        // 방향 변수
        int[] dx = { -1, 0, 1, 0 }; // 12시 방향부터, 3시, 6시, 9시
        int[] dy = { 0, 1, 0, -1 };
        int dir = 1; // 방향 변수. 3시 방향부터 시작

        // 시간이 끝날떄까지 이동
        while ( 0 < k ) {
            // 1초 차감
            k--;

            // 다음 이동값
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            // 다음 이동값이 지도 끝이거나 장애물 있으면 방향 전환
            if ( nx < 0 || nx >= board.length || ny < 0 || ny >= board.length || board[nx][ny] == 1 ) {
                dir = ( dir + 1 ) % 4; // 방향 전환.
                continue;
            }

            // 이동
            x = nx;
            y = ny;
        }

        answer[0] = x;
        answer[1] = y;
        return answer;
    }

    public static void main(String[] args){
        P2_Clean T = new P2_Clean();
        int[][] arr1 = {
            {0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1},
            {0, 0, 0, 0, 0}
        };
        System.out.println( Arrays.toString(T.solution(arr1, 10)));

        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0}
        };
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
