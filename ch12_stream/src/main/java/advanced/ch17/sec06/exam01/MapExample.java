package advanced.ch17.sec06.exam01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MapExample {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("홍길동", 85));
        studentList.add(new Student("홍길동", 92));
        studentList.add(new Student("홍길동", 87));

        //Student 스트림을 score 스트림으로 변환하여 요소 출력
        Stream<Integer> scoreStream = studentList.stream()
                .mapToInt(student -> student.getScore())
                .boxed();
        scoreStream.forEach(v -> System.out.println(v));

    }
}
