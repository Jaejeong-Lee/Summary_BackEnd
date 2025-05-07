package basic.ch16.sec02.exam01;

public class LambdaExample {
    public static void main(String[] args) {
        Person person = new Person();

        /*
        * 전략 패턴
        * - 동작 방식을 자유롭게 바꾸고 싶을 때 사용
        * - Context -> Person
        * - Interface -> Workable (추상 메서드 work)
        * - Concrete Strategy -> 실제 구현체
        * */

        // 실행문이 두 개 이상인 경우 중괄호 필요
        person.action(() -> {
            System.out.println("출근을 합니다.");
            System.out.println("프로그래밍을 합니다.");
        });

        //실행문이 한 개일 경우 중괄호 생략 가능
        person.action(() -> System.out.println("퇴근을 합니다."));
    }
}
