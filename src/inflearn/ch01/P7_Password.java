package inflearn.ch01;

import javax.xml.stream.events.Characters;
import java.util.Arrays;

public class P7_Password {
    public int solution(int[] keypad, String password){
        int answer = 0; //

        // 방향키
        int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 }; // 위, 오른쪽 대각선 위, 오른쪽, 오른쪽 대각선 아래, 아래, 왼쪽 대각선 아래, 왼쪽, 왼쪽 대각선 위
        int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

        // 1. keypad -> 2차월 배열로 전환
        int[][] pad = new int[3][3];
        for ( int i=0; i < 3; i++ ) {
            for( int j = 0; j < 3; j++ ) {
                pad[i][j] = keypad[i * 3 + j]; // !!!!!!!!!!!!!!
            }
        }

        // 2. password 이동에 걸린 시간을 미리 초기화한 2차원 배열. 본인이면 0초, 인접한 수는 1초, 그 외에는 2초.
        int[][] distance = new int[10][10];
        // 2-1. 2초로 초기화
        for(int i = 0; i < 10; i++ ) {
            Arrays.fill( distance[i], 2 ); // !!!!!!!!!!!!!!!!!1
        }
        // 2-2. 0초로 초기화
        for (int i = 0; i < 10; i++ ) {
            distance[i][i] = 0; // !!!!!!!!!!!!!!!!!!!
        }


        // 2-3. pad 상에서 인접한 숫자면 distance 배열에서 값을 1로 수정
        for ( int i = 0; i < 3; i++ ) {
            for ( int j = 0; j < 3; j++ ) {
                int from = pad[i][j];

                // 8방향 탐색
                for( int k = 0; k < 8; k++ ) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    // 범위 안에 있으면 1
                    if ( nx >= 0 && nx < 3 && ny >= 0 && ny < 3 ) {
                        int to = pad[nx][ny];
                        distance[from][to] = 1;
                    }

                }
            }
        }

        // 3. password를 선형탐색하면서 distance[i][j]의 값을 answer에 누적
        for( int i = 1; i < password.length(); i++ ) {
            int to =  password.charAt( i ) - 48;
            int from = password.charAt( i -1 ) - 48;

            answer += distance[from][to];
        }


        return answer;
    }

    public static void main( String[] args ) {
        P7_Password T = new P7_Password();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }

}
