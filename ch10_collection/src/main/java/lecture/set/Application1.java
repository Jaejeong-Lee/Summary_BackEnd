package lecture.set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {
        /*
        * set 인터페이스 구현
        * - 요소의 저장 순서를 유지하지 않음
        * - 같은 요소의 중복 저장을 허용하지 않음 (null값도 중복 X)
        * */

        HashSet<String> hset = new HashSet<>();
        Set<String> set = new HashSet<>();

        // 저장 순서 유지 X
        hset.add("java");
        hset.add("mysql");
        hset.add("jdbc");
        hset.add("html");
        hset.add("css");

        System.out.println("hset : "+ hset); // 순서 뒤죽박죽임.

        // add()
        hset.add("java");
        System.out.println("hset : " + hset); // 중복 저장 X
        System.out.println("저장된 객체 수 : " + hset.size());

        // contains()
        System.out.println("oracle 포함 확인 : " + hset.contains("oracle"));
        System.out.println("java 포함 확인 : " + hset.contains("java"));

        // 출력 - 반복문 사용
        for (String str : hset){
            System.out.print("hset 요소 출력 : " + str + " ");
        }
        System.out.println();

        // toArray() : 배열로 바꾸고 for문 사용 가능
        Object[] arr = hset.toArray();

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " : " + arr[i]);
        }

        // remove() : 제거 후 결과 boolean 타입으로 반환
        Boolean result = hset.remove("java"); // true
        Boolean result2 = hset.remove("Oracle"); // false
        System.out.println("result : " + result);
        System.out.println("hset : " + hset);

        // clear()
        hset.clear();
        System.out.println("hset : " + hset);

        // isEmpty()
        System.out.println("hset isEmpty? : " + hset.isEmpty());



    }
}
