package midterm.factory.mycode;

public class GrandureFullOption extends Car{
    private ComponentFactory componentfactory;
    public GrandureFullOption(ComponentFactory componentfactory){
        this.componentfactory = componentfactory;
    }
    public void prepare(){
        System.out.println("생산 준비:"+name);
        engine = componentfactory.createEngine();
        options.add(componentfactory.createOption1());
        options.add(componentfactory.createOption2());
    }
}