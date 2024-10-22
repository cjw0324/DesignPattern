package midterm.factory.abstractFactoryPattern;

import java.util.ArrayList;
public abstract class Car {
    String name;
    String engine;
    String maxSpeed;
    String seats;
    ArrayList<Object> options = new ArrayList<>();

    //abstract factory pattern 에서 달라지는 부분.
    abstract void prepare();


    private String getOptionsToString() {
        String res = "";
        for (Object option : options) {
            res += option.toString()+" ";
        }
        return res;
    }

    void engine() {
        System.out.println("엔진 설치 중 ...");
    }
    void welding() {
        System.out.println("용접 중 ...");
    }
    void test() {
        System.out.println("테스트 주행 중 ...");
    }



    public String getDescription() {
        return name + ", " + seats + "인승, 옵션 : " + getOptionsToString() + ", maxSpeed : " + maxSpeed;
    }
}
