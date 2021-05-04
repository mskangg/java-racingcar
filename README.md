# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## Todo List - 기능 목록 구현

##### 유틸성 클래스

1. 자동차 이름은 쉼표(,)를 기준으로 구분한다.
   * 쉼표(,)를 기준으로 구분지어 String 배열을 구해라
2. 사용자는 몇번의 이동을 할 것인지를 입력할 수 있어야한다.
   * 입력받은 값이 자연수인가?
3. 0-9 사이의 랜덤 값 생성
   * 최소값과 최대값을 매개변수로 받아서 구현
   * 랜덤인가?

##### 비즈니스 클래스

1. 전진하는 조건은 4 이상일 경우 전진하고, 3 이하일 경우 멈추는 원시 클래스 구현
   * 숫자를 입력받아 판단
2. 자동차 이름 원시 클래스 구현
   - 이름이 5자 이하인가?
3. 자동차 이동 거리 원시 클래스 구현
   - 이동거리를 출력메세지로 리턴하는가?
4. 실행결과를 일급컬렉션으로 구현
   * 일급컬렉션에서 우승자 정하기
   * 출력하기
5. GameOptions 상수 클래스 구현
   * 전진 or 정지 정하는 기준
   * 최소 랜덤값
   * 최대 랜덤값
   * 자동차 이름 최대 길이
   * 이동거리 출력 글자

##### 서비스 클래스

1. Game 인터페이스 구현하여 의존성 제어 역전
2. 비즈니스 로직을 호출하는 트랜잭션 코드 작성
   * 자동차 이름 입력
   * 자동차를 관리하는 일급컬렉션 생성
   * 몇 번을 진행할지 입력
   * 입력받은 횟수 만큼 게임 진행
   * 승리자들 출력

##### UI 클래스

1. Game을 구현한 RacingCarGame을 주입하여 게임 진행

## 실행 결과

```
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
볼트싼타페,니로하이브리드
자동차 이름은 5글자 이하여야만 합니다.
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
볼트
입력시 (,)를 최소 1번 이상 입력하셔야 합니다.
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
볼트,싼타페,니로,테슬라
시도할 회수는 몇회인가요?
구십회
숫자만 입력해주세요.
시도할 회수는 몇회인가요?
5

실행 결과
볼트: 
싼타페: -
니로: 
테슬라: 

볼트: -
싼타페: --
니로: -
테슬라: 

볼트: --
싼타페: --
니로: -
테슬라: -

볼트: --
싼타페: --
니로: -
테슬라: -

볼트: ---
싼타페: ---
니로: -
테슬라: --

볼트, 싼타페 승리하였습니다.
```

