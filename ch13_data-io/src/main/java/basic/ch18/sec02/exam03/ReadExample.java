package basic.ch18.sec02.exam03;

import java.io.FileInputStream;
import java.io.FileWriter;

public class ReadExample {
    public static void main(String[] args) {
        try (
                FileInputStream fis = new FileInputStream("c:/Temp/test1.db")
        ){
            byte[] data = new byte[fis.available()];
            // .available() : 파일 크기 값 반환
            fis.read(data);

            String content = new String(data);
            System.out.println("\"파일 내용 :" + content + '"');

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
