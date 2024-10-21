package lecture5.cafe.ConcreteComponent;

import lecture5.cafe.component.Beverage;

public class HouseBlend extends Beverage {
    @Override
    public String getDescription() {
        return "HouseBlend";
    }

    @Override
    public double cost() {
        return 2.5;
    }
}
