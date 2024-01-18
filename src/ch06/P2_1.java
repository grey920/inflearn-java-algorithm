package ch06;

public class P2_1 {

    public void reverseString( char[] s ){
        int start = 0;
        int end = s.length - 1;

        while( start < end ) {
            // swap
            char temp = s[ start ];
            s[ start ] = s[ end ];
            s[ end ] = temp;
            // move
            start++;
            end--;
        }
    }
}
