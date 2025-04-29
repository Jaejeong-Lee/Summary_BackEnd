package advanced.ch15.sec02.exam01;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        ArrayList<Board> arrayList = new ArrayList<>();
        arrayList.add(new Board("subject1", "content1","writer1"));
        arrayList.add(new Board("subject2", "content2","writer2"));
        arrayList.add(new Board("subject3", "content3","writer3"));
        arrayList.add(new Board("subject4", "content4","writer4"));
        arrayList.add(new Board("subject5", "content5","writer5"));

        System.out.println("ArrayList 저장된 요소 개수 = " + arrayList.size());

        System.out.println("3번째 데이터 = " + arrayList.get(2).toString());

        arrayList.remove(2);
        arrayList.remove(2);

        for ( Board b : arrayList ) {
            System.out.print(b.getSubject() + " ");
            System.out.print(b.getContent() + " ");
            System.out.println(b.getWriter());
        }

    }
}
