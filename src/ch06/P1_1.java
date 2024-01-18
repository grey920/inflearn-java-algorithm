package ch06;

import com.sun.source.tree.UsesTree;

/**
 * 속도 매우 빠름 (원시 자료형 char 사용)
 */
class P1_1 {

    /**
     * 1. 맨 앞과 맨 뒤를 각각 유효한 자리로 이동(영숫자가 아닌 경우)
     * 2. 유효한 자리에 위치했다면 소문자로 통일하고 비교
     * 3. 비교해서 일치하면 중앙으로 이동, 불일치면 바로 false 리턴
     * 4. 겹치는 지점까지 이동했다면 true
     * 맨 앞과 맨 뒤에서 한 칸씩 서로를 향해 비교하면서 중앙으로 이동. 겹치는 지점까지 오면 -> 팰린드롬 true
     * @param s
     * @return
     */
    public boolean isPalindrome( String s ) {

        int start = 0;
        int end = s.length() -1;

        // 서로 중앙으로 이동해 나가다 겹치는 지점에 도달하면 종료
        while( start < end ) {

            // 영순자 판별. 유효X(공백이나 특수문자) -> 한 칸씩 이동
            if( !Character.isLetterOrDigit( s.charAt( start ) ) ) {
                start++;
            }
            else if ( !Character.isLetterOrDigit( s.charAt( end ) ) ) {
                end--;
            }
            // 유효한 문자 -> start와 end 모두 소문자 변경 후 비교
            else {
                // 비교시 다른 문자라면 -> false 리턴
                if ( Character.toLowerCase( s.charAt( start ) ) != Character.toLowerCase( s.charAt( end ) ) ) {
                    return false;
                }

                // 비교시 같은 문자라면 -> 중앙으로 한칸씩 이동
                start++;
                end--;
            }

        }
        // 무사히 while을 통과한 경우(start == end)
        return true;
    }

}