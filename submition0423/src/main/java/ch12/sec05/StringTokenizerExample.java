package ch12.sec05;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        String data1 = "홍길동&이수홍,박연수";
        String[] arr = data1.split("&|,");

        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2,"/");

        System.out.println(Arrays.toString(arr));
        while (st.hasMoreTokens()){
            System.out.print(st.nextToken()+" ");
        }
    }
}
