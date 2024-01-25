package inflearn.ch01;

public class P6_Fruits {


    public int solution(int[][] fruit){
        int answer = 0;
        int students = fruit.length;
        int[] check = new int[students]; // 교환여부를 체크할 배열

        // 교환 학생
        for ( int i = 0; i < students; i++ ) {
            if ( check[ i ] == 1 ) continue;
            if ( !isMinUnique( fruit[ i ] ) ) continue;

            // 교환 대상 학생
            for ( int j = i + 1; j < students; j++ ) {
                if ( check[ j ] == 1 ) continue;
                if ( !isMinUnique( fruit[ j ] ) ) continue;

                int minFruitOfI = getMinIndex( fruit[ i ] );
                int minFruitOfJ = getMinIndex( fruit[ j ] );
                // 교환 조건: 최솟값 과일이 서로 같지 않아야 한다. && i가 교환으로 주려는 과일이 0보다 크다 && j가 교환으로 주려는 과일이 0보다 크다
                if ( minFruitOfI != minFruitOfJ && fruit[ i ][ minFruitOfJ ] > 0 && fruit[ j ][ minFruitOfI ] > 0 ) {

                    // 교환 조건: 교환 후에도 최솟값 과일이 유지되어야 한다
                    if( fruit[i][minFruitOfI] + 1 <= fruit[i][minFruitOfJ] - 1 &&
                        fruit[j][minFruitOfJ] + 1 <= fruit[j][minFruitOfI] - 1 // 여기 조심
                    ){
                        // 교환
                        fruit[i][minFruitOfI]++;
                        fruit[i][minFruitOfJ]--;
                        fruit[j][minFruitOfJ]++;
                        fruit[j][minFruitOfI]--;

                        // 교환했음을 체크
                        check[i] = 1;
                        check[j] = 1;
                        break;
                    }
                }
            }
        }

        for ( int[] x : fruit ) {
            answer += getMin( x );
        }

        return answer;
    }


    /**
     * 한 학생의 과일 바구니에서 최솟값 과일이 유일한지 확인한다. 유일하면 true 리턴
     * @param fruit
     * @return
     */
    public Boolean isMinUnique(int[] fruit) {
        int cnt = 0;
        int min = getMin( fruit );
        for ( int x : fruit ) {
            if ( x == min ) cnt++;
        }
        return cnt == 1;
    }

    /**
     * 과일 바구니 안에 가장 적은 과일의 갯수 리턴
     * @param fruit
     * @return
     */
    public int getMin(int[] fruit) {
        int min = 100;
        for ( int x : fruit ) {
            min = Math.min( min, x );
        }
        return min;
    }


    /**
     * 학생 바구니에서 최솟값에 해당하는 과일의 인덱스를 리턴 ( 0: 사과, 1: 배, 2: 귤 )
     * @param fruits
     * @return
     */
    public int getMinIndex(int[] fruit) {
        int min = getMin( fruit );
        for ( int i = 0; i < 3; i++ ) {
            if ( fruit[ i ] == min ) return i;
        }
        return 0;
    }

    public static void main( String[] args ) {
        P6_Fruits T = new P6_Fruits();

        System.out.println(T.solution(new int[][]{{10, 20, 30}, {12, 15, 20}, {20, 12, 15}, {15, 20, 10}, {10, 15, 10}}));
        System.out.println(T.solution(new int[][]{{10, 9, 11}, {15, 20, 25}}));
        System.out.println(T.solution(new int[][]{{0, 3, 27}, {20, 5, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}}));
        System.out.println(T.solution(new int[][]{{3, 7, 20}, {10, 15, 5}, {19, 5, 6}, {10, 10, 10}, {15, 10, 5}, {3, 7, 20}, {12, 12, 6}, {10, 20, 0}, {5, 10, 15}}));
    }

}
