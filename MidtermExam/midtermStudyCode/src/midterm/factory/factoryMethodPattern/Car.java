package midterm.factory.factoryMethodPattern;
import java.util.*;
public abstract class Car {
    String name;
    String brand;
    int maxSpeed;
    int seats;
    ArrayList<Object> options = new ArrayList<>();

    void prepare(){
        System.out.println(brand +" 자동차 생산 준비 " + name);
        System.out.println("최대 속력 : " + maxSpeed);
        System.out.println( seats +" 인승");
        System.out.println(getOptionsToString());
    }

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

//    public String getName() {
//        return name;
//    }

    public String getDescription() {
        return brand + "의 " + name + ", " + seats + "옵션 : " + getOptionsToString() + " maxSpeed : " + maxSpeed;
    }
}
