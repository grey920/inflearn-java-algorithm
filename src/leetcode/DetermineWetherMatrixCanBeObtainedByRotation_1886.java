package leetcode;

import java.util.Arrays;

public class DetermineWetherMatrixCanBeObtainedByRotation_1886 {
    public boolean findRotation( int[][] mat, int[][] target ) {

        for ( int i = 0; i < 3; i++ ) {

            if ( Arrays.deepEquals( mat, target ) ) return true;
//            if (isEqual( mat, target) ) return true;

//            mat = rotateMatrixReturnNewMatrix( mat );
            rotateMatrix( mat );
        }

        return false;
    }

    private void rotateMatrix( int[][] matrix ) {
        int n = matrix.length;

        // 1. 행렬 전치
        for ( int i = 0; i < n; i++ ) {
            for ( int j = i; j < n; j++ ) { // 대각선 기준
                int temp = matrix[ i ][ j ];
                matrix[ i ][ j ] = matrix[ j ][ i ];
                matrix[ j ][ i ] = temp;
            }
        }

        // 2. 각 행마다 열 뒤집기
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n / 2; j++ ) { // 각 행의 반만 뒤집으면 행의 모든 요소가 정렬됨
                int temp = matrix[ i ][ j ];
                matrix[ i ][ j ] = matrix[ i ][ n - j - 1 ];
                matrix[ i ][ n - j - 1 ] = temp;
            }
        }
    }

    /**
     * 내가 생각한 방법 => 주어진 mat와 동일한 사이즈의 새로운 2D 배열을 만들고 90도 회전된 값을 셋팅한다.
     * 하지만 새로운 행렬을 생성하고 각 원소를 계산하여 할당하는 과정이 필요하기 때문에 작업량이 많고, 새로운 행렬을 생성함으로써 공간복잡도가 증가한다.
     * @param matrix
     * @return
     */
    private int[][] rotateMatrixReturnNewMatrix( int[][] matrix ) {
        int n = matrix.length;
        int[][] newMatrix = new int[ n ][ n ];

        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {
                newMatrix[ j ][ n - i - 1 ] = matrix[ i ][ j ];
            }
        }
        return newMatrix;
    }

    private boolean isEqual( int[][] mat, int[][] target ) {
        int n = mat.length;
        for ( int i = 0; i < n; i++ ) {
            for ( int j = 0; j < n; j++ ) {

                if ( mat[ i ][ j ] != target[ i ][ j ] ) return false;
            }
        }
        return true;
    }

    public static void main( String[] args ) {
        DetermineWetherMatrixCanBeObtainedByRotation_1886 obj = new DetermineWetherMatrixCanBeObtainedByRotation_1886();
        int[][] mat = new int[][]{ { 0, 0 }, { 0, 1 } }; // [[0,0,0],[0,0,1],[0,0,1]]
        int[][] target = new int[][]{ { 0, 0 }, { 1, 0 } };


        long startTime = System.nanoTime();
        System.out.println( obj.findRotation( mat, target ) );
        long endTime = System.nanoTime();
        System.out.println( "elapseTime : " + ( endTime - startTime ) ); // Arrays.deepEqualse() 883667, for loop 1071208

    }
}
