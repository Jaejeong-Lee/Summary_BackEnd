package basic.ch17.sec01;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

/*
* 스트림 : 컬렉션, 배열같이 자바에서 데이터 소스를 편하게 다루기 위한 문법
*
* 스트림 구조
* : 스트림 객체 -> 중간 연산 -> 최종 연산
*
* 스트림 특징
* 1. 원본데이터를 변경시키지 않는다.
* 2. 일회용이기 때문에 최종연산 이후에는 다시 스트림을 생성해야 한다.
* 3. 작업을 내부적으로 반복처리한다.
* 4. 병렬처리가 가능하다.
* */

public class StreamExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet< >();
        set.add("홍길동");
        set.add("신용권");
        set.add("감자바");

        // 기존 방식
        System.out.println("--------------향상된 for문 사용--------------");
        for(String str : set) {
            System.out.println(str);
        }

        /* Stream 사용 방식 */
        System.out.println("--------------Stream 사용--------------");
        Stream<String> setStream = set.stream();

        setStream.forEach(name -> System.out.println(name));

        // set안에도 forEach()는 내장되어 있음.
        set.forEach(name -> System.out.println(name));

        System.out.println("--------------Stream 사용2--------------");
        set.stream()
//                .sorted() // 사전순으로 정렬
                .sorted(Comparator.reverseOrder()) // 역순 정렬
                .limit(2) // 앞에서부터 크기만큼 자르기
                .forEach(name -> System.out.println(name));


    }
}
