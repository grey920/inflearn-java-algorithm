package leetcode;

public class LongestTurbulentSubarray_978 {

    public int maxTurbulenceSize(int[] arr) {
        int maxLen = 1, start = 0;

        for( int i = 1; i < arr.length; i++ ) {
            int c = Integer.compare( arr[ i - 1 ], arr[ i ] );

            if ( c == 0 ){
                start = i;
            }
            // 마지막 인덱스이거나 조건을 만족하지 않을 때 (turbulent하지 않을때) -> 최댓값을 갱신
            else if( i == arr.length-1 || c * Integer.compare( arr[i], arr[i+1] ) != -1 ) {
                maxLen = Math.max( maxLen, i-start+1 );
                start = i;
            }
        }

        return maxLen;
    }

    public static void main( String[] args ) {
        LongestTurbulentSubarray_978 obj = new LongestTurbulentSubarray_978();
        System.out.println(obj.maxTurbulenceSize(new int[]{9,4,2,10,7,8,8,1,9}));
        System.out.println(obj.maxTurbulenceSize(new int[]{4,8,12,16}));
        System.out.println(obj.maxTurbulenceSize(new int[]{100}));
    }
}
