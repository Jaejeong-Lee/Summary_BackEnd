package advanced.ch17.sec06.exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FlatMappingExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList< >();
        list1.add("this is java");
        list1.add("i am a best developer");
        //문장 스트림을 단어 스트림으로 변환 후 출력
        list1.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .forEach(word -> System.out.println(word));

        System.out.println();
        //초기 방법
//        Arrays.stream(list1.get(0).split(" "))
//                .forEach(word -> System.out.println(word));
//        Arrays.stream(list1.get(1).split(" "))
//                .forEach(word -> System.out.println(word));


        List<String> list2 = Arrays.asList("10, 20, 30", "40, 50");
        //문자열 숫자 목록 스트림을 숫자 스트림으로 변환 후 출력
        list2.stream()
                .flatMapToInt(str -> {
                    String[] strArr = str.split(",");
                    int[] intArr = new int[strArr.length];
                    for (int i = 0; i < strArr.length; i++) {
                        intArr[i] = Integer.parseInt(strArr[i].trim());
                    }
                    // .flatMap()을 활용하여 겹친 배열 등을 하나로 합칠 수 있음.
                    // 실행하는 구문을 여러줄 돌릴 수 있음.
                    // 즉, for문도 사용 가능
                    return Arrays.stream(intArr);
                    // return 값도 설정해줄 수 있음.
                })
                .forEach(num -> System.out.println(num));
    }
}
