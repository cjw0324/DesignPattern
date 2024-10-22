package midterm.factory.factoryMethodPattern;

public class HyundaiAvanteFullOption extends Car {
    public HyundaiAvanteFullOption() {
        this.name = "Avante";
        this.brand = "HYUNDAI";
        maxSpeed = 230;
        seats = 5;
        this.options.add("전방 추돌 경고");
        options.add("차선 유지 보조");
        options.add("N 스타일");
    }
}
