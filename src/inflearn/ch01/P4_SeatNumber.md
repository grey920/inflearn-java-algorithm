## 문제

### 설명
세계 최고의 알고리즘 전문가인 현수의 강연을 보기위해 많은 사람들이 찾아왔습니다. 강연장에는 가로로 c개, 세로로 r개의 좌석이 c×r격자형태로 배치되어 있다. 각 좌석의 번호는 해당 격자의 좌표 (x,y)로 표시된다.  
아래 그림은 가로 6개, 세로 5개 좌석으로 구성된 6×5격자형 좌석배치입니다. 각 격자에 표시 된 (x,y)는 해당 좌석의 번호를 말합니다. 가장 왼쪽 아래의 좌석번호는 (1,1)이며, 가장 오른 쪽 위 좌석의 번호는 (6, 5)이다.
<img width="359" alt="image" src="https://github.com/grey920/grey920.github.io/assets/58028215/6ce0e082-4438-4a5e-9e9d-4e5738652d02">

사람들은 온 순서대로 (1,1)위치 좌석부터 시작하여 시계방향으로 돌아 들어가면서 빈 좌석에 앉습니다. 만약 5번째로 온 사람은 (1, 5)좌석에 앉고, 8번째로 온 사람은 (4, 5)좌석에 앉으 며, 12번째 온 사람은 (6, 3)좌석에, 20번째 온 사람은 (2, 3) 좌석에 앉게됩니다.

매개변수 c와 r에 강연장의 크기가 주어지면, k번째로 온 사람이 앉을 좌석번호를 반환하는 프 로그램을 작성하세요.  
만일 모든 좌석이 배정되어 k번째 온 사람이 앉을 좌석이 없을 경우 [0, 0]을 반환합니다.

#### 제약조건
- 5 ≤ c, r ≤ 1,000이다.
- 1 ≤ k ≤ 100,000,000이다.

### 입출력

| c | r | k | answer |
| ---- | ---- | ---- | ---- |
| 6 | 5 | 12 | [6,3] |
| 6 | 5 | 20 | [2,3] |
| 6 | 5 | 30 | [4,3] |
| 6 | 5 | 31 | [0,0] |

### 기본 코드
```java
import java.util.*;
class Solution {
	public int[] solution(int c, int r, int k){
		int[] answer = new int[2];
		
		return answer;
	}

	public static void main(String[] args){
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(6, 5, 12)));	
		System.out.println(Arrays.toString(T.solution(6, 5, 20)));
		System.out.println(Arrays.toString(T.solution(6, 5, 30)));
		System.out.println(Arrays.toString(T.solution(6, 5, 31)));
	}
}
```
---

## Step2. 접근방법
> - 좌표를 코드 구현이 쉽도록 90도 회전하자
> - 좌표 값에 앉은 사람 수를 넣기


## Step3. 코드 설계
1. 앉을 사람 k가 좌석보다 더 클 경우 -> 바로 [0,0] 리턴
2. c행 r열의 seat를 일단 0으로 초기화한다. 후에 사람을 앉히면 해당 좌표에 값을 넣을 예정
3. 방향키와 사람 카운트, 현재 좌표 x, y 셋팅
4. count가 k보다 작을때까지 계속 반복
    1. 다음 좌석의 좌표 nx, ny를 구한다
    2. 다음 좌석이 끝이거나, seat에서 값이 0이 아닌 경우(이미 누가 앉은 경우) 방향만 전환하고 continue;로 빠져나간다
    3. 정상적으로 앉을 수 있으면 seat로 현재 좌표에 값을 count로 설정하고 count 값을 증가시킨다.
    4. x, y를 nx, ny로 바꾼다. (이동)
5. 결과값인 answer에 x, y 좌표값에 각각 +1 한 값으로 넣어준다.

## Step4. 코드 구현
```java
package inflearn.ch01;  
  
import java.util.Arrays;  
  
public class P4_SitNumber {  
    public int[] solution(int c, int r, int k){  
        int[] answer = new int[2]; // k번째 사람이 앉을 좌표  
  
        if ( k > c * r ) return new int[] {0,0};  
  
        // c = 행, r = 열  
        // board 셋팅  
        int[][] seat = new int[c][r];  
        for( int i = 0; i < c; i ++ ) {  
            for ( int j = 0; j < r; j++ ) {  
                seat[i][j] = 0;  
            }  
        }  
  
        // 방향키 셋팅 -> 3시 방향 기본값  
        int[] dx = { -1, 0, 1, 0 }; // 12시, 3시, 6, 9  
        int[] dy = { 0, 1, 0, -1 }; // 12시, 3시, 6, 9  
        int d = 1, x = 0, y = 0, count = 1;  
  
        while( count < k ) {  
  
            // next  
            int nx = x + dx[d];  
            int ny = y + dy[d];  
  
            if ( nx >= c || nx < 0 || ny >= r || ny < 0 || seat[nx][ny] > 0 ) {  
                // 방향전환  
                d = ( d + 1 ) % 4;  
                continue;  
            }  
            seat[x][y] = count;  
            count++;  
            x = nx;  
            y = ny;  
        }  
  
        answer[0] = x + 1;  
        answer[1] = y + 1;  
  
        return answer;  
    }  
  
    public static void main(String[] args){  
        P4_SitNumber T = new P4_SitNumber();  
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));  
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));  
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));  
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));  
    }  
}
```

