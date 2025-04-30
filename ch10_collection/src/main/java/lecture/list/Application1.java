package lecture.list;

import java.time.LocalDateTime;
import java.util.*;

public class Application1 {
    public static void main(String[] args) {
        /*
        * 컬렉션 프레임워크 크게 3가지 인터페이스 중 한 가지를 상속받아 구현함
        *
        * List 인터페이스
        * - 순서가 있음, 중복 저장 허용
        * - Vector, ArrayList, LinkedList, Stack, Queue
        *
        * Set 인터페이스
        * - 순서 없음, 중복 불가
        * - HashSet, TreeSet
        *
        * Map 인터페이스
        * - 키와 값이 한 쌍으로 이루어진 데이터 집합 (순서X, 중복된 키 불가)
        * - HashMap, TreeMap, HashTable, Properties
         */

        // 가변적이고 요소의 추가수정삭제를 메소드로 제공해 줌
        ArrayList<Object> alist = new ArrayList<>();
        List<Object> list = new ArrayList<>(); // 다형성 적용

        // Object 타입으로 생성해서 다양한 타입의 값 넣을 수 있음
        list.add("apple");
        list.add(123);
        list.add(45.67);
        list.add(LocalDateTime.now());
        System.out.println(list);
        // 내부적으로 toString() 오버라이딩되어 있음
        System.out.println("list의 크기 : " + list.size());

        // add 로 값 추가
        list.add(1,"banana");
        System.out.println(list);
        // 추가할 때 기존에 있던 것 하나씩 밀려나고 그 자리에 들어감

        // set으로 값 변경 가능
        list.set(1,true);
        System.out.println(list);

        // remove로 값 제거
         list.remove(1);
        System.out.println(list);

        /*
        * LinkedList
        * - 저장한 요소가 순서를 유지하지 않고 저장됨
        * - 요소들 사이를 링크로 연결하여 구성해 마치 연결된 리스트처럼 만듦
        * - 요소의 저장과 삭제가 빈번히 일어날 때 성능면에서 ArrayList보다 우수
        */

        List<String> strList = new LinkedList<>();
        strList.add("c");
        strList.add("b");
        strList.add("a");
        strList.add("d");
        System.out.println(strList);

        // sort : 정렬
        Collections.sort(strList);
        System.out.println(strList);

        // reverse : 역순 정렬
        Collections.reverse(strList);
        System.out.println(strList);

        /*
        * Iterator (반복자)
        * -> Collection 인터페이스의 iterator() 메소드를 이용해서 생성 가능
        * -> 컬렉션에서 값을 읽어오는 방식을 통일된 방식으로 제공하기 위해 사용
        * - 인덱스가 없는 경우, 값을 하나하나 꺼내올 때 사용
        * */
        // strList
        Iterator<String> iterator = strList.iterator(); // Iterator 객체 생성

        /*
        * hasNext() : 다음 요소가 남아있으면 true 없으면 false
        * next() : 커서를 현재 요소의 다음 요소로 이동시키고 그 요소를 반환
         */
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
