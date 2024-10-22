package midterm.factory.mycode;

public class GrandureFactory extends Factory{
    public Car production(String option){
        Car car;
        ComponentFactory componentfactory = new GrandureComponentFactory();
        if(option.equals("no-option")){
            car = new GrandureNoOption(componentfactory);
            car.name = "깡통 그랜저";
        } else if(option.equals("full-option")){
            car = new GrandureFullOption(componentfactory);
            car.name = "풀옵 그랜저";
        } else{
            car = new GrandureNoOption(componentfactory);
            car.name = "일치하는 옵션이 없어 기본으로 선택된 그랜저";
        }
        return car;
    }

}