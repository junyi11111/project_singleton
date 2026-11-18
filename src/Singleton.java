/**
 * Singleton 패턴 구현 클래스.
 * 프로그램 전체에서 단 하나의 인스턴스만 존재하도록 보장한다.
 */
public class Singleton {

    // 유일한 인스턴스를 보관하는 static 필드 (클래스에 하나만 존재)
    private static Singleton instance;

    // 공유 상태 확인용 카운터
    private int count = 0;

    // private 생성자: 외부에서 new Singleton() 으로 생성할 수 없게 막는다
    private Singleton() {
        System.out.println("[Singleton] 인스턴스 생성됨");
    }

    // 인스턴스를 요청하는 유일한 통로
    public static Singleton getInstance() {
        if (instance == null) {          // 처음 요청할 때만 생성
            instance = new Singleton();
        }
        return instance;                 // 이후에는 이미 만든 인스턴스를 반환
    }

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
