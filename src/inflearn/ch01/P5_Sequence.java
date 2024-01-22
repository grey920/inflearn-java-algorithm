package inflearn.ch01;

import java.util.ArrayList;

public class P5_Sequence {
    /**
     * 수열을 입력받아 가장 긴 바이토닉 수열의 길이를 반환한다
     * @param nums
     * @return
     */
    public int solution(int[] nums){
        int answer = 0;

        // 1. 봉우리 찾기 ( 조건문 대신 i를 1부터 n까지...!!)
        ArrayList< Integer > peeks = new ArrayList<>();
        int n = nums.length; // 아마도 성능위해 뺀 듯
        for ( int i = 1; i < n-1; i++ ) {
            // 직전 값과 다음값이 현재보다 작으면 봉우리, 아니면 넘어감
            if ( nums[i - 1] < nums[i] && nums[i] > nums [i + 1] ) {
                peeks.add( i );
            }
        }
//        System.out.println( "peeks = " + peeks );

        // 2. 각 봉우리를 기준으로 수열 길이 찾기 -> 가장 긴 길이 찾기
        for( int x : peeks ){
            // count 변수는 하나에 담으면 됨
            // l과 r을 x로 초기화..!!!
            int left = x;
            int right = x;
            int count = 1;
            // 왼쪽 탐색
            while ( left-1 >= 0 && nums[left-1] < nums[left] ) {
                left--;
                count++;
            }
            // 오른쪽 탐색
            while ( right+1 < nums.length && nums[right+1] < nums[right] ) {
                right++;
                count++;
            }

            answer = Math.max( answer, count );

        }

        return answer;
    }

    public static void main(String[] args){
        P5_Sequence T = new P5_Sequence();

        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
