package midterm.factory.factoryMethodPattern;

public abstract class HyundaiFactory {
    abstract Car productionCar(String option);

    void prepareToRelease(Car car) {
        car.prepare();
        car.engine();
        car.welding();
        car.test();
        System.out.println("생산 완료 : "+ car.getDescription());
    }

    public Car orderCar(String option) {
        Car car = productionCar(option);
        prepareToRelease(car);
        return car;
    }
}
