package basic.ch16.sec01;

public class LambdaExample {
    public static void main(String[] args) {
        /*
        * 람다식
        * - 메서드를 하나의 식으로 표현해 익명함수를 생성하는 식
        * */

        /*
        * 인터페이스에 정의된 추상메서드 사용방법
        * 1. 인터페이스를 구현한 클래스를 정의하는 방법
        * 2. 익명클래스를 활용해서 메소드 정의 후 사용하는 방법 (잘 안 씀)
        * 3. 람다식 활용하는 방법
        * */

        // 1. 인터페이스 구현 방법
        CalculableImpl calculableImpl = new CalculableImpl();
        calculableImpl.calculate(5,3);

        // 2. 익명 클래스 정의 방법
        Calculable c1 = new Calculable() {
            @Override
            public void calculate(int x, int y) {
                System.out.println("익명클래스 사용 : " + (x + y));
            }
        };
        c1.calculate(5,3);

        // 3. 람다식 활용 방법
        // 인터페이스에 추상메서드가 하나만 존재해야 람다식 사용 가능.
        Calculable c2 = (x,y) -> {
            System.out.println("람다식 사용 : " + (x + y));
        };
        c2.calculate(5,3);

        action((x,y)->{
            int result = x + y;
            System.out.println("add result : " + result);
        });

        action((x,y)->{
            int result = x - y;
            System.out.println("minus result : " + result);
        });

    }

    public static void action(Calculable calculable) {
        // 데이터
        int x = 10;
        int y = 4;
        // 데이터 처리
        calculable.calculate(x,y);
    }
}
