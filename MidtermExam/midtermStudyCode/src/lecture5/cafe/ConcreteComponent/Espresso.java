package lecture5.cafe.ConcreteComponent;

import lecture5.cafe.component.Beverage;

public class Espresso extends Beverage {
    @Override
    public String getDescription(){
        return "Espresso";
    }
    @Override
    public double cost(){
        return 2.0;
    }
}
