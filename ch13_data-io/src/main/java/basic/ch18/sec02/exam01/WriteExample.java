package basic.ch18.sec02.exam01;

import java.io.*;

public class WriteExample {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("c:/Temp/test1.db")){
            byte a = 10;
            byte b = 20;
            byte c = 30;

            writer.write(a);
            writer.write(b);
            writer.write(c);

            writer.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
