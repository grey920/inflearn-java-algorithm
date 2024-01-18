package ch06;

public class P1_Sample {
    public static void main( String[] args ) {
        long startTime = System.nanoTime();
//        P1_1 test = new P1_1(); // 422833
//        P1_2 test = new P1_2(); // 15489250
        P1_3 test = new P1_3(); // 2470875 (코틀린은 컴파일이 오래 걸리는거라 측정 의미가 X) / 442375ns (순수 실행시간은 1과 비슷)

        String string = "Do geese see God?";
        System.out.println( test.isPalindrome( string ) );

        long endTime = System.nanoTime();
        System.out.println( "Took " + (endTime - startTime) + " ns" );
    }
}
