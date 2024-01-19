package inflearn.ch01;

import java.util.Arrays;

public class P4_SeatNumber {
    public int[] solution(int c, int r, int k){
        int[] answer = new int[2]; // k번째 사람이 앉을 좌표

        if ( k > c * r ) return new int[] {0,0};

        // c = 행, r = 열
        // board 셋팅
        int[][] seat = new int[c][r];
        for( int i = 0; i < c; i ++ ) {
            for ( int j = 0; j < r; j++ ) {
                seat[i][j] = 0;
            }
        }

        // 방향키 셋팅 -> 3시 방향 기본값
        int[] dx = { -1, 0, 1, 0 }; // 12시, 3시, 6, 9
        int[] dy = { 0, 1, 0, -1 }; // 12시, 3시, 6, 9
        int d = 1, x = 0, y = 0, count = 1;

        while( count < k ) {

            // next
            int nx = x + dx[d];
            int ny = y + dy[d];

            if ( nx >= c || nx < 0 || ny >= r || ny < 0 || seat[nx][ny] > 0 ) {
                // 방향전환
                d = ( d + 1 ) % 4;
                continue;
            }
            seat[x][y] = count;
            count++;
            x = nx;
            y = ny;
        }

        answer[0] = x + 1;
        answer[1] = y + 1;

        return answer;
    }

    public static void main(String[] args){
        P4_SeatNumber T = new P4_SeatNumber();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
