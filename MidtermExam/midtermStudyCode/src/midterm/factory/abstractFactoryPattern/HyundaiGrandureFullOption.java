package midterm.factory.abstractFactoryPattern;

public class HyundaiGrandureFullOption extends Car {
    CarComponentFactory carComponentFactory;
    public HyundaiGrandureFullOption(CarComponentFactory carComponentFactory) {
        this.carComponentFactory = carComponentFactory;
    }

    @Override
    public void prepare() {
        System.out.println("생산 준비 : " + name);
        engine = carComponentFactory.createEngine();
        seats = carComponentFactory.createSeat();
        maxSpeed = carComponentFactory.createMaxSpeed();
        options.add(carComponentFactory.createOption1());
        options.add(carComponentFactory.createOption2());
    }
}
