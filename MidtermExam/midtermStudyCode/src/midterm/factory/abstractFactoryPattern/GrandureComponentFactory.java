package midterm.factory.abstractFactoryPattern;

public class GrandureComponentFactory implements CarComponentFactory{

    @Override
    public String createEngine() {
        return "V6 엔진";
    }

    @Override
    public String createSeat() {
        return "5인승";
    }

    @Override
    public String createMaxSpeed() {
        return "250km/h";
    }

    @Override
    public String createOption1() {
        return "차선 유지, 주행 보조 및 자율주행 2단계";
    }

    @Override
    public String createOption2() {
        return "스포츠 패키지 옵션";
    }
}
