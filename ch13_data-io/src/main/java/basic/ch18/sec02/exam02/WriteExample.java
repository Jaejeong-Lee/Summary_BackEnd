package basic.ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExample {
    public static void main(String[] args) {
        try (FileOutputStream fos = new FileOutputStream("c:/Temp/test2.db")){
            byte[] array = {10,20,30};
            fos.write(array);
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
