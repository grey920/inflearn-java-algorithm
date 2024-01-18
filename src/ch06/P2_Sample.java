package ch06;

public class P2_Sample {

    public static void main( String[] args ) {
//        P2_1 sample = new P2_1();
        P2_2 sample = new P2_2();

        char[] arr = { 'a', 'b', 'c', 'd', 'e' };
        sample.reverseString( arr );
        for ( char s : arr ) {
            System.out.println( s );
        }
    }

}
