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

인스턴스는 `Singleton` 클래스의 `private static Singleton instance` 필드에 보관됩니다. static 필드는 객체마다 따로 생기지 않고 클래스에 하나만 있기 때문에, 프로그램 어디서 접근해도 같은 변수를 보게 됩니다. `getInstance()`는 `instance`가 `null`일 때 한 번만 객체를 만들고, 그 뒤로는 저장해 둔 객체를 그대로 반환합니다. 생성자가 `private`이라 외부에서 `new Singleton()`으로 새 객체를 만들 수도 없습니다. 실행 결과를 보면 "인스턴스 생성됨" 메시지가 한 번만 찍히고, 참조 비교 `first == second`가 `true`로 나오며, `first`로 증가시킨 카운터 값을 `second`에서 그대로 읽을 수 있습니다. 이 세 가지를 근거로 두 변수가 같은 인스턴스 하나를 공유한다는 것을 확인할 수 있습니다.
