package leetcode;

import java.util.Arrays;

public class MinimumSpaceWastedFromPackage_1889 {

    public int minWastedSpace(int[] packages, int[][] boxes) {
        // 패키지 크기순 정렬
        Arrays.sort( packages );

        // 패키지의 누적합을 저장할 배열
        long[] preSumPackages = new long[ packages.length ];
        preSumPackages[ 0 ] = packages[ 0 ];
        for ( int i = 1; i < packages.length; i++ ) {
            preSumPackages[ i ] = preSumPackages[ i - 1 ] + packages[ i ];
        }

        // 리턴할 최소 낭비 공간 크기 변수
        long minWaste = Long.MAX_VALUE;

        // 각 supplier에 대해 반복
        for ( int[] box : boxes ) {
            // 박스들 크기순 정렬
            Arrays.sort( box );
            // 낭비된 공간과 처리된 마지막 패키지 인덱스를 저장할 변수 초기화
            long waste = 0, lastIdx = 0;

            // 각 박스 크기에 대해 반복
            for ( int size : box ) {
                // 현재 박스 크기에 맞는 패키지를 이진 검색으로 찾는다
                int idx = Arrays.binarySearch( packages, size );
                // binarySearch()로 정확한 인덱스를 찾지 못하면 삽입 지점을 계산한다.
                if ( idx < 0 ) idx = -( idx + 1 );
                if ( idx > lastIdx ) {
                    // 낭비된 공간을 계산해서 누적 (  현재 상자 크기 * 새로 처리된 패키지 수 - 새로 처리된 패키지의 총 크기 )
                    // lastIdx > 0 ? preSumPackages[(int) lastIdx-1] : 0 => 첫번째 박스가 아니라서 lastIdx가 갱신된 경우, 이전 박스로 계산된 누적값은 합계에서 제한다.
                    waste += size * ( idx - lastIdx ) - ( preSumPackages[idx-1] - ( lastIdx > 0 ? preSumPackages[(int) lastIdx-1] : 0 ) );
                    lastIdx = idx; // 처리된 마지막 패키지 인덱스를 lastIdx로 갱신한다.
                }
            }

            // supplier가 가진 박스들을 모두 확인했다면 최소 낭비 공간을 갱신한다.
            if ( lastIdx == packages.length ) minWaste = Math.min( minWaste, waste );
        }

        return minWaste == Long.MAX_VALUE ? -1 : (int) minWaste % 1_000_000_007;

    }

    public static void main( String[] args ) {
MinimumSpaceWastedFromPackage_1889 minimumSpaceWastedFromPackage_1889 = new MinimumSpaceWastedFromPackage_1889();
        int[] packages = {2, 3, 5};
        int[][] boxes = {{8, 4}, {2, 8}};
        System.out.println( minimumSpaceWastedFromPackage_1889.minWastedSpace( packages, boxes ) );
    }
}
