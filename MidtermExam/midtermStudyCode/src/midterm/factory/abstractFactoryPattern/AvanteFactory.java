package midterm.factory.abstractFactoryPattern;

public class AvanteFactory extends HyundaiFactory {
    @Override
    public Car productionCar(String option) {
        Car car;
        CarComponentFactory carComponentFactory = new AvanteComponentFactory();
        if (option.equals("no-option")) {
            car = new HyundaiAvanteNoOption(carComponentFactory);
            car.name = "깡통 아반떼";
        } else if (option.equals("full-option")) {
            car = new HyundaiAvanteFullOption(carComponentFactory);
            car.name = "풀옵션 아반떼";

        } else {
            car = new HyundaiAvanteNoOption(carComponentFactory);
            car.name = "해당하는 옵션이 없어 기본 옵션만 탑제한 아반떼";
        }
        System.out.println("생산 준비 : "+car.getDescription());
        return car;
    }
}
