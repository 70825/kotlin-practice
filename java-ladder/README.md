# java-ladder

사다리 타기 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 개요

해당 저장소는 사다리 생성을 구현한 저장소입니다. `n`명의 사람 이름과 높이 `m`을 입력하면 사다리가 생성됩니다.

## 세부사항

플레이어

- 플레이어는 여러 명 존재할 수 있다.
  - [x] [제한사항] 플레이어는 2명 이상, 10명 이하만 가능하다.
  - [x] [제한사항] 플레이어의 이름은 중복될 수 없다.
- 플레이어는 이름을 가집니다.
  - [x] [제한사항] 이름은 영문자만 가능하다.
  - [x] [제한사항] 이름은 최대 5글자까지 가능하다.
  - [x] 이름의 앞, 뒤 공백은 제거한다.
- [x] 사다리 게임이 끝난 후, 플레이어가 어디에 있는지 알 수 있다.

상품

- 상품은 여러 개 존재할 수 있다.
  - [x] [제한사항] 상품의 개수는 플레이어의 수와 같다.
- 상품은 이름을 가진다.
  - [x] [제한사항] 이름은 꽝 혹은 숫자만 가능하다.
  - [x] [제한사항] 이름은 최대 5글자까지 가능하다.
  - [x] 상품의 앞, 뒤 공백은 제거한다.
- [x] 특정 위치에 있는 선물을 가져올 수 있다.

점

- [x] 수평 위치, 수직 위치를 가진다.
- [x] 수직으로 한 칸 내려갈 수 있다.
- [x] 방향에 따라 수평으로 이동할 수 있다.

방향

- [x] 왼쪽, 오른쪽, 정지를 가진다.
- [x] 값에 알맞은 방향을 반환한다.

선

- [x] 방향들의 집합이다.

사다리

- [x] 선들의 집합이다.
- [x] 높이는 2이상, 10이하만 가능합니다.

방향 생성

- [x] 랜덤 방향을 생성한다.

선 생성

- [x] 방향 생성 전략에 따라 선을 생성한다.

실행 결과

- [x] 실행 결과는 이름 목록을 가진다.
  - [x] [제한사항] 모든 플레이어, 특정 플레이어를 입력해야한다.

입력

- [x] 참여할 플레이어들의 이름을 입력한다.
- [x] 실행 결과를 입력한다.
- [x] 최대 사다리 높이를 입력한다.
- [x] 검색 명령어를 입력한다.

출력

- [x] 사다리 생성 결과를 출력한다.
  - [x] 참여한 플레이어의 이름을 출력한다.
  - [x] 사다리를 출력한다.
  - [x] 실행 결과를 출력한다.
- [x] 입력 받은 특정 플레이어 또는 모든 플레이어의 결과를 출력한다.