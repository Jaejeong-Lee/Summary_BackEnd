package ch12.sec08;

import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarExample {
    public static void main(String[] args) {
        Date now = new Date();

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 M월 dd일");
        SimpleDateFormat sdf2 = new SimpleDateFormat("E요일 a");
        SimpleDateFormat sdf3 = new SimpleDateFormat("HH시 M분 s초");

        System.out.println(sdf1.format(now));
        System.out.println(sdf2.format(now));
        System.out.println(sdf3.format(now));

    }
}
