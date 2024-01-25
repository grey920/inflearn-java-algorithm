## 문제
과일 가져가기

### 설명
현수네 반에는 1번부터 n번까지 학생번호를 가진 n명의 학생이 있습니다.
모든 학생의 책상에는 사과, 배, 귤이 담긴 A, B, C 세 바구니가 놓여 있습니다.
A바구니는 사과만 담고, B바구니는 배만 담고, C바구니는 귤만 담습니다.
각 학생은 책상에 있는 세 바구니 중 하나를 가질 수 있습니다. 단 이 세 바구니 중 가장 적게 과일이 담겨있는 바구니를 가집니다.
예를 들어 현수의 책상에 14, 17, 14개가 각각 바구니에 담겨 있다면 현수는 사과(14개) 또는 귤(14개) 중 하나를 가져갑니다. 즉 현수는 14개의 과일을 가져가는 것입니다.
모든 학생은 딱 한 번 바구니의 과일 한 개를 다른 학생과 교환할 수 있는 기회가 있습니다. 교환하는 규칙은 다음과 같습니다.
1) 1번 학생부터 번호 순으로 교환을 할 건지 결정합니다.
2) 교환을 하는 양쪽 학생이 서로 이득이 되면 무조건 교환을 합니다. 즉 양쪽이 모두 가져가 는 과일의 개수가 원래 가져가려고 했던 것보다 증가한다면 교환을 무조건 합니다.
3) 교환을 할 때는 A바구니는 사과만, B바구니에는 배만, C바구니에는 귤만 담아야 합니다.
4) 교환 가능한 학생이 여러명일 경우 가장 번호가 작은 학생과 교환합니다.
5) 서로가 이득이 생기는 경우가 존재하지 않으면 교환하지 않는 학생도 있습니다.

매개변수 fruit 에 1번 학생부터 n번 학생까지의 A, B, C 세 바구니에 들어있는 과일의 개수 정보가 주어지면 모든 교환이 끝난 후 모든 학생이 가져가는 과일의 총 개수를 반환하는 프로 그램을 작성하세요.

#### 제약조건
- fruit 의 길이는 10,000을 넘지 않습니다. 즉 n은 10,000을 넘지 않습니다.
- 각 바구니에 담기는 과일이 개수는 0부터 50개 까지입니다. (0 <= 과일개수 <= 50)

### 입출력
| fruit | answer|
|-------| ---- |
| [[10, 20, 30], [12, 15, 20], [20, 12, 15], [15, 20, 10], [10, 15, 10]] | 58 |
| [[10, 9, 11], [15, 20, 25]] | 24 |
| [[0, 3, 27], [20, 5, 5], [19, 5, 6], [10, 10, 10], [15, 10, 5], [3, 7, 20]] | 32 |
| [[3, 7, 20], [10, 15, 5], [19, 5, 6], [10, 10, 10], [15, 10, 5], [3, 7, 20], [12, 12, 6], [10, 20, 0], [5, 10, 15]] | 48 |

- 입력예제 1 설명 :
  1번 학생은 3번 학생과 사과를 받고 배를 주는 교환을 해서 1번 학생은 [11, 19, 30], 3번 학 생은 [19, 13, 15]로 변한다. 즉 1번 학생은 최소값이 10에서 11로 증가하고, 3번 학생은 최 소값이 12에서 13으로 증가한다. 2번 학생은 4번 학생과 사과를 받고 귤을 주는 교환하여 2 번 학생은 [13, 15, 19], 4번 학생은 [14, 20, 11]이 된다. 5번 학생은 교환을 할 학생이 없 다.
  모든 학생이 가져가는 과일의 총 개수는 11 + 13 + 13 + 11 + 10 = 58입니다.