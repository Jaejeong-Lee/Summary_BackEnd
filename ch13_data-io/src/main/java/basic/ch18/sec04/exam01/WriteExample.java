package basic.ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/*
* Writer
* - 문자 기반 출력 스트림의 최상위 추상클래스
* - 2바이트 단위로 처리
* - 주로 FileWriter, OutputStreamWriter 등을 사용
* */
public class WriteExample {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("test.txt")){
            char a = 'A';
            char b = 'B';
            char[] arr = {'C','D','E'};

            writer.write(a);
            writer.write(b);
            writer.write(arr);
            // 결과 : ABCDE로 txt파일에 들어감.
            // 줄바꿈 하고 싶으면 이스케이프문 사용
            // : '\n' 같은 것 추가.
            // char[] arr = {'C','D', '\n','E'};

            // 안 써도 close() 호출될 때 자동으로 호출됨.
            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
