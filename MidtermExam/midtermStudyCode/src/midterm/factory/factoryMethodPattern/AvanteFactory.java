package midterm.factory.factoryMethodPattern;

public class AvanteFactory extends HyundaiFactory{
    @Override
    Car productionCar(String option) {
        Car car;
        if (option.equals("no-option")) {
            car = new HyundaiAvanteNoOption();
        } else if (option.equals("full-option")) {
            car = new HyundaiAvanteFullOption();

        } else {
            car = new HyundaiAvanteNoOption();
        }
        System.out.println("생산 준비 : "+car.getDescription());
        return car;
    }
}
