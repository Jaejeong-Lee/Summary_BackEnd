package basic.ch18.sec06;

import java.io.*;

public class CharacterConvertStreamExample {
    // OutputStreamWriter
    // - 문자를 바이트로 변환(인코딩)해 출력하는 문자 스트림
    // - 내부적으로 OutputStream 사용함.
    // - 생성자에서 인코딩 타입을 지정할 수 있음.

    // InputStreamReader
    // - 바이트를 문자로 디코딩하여 읽는 문자 스트림
    // - 내부적으로 InputStream 사용함
    // - 생성자에서 디코딩 지정 가능


    public static void main(String[] args) {
        String str = "문자 변환 스트림을 사용합니다.";

        try {
            write(str);

            String data = read();
            System.out.println("data : " + data);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    // 문자열을 파일에 저장하는 메서드
    public static void write(String str) throws Exception{

        Writer writer = new OutputStreamWriter(
                new FileOutputStream("test2.txt"),"UTF-8");
        writer.write(str);
        writer.close();

    }

    // 파일에서 문자열을 읽어오는 메서드
    public static String read() throws Exception {
        Reader reader = new InputStreamReader(new FileInputStream("test2.txt"),"UTF-8");

        char[] data = new char[100];

        // 읽은 문자 개수를 num에 저장
        int num = reader.read(data);

        reader.close();

        // offset(여기서 0자리) : 배열에서 문자열로 변환할 위치
        // num : 시작위치부터 몇 개의 바이트를 변환할 것인지
        String str = new String(data, 0 , num); // String 생성자 사용한 것임.

        return str;
    }
}
