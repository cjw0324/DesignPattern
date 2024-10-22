package midterm.factory.abstractFactoryPattern;

public class GrandureFactory extends HyundaiFactory {
    @Override
    Car productionCar(String option) {
        Car car;
        CarComponentFactory carComponentFactory = new GrandureComponentFactory();
        if (option.equals("no-option")) {
            car = new HyundaiGrandureNoOption(carComponentFactory);
            car.name = "깡통 그랜저";
        } else if (option.equals("full-option")) {
            car = new HyundaiGrandureFullOption(carComponentFactory);
            car.name = "풀옵션 그랜저";
        } else {
            car = new HyundaiAvanteNoOption(carComponentFactory);
            car.name = "해당하는 옵션이 없어 기본 옵션만 탑제한 그랜저";
        }
        System.out.println("생산 준비 : "+car.getDescription());
        return car;
    }
}
