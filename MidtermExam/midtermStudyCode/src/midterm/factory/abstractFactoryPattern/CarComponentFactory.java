package midterm.factory.abstractFactoryPattern;

public interface CarComponentFactory {
    String createEngine();

    String createSeat();

    String createMaxSpeed();

    String createOption1();

    String createOption2();
}
