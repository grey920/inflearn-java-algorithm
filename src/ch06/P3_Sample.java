package ch06;

public class P3_Sample {
    public static void main( String[] args ) {

//        P3_1 sample = new P3_1();
        P3_2 sample = new P3_2();
        String arr[] = { "id1 8 1 5 1", "id2 art can", "id3 3 6", "id4 own kit dig", "id5 art zero" };
        String[] sortedArr = sample.reorderLogFiles( arr );

        for ( String s : sortedArr ) {
            System.out.println( s );
        }

    }
}
