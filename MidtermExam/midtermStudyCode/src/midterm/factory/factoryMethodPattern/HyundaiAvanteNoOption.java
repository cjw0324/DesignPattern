package midterm.factory.factoryMethodPattern;

public class HyundaiAvanteNoOption extends Car{
    public HyundaiAvanteNoOption() {
        name = "Avante";
        brand = "HYUNDAI";
        maxSpeed = 200;
        seats = 5;
        options.add("깡통차");
    }
}
