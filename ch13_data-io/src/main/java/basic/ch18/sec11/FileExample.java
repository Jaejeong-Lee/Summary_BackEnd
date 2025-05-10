package basic.ch18.sec11;

import java.io.File;

public class FileExample {
    public static void main(String[] args) {
        File file1 = new File("c:/Temp/file1.txt");

        try {
            // 파일 존재 여부 판별
            if (file1.exists()) {
                System.out.println("파일이 존재합니다.");
            }
            if (file1.isFile()) {
                System.out.println("파일 경로 : " + file1.getPath());
                System.out.println("파일 크기 : " + file1.length());
            } else if (file1.isDirectory()) {
                System.out.println("<dir>> 파일 경로 : " + file1.getPath());
            } else {
                System.out.println("해당 파일은 없는 파일입니다.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
