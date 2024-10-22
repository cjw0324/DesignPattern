package midterm.factory.factoryMethodPattern;

public class HyundaiGrandureFullOption extends Car {
    public HyundaiGrandureFullOption() {
        name = "Grandure";
        brand = "HYUNDAI";
        maxSpeed = 250;
        seats = 5;
        options.add("최고급 시트");
        options.add("자율주행 2단계");
        options.add("20인치 알루휠");
    }
}
