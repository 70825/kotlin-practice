# java-chess

체스 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)



### 프로그램 동작 순서

1. 체스 게임 시작 문구를 출력한다
2. 사용자는 start 명령을 입력한다 
   - 초기화된 체스판을 출력한다
3. 게임을 진행한다
   - 사용자는 `move source target` 명령어로 체스말을 이동시킬 수 있다
     - 변화한 체스판을 출력한다
   - 사용자는 `status` 명령어로 현재 남아있는 말에 대한 점수를 구할 수 있어야 한다.
5. 사용자는 end 명령을 입력하거나, 어느 팀이든 `King` 체스말이 잡히면 게임을 종료한다.

### 기능 목록 구현
- [x] 참여자
  - [x] 참여자는 이름을 가지고 있다
  - [x] 이름을 DB에 기록한다
- [x] 위치
    - [x] file(열)과 rank(행)를 갖는다
- [x] 방향
  - [x] 상하좌우, 대각선, 나이트의 단위 이동 방향을 갖는다
  - [x] 단위 이동 방향을 구할 수 있다
- [x] 체스말
    - [x] 팀을 갖는다
    - [x] 체스말은 Rook, Knight, Bishop, King, Queen, Pawn을 갖는다
    - [x] 체스말이 없는 곳은 Empty를 갖는다
    - [x] 킹
      - [x] 모든 방향으로 한 칸만 이동할 수 있다
    - [x] 퀸
      - [x] 모든 방향으로 이동할 수 있다
    - [x] 비숍
      - [x] 대각선으로 이동할 수 있다
    - [x] 나이트
      - [x] 상하좌우 한 칸 후 대각선 한 칸만 이동할 수 있다
    - [x] 룩
      - [x] 상하좌우로 이동할 수 있다
    - [x] 폰
      - [x] 앞으로 한 칸만 이동할 수 있다
      - [x] 처음 이동 시 두 칸 이하로 이동할 수 있다
      - [x] 대각선으로 공격할 수 있다
- [x] 체스판
    - [x] 위치와 체스말을 갖는다
    - [x] 체스말을 이동시킬 수 있다
      - [x] 체스말을 이동시킬 수 있는지 확인한다
        - [x] 출발지와 목적지가 다른지 검증한다
        - [x] 출발지가 비어있는지 검증한다
        - [x] 출발지에 같은 팀이 있는지 검증한다
        - [x] 현재 턴에 맞는 체스말을 움직이는지 검증한다
        - [x] 체스말의 이동 규칙이 맞는지 검증한다
        - [x] 출발지와 목적지 사이의 경로에 다른 체스말이 있는지 검증한다
      - [x] 체스말을 이동한다
- [x] 체스 게임
  - [x] 체스판을 가지고 있다
  - [x] 체스말을 이동시킬 수 있다
- [x] 체스판 청사진
    - [x] 체스판을 빈 공간으로 채운다
    - [x] 체스판에 검은말을 채운다
    - [x] 체스판에 흰말을 채운다
- [x] 체스방
  - [x] 참여자의 이름이 저장된 체스방을 불러온다
    - [x] 참여자의 이름이 저장된 체스방이 존재하지 않으면 새로 생성한다
- [x] 커맨드
  - [x] 커맨드 목록은 start, move, status, end가 있다 
  - [x] 커맨드가 start, move, status, end인지 확인한다
    - [x] move일 경우 `move 출발지 도착지` 형식인지 확인한다
    - [x] 커맨드에 맞는 동작을 실행한다
- [x] 데이터베이스
  - [x] 체스판
    - [x] 체스판을 새로 생성한다
    - [x] 이미 존재하는 체스판을 불러온다
    - [x] 체스말의 움직임으로 인해 바뀐 체스판의 모습을 업데이트한다
  - [x] 체스 게임
    - [x] 체스 게임을 새로 생성한다
    - [x] 이미 존재하는 체스 게임을 불러온다
  - [x] 플레이어
    - [x] 플레이어를 새로 생성한다
    - [x] 이미 존재하는 플레이어를 불러온다
  - [x] 체스방
    - [x] 체스방을 새로 생성한다
    - [x] 이미 존재하는 체스방을 불러온다
  - [x] 체스 이동 기록
    - [x] 체스 이동을 기록한다
- [x] 뷰
  - [x] 입력
    - [x] 참여자 이름을 입력한다.
    - [x] 명령어를 입력한다(start, move, status, end)
  - [x] 출력
    - [x] 체스판을 출력한다
    - [x] 점수를 출력한다
