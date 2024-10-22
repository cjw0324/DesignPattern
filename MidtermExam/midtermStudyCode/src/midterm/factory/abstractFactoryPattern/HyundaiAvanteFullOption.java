package midterm.factory.abstractFactoryPattern;

public class HyundaiAvanteFullOption extends Car {
    CarComponentFactory carComponentFactory;
    public HyundaiAvanteFullOption(CarComponentFactory carComponentFactory) {
        this.carComponentFactory = carComponentFactory;
    }

    @Override
    public void prepare() {
        System.out.println("생산 준비 : " + name);
        System.out.println("생산 준비 :" + name);
        maxSpeed = carComponentFactory.createMaxSpeed();
        seats = carComponentFactory.createSeat();
        engine = carComponentFactory.createEngine();
        options.add(carComponentFactory.createOption1());
        options.add(carComponentFactory.createOption2());
    }
}
