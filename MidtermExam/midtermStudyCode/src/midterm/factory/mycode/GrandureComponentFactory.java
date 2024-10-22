package midterm.factory.mycode;

public class GrandureComponentFactory implements ComponentFactory{
    public String createEngine(){
        return "V6";
    }

    public String createOption1(){
        return "자율 주행";
    }

    public String createOption2(){
        return "블랙 익스테리어 패키지";
    }
}

