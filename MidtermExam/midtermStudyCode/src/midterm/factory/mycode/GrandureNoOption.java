package midterm.factory.mycode;

public class GrandureNoOption extends Car{
    private ComponentFactory componentfactory;
    public GrandureNoOption(ComponentFactory componentfactory){
        this.componentfactory = componentfactory;
    }

    public void prepare(){
        System.out.println("생산 준비:"+name);
        engine = componentfactory.createEngine();
    }
}