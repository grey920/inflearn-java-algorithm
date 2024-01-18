package inflearn.ch01;

import java.util.*;

/**
 * 1. 사다리 타기
 */
class P1_Ladder {
    /**
     * 1. 배열을 char 문자로 초기화 : A, B, C, D, E (ascii 65~ / 소문자는 97~)
     * 2. 동시에 내려오면서 순서 재정렬
     *  - ladder[i] 요소와 일치하는 문자는 옆의 문자와 swap
     *  - 이 작업을 ladder 길이만큼 반복
     * @param n 학생 수
     * @param ladder 가로줄 수 및 구조
     * @return
     */
    public char[] solution(int n, int[][] ladder){
        // 정렬
        char[] answer = new char[n];
        for ( int i = 0; i < n; i++ ) {
            answer[i] = (char)(i+65);
        }

        // 사다리 타기
        for ( int[] line : ladder ) {
            for ( int x : line ) {
                char temp = answer[x-1];
                answer[x-1] = answer[x];
                answer[x] = temp;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        P1_Ladder T = new P1_Ladder();
        System.out.println(Arrays.toString(T.solution(5, new int[][]{{1, 3}, {2, 4}, {1, 4}})));
        System.out.println(Arrays.toString(T.solution(7, new int[][]{{1, 3, 5}, {1, 3, 6}, {2, 4}})));
        System.out.println(Arrays.toString(T.solution(8, new int[][]{{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
        System.out.println(Arrays.toString(T.solution(12, new int[][]{{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
    }
}
