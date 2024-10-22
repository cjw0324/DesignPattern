package midterm.factory.factoryMethodPattern;

public class HyundaiGrandureNoOption extends Car {
    public HyundaiGrandureNoOption() {
        name = "Grandure";
        brand = "HYUNDAI";
        maxSpeed = 250;
        seats = 5;
        options.add("깡통차");
    }
}
