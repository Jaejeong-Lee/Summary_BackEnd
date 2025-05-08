package lecture.intermediate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Application3 {
    public static void main(String[] args) {
        /*
        * sorted(Comparator<>())
        * : 스트림에 담긴 데이터들을 정렬해서 반환
        * */

        List<Integer> integerList = IntStream.of(5,10,99,2,4,6)
                .boxed() // 각 정수를 Integer형태로 변환
//                .sorted()
                .sorted(Comparator.reverseOrder()) // 역순(내림차순) 정렬
                .toList(); // List형태로 변환

        System.out.println("integerList : " + integerList);

    }
}
