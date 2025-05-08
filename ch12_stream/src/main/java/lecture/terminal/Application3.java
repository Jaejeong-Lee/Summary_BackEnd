package lecture.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application3 {
    public static void main(String[] args) {
        /*
         * collect()
         * - Collector 타입을 받아서 처리를 하는데, 메소드를 통해 컬렉션을 출력으로 받을 수 있다.
         * - Collector 객체에서 제공하는 정적 메소드를 사용 가능
         * */

        List<Member> memberList = Arrays.asList(
                new Member("test01","testName01"),
                new Member("test02","testName02"),
                new Member("test03","testName03")
        );

        List<String> collector = memberList
                .stream()
                .map(m -> m.getMemberName())
                .toList();
        System.out.println("collector = " + collector);

        String str = memberList
                .stream()
                .map(m->m.getMemberName())
                .collect(Collectors.joining());
        //.collect(Collectors.joining()) 모든 이름을 구분자없이 하나의 문자열로 결합

        System.out.println("str = " + str);

        String str2 = memberList
                .stream()
                .map(m -> m.getMemberName())
                .collect(Collectors.joining(" || ","*시작* "," *끝*"));

        System.out.println("str2 = " + str2);
    }
}
