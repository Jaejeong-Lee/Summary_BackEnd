package ch12.sec04;

public class MeasureRunTimeExample {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int sum =0;
        for ( int i =1;i<=1000000 ; i++){
            sum +=i;
        }

        long finish = System.nanoTime();

        long time = finish - start;

        System.out.println("total sum = " + sum);
        System.out.println("소요시간 =" + time+" nano sec");
    }
}
