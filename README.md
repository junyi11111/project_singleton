# Singleton 패턴 구현 (Java)

초급프로젝트 11주차 실습: Singleton 패턴을 구현하고, 여러 참조가 하나의 인스턴스를 공유하는지 실행 결과로 확인합니다.

## 개발 언어 및 실행 환경

- 언어: Java
- JDK: OpenJDK 27 (Homebrew)
- OS: macOS

## 파일 구성

| 파일 | 설명 |
|------|------|
| `src/Singleton.java` | Singleton 클래스 (static 인스턴스 보관, private 생성자, `getInstance()`, 카운터 상태) |
| `src/Main.java` | 동일 인스턴스 비교와 상태 공유를 확인하는 실행 코드 |

## 실행 방법

```bash
javac -d out src/*.java
java -cp out Main
```

## 실행 결과

```
=== 1. 동일 인스턴스 확인 ===
[Singleton] 인스턴스 생성됨
first  해시코드: 2060468723
second 해시코드: 2060468723
first == second : true

=== 2. 상태 공유 확인 ===
변경 전 second.getCount() = 0
first.increment() 3회 호출
변경 후 second.getCount() = 3
```

※ 해시코드 값은 실행할 때마다 달라질 수 있지만, 두 값은 항상 같게 나옵니다.

## 설명

Singleton 객체는 클래스 안의 `private static` 변수인 `instance`에 저장해 두었다. static 변수라서 몇 번을 요청하든 클래스에 딱 하나만 있다. `getInstance()`를 처음 호출할 때만 `instance`가 비어 있어서 객체가 만들어지고, 그다음부터는 이미 저장된 객체를 그대로 돌려주기 때문에 새로 생기지 않는다. 생성자도 private으로 막아 놔서 밖에서 `new`로 만들려고 하면 컴파일이 안 된다. 실제로 실행해 보니 생성 메시지가 한 번만 나오고 `first == second`가 true였고, first로 카운터를 3 올린 뒤 second로 읽어도 3이 나와서 둘이 같은 객체라는 걸 확인할 수 있었다.
