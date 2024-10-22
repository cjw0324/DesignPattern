package midterm.factory.abstractFactoryPattern;

public class HyundaiAvanteNoOption extends Car {
    CarComponentFactory carComponentFactory;

    public HyundaiAvanteNoOption(CarComponentFactory carComponentFactory) {
        this.carComponentFactory = carComponentFactory;
    }

    @Override
    public void prepare() {
        System.out.println("생산 준비 :" + name);
        maxSpeed = carComponentFactory.createMaxSpeed();
        seats = carComponentFactory.createSeat();
        engine = carComponentFactory.createEngine();
    }
}
