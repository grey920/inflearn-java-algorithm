## 문제
최대길이 바이토닉 수열

### 설명
바이토닉 수열이란 수열이 증가했다가 감소하는 수열을 의미합니다. <br>
예를 들어 1, 2, 3, 2, 1과 같이 증가했다가 감소하면 바이토닉 수열이라고 합니다.<br> 
하지만 1, 2, 3, 4, 5와 같이 증가만 하거나, 5, 4, 3, 2, 1처럼 감소만 하면 바이토닉 수열이라 하지 않습니다.<br> 
또 1, 2, 2, 3, 2, 1처럼 같은 값이 이웃해도 바이토닉 수열이라 하지 않습니다.<br> 
매개변수 nums에 길이가 n인 수열이 주어지면 이 수열의 연속부분수열 중 가장 긴 바이토닉 수열을 찾아 그 길이를 반환하는 프로그램을 작성하세요.<br>
만약 [1, 3, 2, 5, 7, 4, 2, 5, 1]수열이 주어지면 이 수열의 연속부분수열 중 가장 긴 바이토 닉 수열은 [2, 5, 7, 4, 2]이고, 답은 5입니다.

#### 제약조건
- nums의 길이 3 <= n <= 10,000
- 배열 nums의 원소는 자연수입니다.

### 입출력
| nums  | answer |
|-------| ---- |
| [1, 3, 2, 5, 7, 4, 2, 5, 1] | 5 |
| [1, 1, 2, 3, 5, 7, 4, 3, 1, 2] | 8|
| [3, 2, 1, 3, 2, 4, 6, 7, 3, 1] | 6|
|[1, 3, 1, 2, 1, 5, 3, 2, 1, 1] | 5|
