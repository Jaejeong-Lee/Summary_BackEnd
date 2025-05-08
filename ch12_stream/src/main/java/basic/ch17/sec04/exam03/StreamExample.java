package basic.ch17.sec04.exam03;

import java.util.stream.IntStream;

public class StreamExample {
    public static int sum; //합계를 구하기 위한 변수

    /*
    * 순수함수와 부수 효과
    * - 순수함수 : 입력만으로 결과가 정해지고 외부 상태를 변경하지 않는 함수
    * - 부수효과 : 함수나 메서드가 리턴값 이외에 외부 상태를 변경하는 행위
    * */
    public static void main(String[] args) {
        // parallel() : 병렬처리
        IntStream stream = IntStream.range(1,100).parallel();
        // + range(start,end) : start 포함, end 미포함

        stream.forEach(i -> sum += i);

        System.out.println("총합 : "  + sum);
    }
}
