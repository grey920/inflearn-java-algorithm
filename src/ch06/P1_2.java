package ch06;

/**
 * 속도 느림 ( 클래스 직접 비교, 정규식 이용 )
 */
public class P1_2 {
    public boolean isPalindrome( String s ) {

        // 정규식 이용하여 유효한 문자로 필터링
        String s_filtered = s.replaceAll( "[^a-zA-Z0-9]", "" ).toLowerCase();

        // 문자열 뒤집어서 String으로 변경
        String s_reversed = new StringBuilder( s_filtered ).reverse().toString();

        // 두 문자열 동등 비교
        return s_filtered.equals( s_reversed );
    }
}
