package ch06;

import java.util.ArrayList;
import java.util.List;

public class P3_1 {
    public String[] reorderLogFiles( String[] logs ){
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>(); // number

        // 반복
        for ( String log : logs ) {
            // digit log
            if ( Character.isDigit( log.split( " " )[1].charAt( 0 ) ) ) {
                digitList.add( log );
            }
            // letter log
            else {
                letterList.add( log );
            }
        }
        // letter log 정렬
        letterList.sort( ( s1, s2 ) -> {
            // 첫번째 공백을 기준으로 식별자 / 식별자 외 나머지 문자열로 분리
            String[] s1x = s1.split( " ", 2 );
            String[] s2x = s2.split( " ", 2 );

            // 식별자 외 문자열 비교
            int compared = s1x[1].compareTo( s2x[1] );
            // 비교 결과가 같으면 식별자 비교
            if ( compared == 0 ) {
                return s1x[0].compareTo( s2x[0] );
            }
            return compared;
        });

        // letter log + digit log
        letterList.addAll( digitList );

        // List to Array
        return letterList.toArray( new String[0] );
    };
}
