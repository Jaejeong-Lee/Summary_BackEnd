package lecture.intermediate;

import java.util.stream.IntStream;

public class Application2 {
    public static void main(String[] args) {
        /*
        * map : 스트림에 들어있는 데이터를 특정 람다식을 통해 각각의 데이터를 가공하고
        *       새로운 스트림에 담아준다.
        * */

        IntStream intStream = IntStream.range(1,10);

        intStream.filter(i -> ( i % 2 )==0) //2,4,6,8
                .map(i-> i*5) // 각 5를 곱해서 새로운 스트림에 담음
                .forEach(i -> System.out.print(i + " "));

    }
}
