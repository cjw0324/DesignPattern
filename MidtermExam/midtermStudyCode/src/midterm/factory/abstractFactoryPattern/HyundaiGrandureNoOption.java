package midterm.factory.abstractFactoryPattern;

public class HyundaiGrandureNoOption extends Car {
    CarComponentFactory carComponentFactory;
    public HyundaiGrandureNoOption(CarComponentFactory carComponentFactory) {
        this.carComponentFactory = carComponentFactory;
    }
    @Override
    public void prepare() {
        System.out.println("생산 준비 : " + name);
        engine = carComponentFactory.createEngine();
        seats = carComponentFactory.createSeat();
        maxSpeed = carComponentFactory.createMaxSpeed();
    }
}
