package basic.lecture.generic;

public class GenericTest<T> {
    /*
     * 제네릭 설정은 클래스 선언부 마지막 부분에 꺽쇠(다이아몬드 연산자)를 이용해 작성
     * 관례상 대문자 사용
     */

    private T value;
//    private T2 value; // T2 이런 식으로도 가능

    /* getter setter 구현 시에도 구체적인 타입 대신 T 사용 가능 */

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
