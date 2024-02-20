package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelfDividingNumbers728 {

    public List< Integer > selfDividingNumbers( int left, int right ) {
        List< Integer > result = new ArrayList<>();

        // 1. left ~ right 까지 반복
        for ( int i = left; i <= right; i++ ) {

//            if ( isSelfDividing( i ) ) {
            if ( solutionSelfDividing( i ) ) {
                result.add( i );
            }
        }
        return result;
    }

    /**
     * 통과는 되었으나 속도에 있어서는 26ms로 현저하게 느렸다.
     * solutionSelfDividing() 을 사용하면 3ms 로 통과한다.
     *
     * 성능 저하의 이유
     * 1. 문자열 변환과 분할 : String.valueOf(number)에서 연산이 발생하며, 특히 split()은 내부적으로 정규 표현식을 사용하기 때문에 오버헤드가 크다.
     * 2. 정수 변환 : Integer.parseInt(string)을 사용해서 다시 정수로 변환하는 추가 과정이 문자열 각 요소마다 반복 수행한다.
     *              char 배열을 직접 순회하면서 c - '0'으로 각 문자를 정수로 변환하는 과정이 더 단순하고 효율적이다.
     * @param number
     * @return
     */
    private boolean isSelfDividing( int number ) {
        // number를 문자로 변환
        String strNumber = String.valueOf( number );
        String[] strings = strNumber.split( "" );

        for ( String string : strings ) {
            int targetInt = Integer.parseInt( string );
            if ( targetInt == 0 ) return false;
            if ( number % targetInt != 0 ) return false;
        }
        return true;
    }

    private boolean solutionSelfDividing( int number ) {
        for ( char c : String.valueOf( number ).toCharArray() ) {
            // c = '0' 은 char로 표현된 숫자를 정수값으로 바꾸기 위한 일반적인 방법.
            if ( c == '0' || ( number % ( c - '0' ) > 0 ) ) {
                return false;
            }
        }
        return true;
    }
    public static void main( String[] args ) {
        SelfDividingNumbers728 obj = new SelfDividingNumbers728();
        System.out.println( obj.selfDividingNumbers( 1, 22 ) );
        System.out.println( obj.selfDividingNumbers( 47, 85 ) );
    }

}
