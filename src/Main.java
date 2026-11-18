/**
 * Singleton 동작 확인용 실행 코드.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1. 동일 인스턴스 확인 ===");
        Singleton first = Singleton.getInstance();
        Singleton second = Singleton.getInstance();

        System.out.println("first  해시코드: " + System.identityHashCode(first));
        System.out.println("second 해시코드: " + System.identityHashCode(second));
        System.out.println("first == second : " + (first == second));

        System.out.println();
        System.out.println("=== 2. 상태 공유 확인 ===");
        System.out.println("변경 전 second.getCount() = " + second.getCount());
        first.increment();
        first.increment();
        first.increment();
        System.out.println("first.increment() 3회 호출");
        System.out.println("변경 후 second.getCount() = " + second.getCount());
    }
}
