package midterm.factory.abstractFactoryPattern;

public class AvanteComponentFactory implements CarComponentFactory{
    @Override
    public String createEngine() {
        return "직렬 4기통";
    }

    @Override
    public String createSeat() {
        return "5인승";
    }

    @Override
    public String createMaxSpeed() {
        return "200km/h";
    }

    @Override
    public String createOption1() {
        return "아반떼 주행 보조 옵션";
    }

    @Override
    public String createOption2() {
        return "실내 외 인테리어 옵션";
    }
}
