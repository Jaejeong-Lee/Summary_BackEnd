package basic.ch18.sec03.exam03;

import java.io.*;

public class CopyExample {
    public static void main(String[] args) throws Exception {
        String originalFileName = "c:/Temp/test1.jpg";
        String targetFileName = "c:/Temp/test2.jpg";

        try(
                InputStream is = new FileInputStream(originalFileName);
                OutputStream os = new FileOutputStream(targetFileName);
            ){
            byte[] data = new byte[1024]; // 파일 바이트로 넣을 수 있는 공간 만들기
            while (true) {
                int num = is.read(data); // data 없으면 -1
                if (num == -1) break;
                os.write(data,0,num);
            }
            os.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
