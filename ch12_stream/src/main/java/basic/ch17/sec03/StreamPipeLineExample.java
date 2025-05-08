package basic.ch17.sec03;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeLineExample {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("홍길동",10),
                new Student("신용권",20),
                new Student("유미선",30)
        );

        // 1. 단계별로 변수에 담아 처리

        // 1-1) List<Student> -> Stream<Student> 로 변환
        Stream<Student> studentStream = list.stream();

        // 1-2) Student의 score만 추출
        IntStream scoreStream = studentStream
                .mapToInt(s -> s.getScore());

        // Stream은 일회성임
        // studentStream을 이미 한번 사용해서 더이상 사용할 수 없음.
        // IntStream scoreStream2 = studentStream.mapToInt(s -> s.getScore());

        // 1-3) 평균을 계산 (average() 하고 Optional에서 double값을 꺼냄)
        double avg1 = scoreStream
                .average() // 평균을 계산, OptionalDouble 반환
                // Optional(없을 경우에 대한 예외 처리)
                .orElseThrow(() -> new IllegalStateException("점수가 없음"));
                // 실무에서는 orElse()보다는 이걸 주로 사용
                // 예외 발생시킴!
        System.out.println("평균 점수 : " + avg1);

        // 파이프라인스타일 (체이닝)
        double avg2 = list.stream()
                .mapToInt(s -> s.getScore())
                .average()
                .orElse(0.0);

        System.out.println("평균 점수 = "+avg2);

        /* Stream끼리 합치기 */
        Stream<Student> studentStream1 = list.stream();
        Stream<Student> studentStream2 = Stream.of(
                new Student("세종",40),
                new Student("광종",30)
        );

        Stream<Student> concatStudent = Stream.concat(studentStream1,studentStream2);
        concatStudent.forEach(student -> System.out.println(student));

    }
}
