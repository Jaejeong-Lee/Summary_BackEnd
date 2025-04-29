package basic.lecture.extend.run;

import basic.lecture.extend.*;

public class Application {
    public static void main(String[] args) {
        /*
         * [Animal] (Interface)
         * ├── [Mammal] (implements Animal)
         * │       └── [Rabbit] (extends Mammal)
         * │              └── [Bunny] (extends Rabbit)
         * │                     └── [DrunkenBunny] (extends Bunny)
         * └── [Reptile] (implements Animal)
         *         └── [Snake] (extends Reptile)
         * */

        // 제네릭 클래스 작성 시 extends 키워드를 이용해서
        // 특정 타입만 제한을 걸 수 있다.
        // -> 특정 타입만 사용하도록 제한, 특정 타입 및 특정 타입의 자식 타입들도 대입 가능

        // Animal, Mammal, Snake 사용 불가능
        // Rabbit의 후손 or Rabbit 타입인 경우에만 사용 가능
//        RabbitFarm<Animal> farm1 = new RabbitFarm<Animal>();
//        RabbitFarm<Mammal> farm2 = new RabbitFarm<Mammal>();
//        RabbitFarm<Snake> farm3 = new RabbitFarm<Snake>();
        RabbitFarm<Rabbit> farm4 = new RabbitFarm<Rabbit>();
        RabbitFarm<Bunny> farm5 = new RabbitFarm<Bunny>();
        RabbitFarm<DrunkenBunny> farm6 = new RabbitFarm<DrunkenBunny>();

        // 컴파일 오류 발생
        // RabbitFarm이 Rabbit을 상속받았기 때문에
//        farm4.setAnimal(new Snake());
        farm4.setAnimal(new Rabbit());
//        farm5.setAnimal(new Rabbit()); // bunny보다 Rabbit이 상위라서
        farm4.getAnimal().cry();

        farm5.setAnimal(new Bunny());
        farm5.getAnimal().cry();

        farm6.setAnimal(new DrunkenBunny());
        farm6.getAnimal().cry();
    }
}