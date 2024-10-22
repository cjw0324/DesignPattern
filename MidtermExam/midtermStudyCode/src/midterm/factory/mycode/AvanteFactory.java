package midterm.factory.mycode;

public class AvanteFactory extends Factory{
    public Car production(String option){
        Car car;
        ComponentFactory componentfactory = new AvanteComponentFactory();
        if(option.equals("no-option")){
            car = new AvanteNoOption(componentfactory);
            car.name = "깡통 아반떼";
        } else if(option.equals("full-option")){
            car = new AvanteFullOption(componentfactory);
            car.name = "풀옵 아반떼";
        } else{
            car = new AvanteNoOption(componentfactory);
            car.name = "일치하는 옵션이 없어 기본으로 선택된 아반떼";
        }
        return car;
    }

}