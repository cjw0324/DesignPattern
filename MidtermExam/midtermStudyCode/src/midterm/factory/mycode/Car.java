package midterm.factory.mycode;
import java.util.*;
public abstract class Car{
    String name;
    String engine;
    ArrayList<Object> options = new ArrayList<>();

    abstract void prepare();

    void engine(){
        System.out.println("엔진 조립중...");
    }
    void test(){
        System.out.println("테스트 진행 중...");
    }

    public String getDescription(){
        String option = "";
        for (Object o : options) {
            option += o.toString() + " ";

        }
        return name + ", 엔진 : " + engine + "옵션 : " + option;
    }
}
