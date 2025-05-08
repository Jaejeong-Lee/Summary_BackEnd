package lecture.terminal;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Application2 {
    public static void main(String[] args) {
        /*
         * reduce() : 스트림에 있는 데이터들의 총합을 계산
         * */

        OptionalInt reduceOneParam = IntStream.range(1, 4)
                .reduce((a, b) -> {
                    return Integer.sum(a, b);
                });
        System.out.println("reduceOneParam = " + reduceOneParam);

        int reduceTwoParam = IntStream.range(1, 4)
                // 100을 기준으로 1,2,3을 더해줌
                .reduce(100, (a, b) -> {
                    return Integer.sum(a, b);
                });
        System.out.println("reduceTwoParam = " + reduceTwoParam);
    }
}
