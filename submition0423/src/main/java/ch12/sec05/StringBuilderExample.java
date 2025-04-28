package ch12.sec05;

public class StringBuilderExample {
    public static void main(String[] args) {
        String data = new StringBuilder()
                .append("DEF")
                .insert(0,"ABC") // ABCDEF
                .delete(3,4) // D 삭제
                .toString(); // 문자열로 변환
        System.out.println(data); // ABCEF
    }
}
