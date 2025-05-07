package basic.ch16.sec01;

public class CalculableImpl implements Calculable{
    @Override
    public void calculate(int x, int y) {
        System.out.println("인터페이스 구현 방법 : " + (x + y));
    }
}
