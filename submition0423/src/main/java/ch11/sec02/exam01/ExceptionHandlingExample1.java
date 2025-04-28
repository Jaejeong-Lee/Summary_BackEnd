package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        try {
            int result = data.length();
            System.out.println("문자 수 : " + result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
//            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        // data가 존재하지 않는데 길이를 변수에 정의하려고 해서 문제 발생.
        System.out.println("[프로그램 종료]");
    }
}
