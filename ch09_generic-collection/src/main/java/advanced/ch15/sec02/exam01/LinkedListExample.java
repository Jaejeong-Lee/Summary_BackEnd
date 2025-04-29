package advanced.ch15.sec02.exam01;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        List<Board> LinkedList = new LinkedList<>();
        LinkedList.add(new Board("subject1", "content1","writer1"));
        LinkedList.add(new Board("subject2", "content2","writer2"));
        LinkedList.add(new Board("subject3", "content3","writer3"));
        LinkedList.add(new Board("subject4", "content4","writer4"));
        LinkedList.add(new Board("subject5", "content5","writer5"));

        System.out.println("LinkedList 저장된 요소 개수 = " + LinkedList.size());

        System.out.println("3번째 데이터 = " + LinkedList.get(2).toString());

        LinkedList.remove(2);
        LinkedList.remove(2);

        for ( Board b : LinkedList ) {
            System.out.print(b.getSubject() + " ");
            System.out.print(b.getContent() + " ");
            System.out.println(b.getWriter());
        }

    }
}
