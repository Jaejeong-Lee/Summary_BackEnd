package lecture.functionalInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Example01 {
    public static void main(String[] args) {
        // 원본 숫자 리스트
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Predicate<Integer> 정의: 짝수인지 검사
        Predicate<Integer> isEven = n -> n % 2 == 0;

        // 스트림으로 짝수만 필터링
        List<Integer> evenNumbers = numbers.stream()
                .filter(isEven)
                .toList();

        // 결과 출력
        System.out.println("짝수: " + evenNumbers);  // 짝수: [2, 4, 6]
    }
}
