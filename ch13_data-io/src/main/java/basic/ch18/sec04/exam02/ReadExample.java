package basic.ch18.sec04.exam02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
* Read
* - 문자 기반 입력 스트림의 최상위 추상 클래스
* - 2바이트 단위로 읽음
* - 주로 FileReader, InputStreamReader 사용
* */
public class ReadExample {
    public static void main(String[] args) {
        try {
            Reader reader = new FileReader("test.txt");

            while (true) {
                int data = reader.read();
                // 마지막까지 다 읽으면 -1 return
                if (data == -1) break;

                System.out.println("data = " + data);
            }
            reader.close();
            System.out.println();

            // 문자 배열로 읽기
            reader = new FileReader("test.txt");
            char[] data = new char[100];
            while (true) {
                int num = reader.read(data);
                if (num == -1) break;

                for (int i = 0; i < num; i++) {
                    System.out.println("data : " + data[i]);
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

        }
    }
}
