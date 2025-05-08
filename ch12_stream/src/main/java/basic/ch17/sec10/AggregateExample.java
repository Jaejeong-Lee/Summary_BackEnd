package basic.ch17.sec10;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AggregateExample {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        // 2의 배수 카운팅
        long count = Arrays.stream(arr)
                .filter(i -> (i % 2)==0)
                .count();
        System.out.println("2의 배수 개수 : " + count);

        // 2의 배수 총합
        long sum = Arrays.stream(arr)
                .filter(i -> (i % 2)==0)
                .sum();
        System.out.println("2의 배수의 합 : " + sum);

        // 2의 배수 평균
        double average = Arrays.stream(arr)
                .filter(i -> (i % 2)==0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수의 평균 : " + average);

        // 2의 배수 중 최대값
        int max = Arrays.stream(arr)
                .filter(i -> (i % 2)==0)
                .max()
                .orElse(0);
        System.out.println("최대값 : " + max);

        // 2의 배수 중 최소값
        int min = Arrays.stream(arr)
                .filter(i -> (i % 2)==0)
                .min()
                .orElse(0);
        System.out.println("최대값 : " + min);

        // 첫 번째 3의 배수
        int answer = Arrays.stream(arr)
                .filter(i -> (i % 3)==0)
                .min()
                .orElse(0);
        System.out.println("첫 번째 3의 배수 : " + answer);
    }
}
