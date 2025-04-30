package lecture.map;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Application1 {
    public static void main(String[] args) {
        /*
        * Map
        * -> Collection 인터페이스들과는 다른 저장방식
        * key, value 쌍으로 저장하는 방식
        *
        * key란?
        * - 값을 찾기 위한 이름 역할의 객체
        * - 키는 중복을 허용하지 않음, 키가 다르면 중복되는 값은 저장 가능
        * */

        // 반드시 제네릭 타입 명시해서 사용해야 함.
        HashMap<String, String> hMap = new HashMap<>();

        hMap.put("one", "java8");
        hMap.put("two", "oracle");
        hMap.put("three", "jdbc");
        hMap.put("four", "html5");
        hMap.put("five", "css3");
//        hMap.put("five", "css"); // 키는 중복저장 X, 최큰 키의 value로 덮어씌워짐.

        System.out.println("hMap : " + hMap);

        // 삭제
        hMap.remove("one");
        System.out.println("hMap : " + hMap);

        // getOrDefault(key, DefaultValue)
        // 지정한 키가 맵에 없을 때 기본값을 반환, 있을 떈 해당 키의 value를 반환
        System.out.println( "getOrDefault 테스트 : "+ hMap.getOrDefault("two","기본값"));
        System.out.println( "getOrDefault 테스트 : "+ hMap.getOrDefault("ten","기본값"));


        /* Iterator로 key value 출력 */
        System.out.println("===============Set을 이용해 Iterator로 변환=================");

        // keySet() : map에 저장된 모든 key를 Set 형태로 반환
        Set<String> keys = hMap.keySet();

        // iterator() => iterator 객체 반환
        Iterator<String> keyIter = keys.iterator();
        while (keyIter.hasNext()){
            String key = keyIter.next();

            // key값으로 value 꺼냄
            String value = hMap.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println("===============Set을 이용해 forEach로 변환=================");
        for (String key : keys) {
            String value = hMap.get(key);
            System.out.println(key + " = " + value);
        }

        System.out.println("===============Map 내부의 EntrySet 이용=================");
        // entrySet() : Map에 저장된 key와 value 쌍을 Set 형태로 "뷰"로 반환
        // -> 이때 반환된 Set은 Map이랑 연결되어 있어서 추가,수정,삭제를 하면 원본에도 반영
        // Set<Map.Entry<K,V>> set = map.entrySet(); 이렇게 호출
        Set<Map.Entry<String,String>> set = hMap.entrySet();

        Iterator<Map.Entry<String,String>> entryIter = set.iterator();
        while (entryIter.hasNext()){
            Map.Entry<String,String> entry = entryIter.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }


    }
}
