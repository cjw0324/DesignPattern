package lecture5.cafe.ConcreteDecorator;

import lecture5.cafe.Decorator.CondimentDecorator;
import lecture5.cafe.component.Beverage;

public class Milk extends CondimentDecorator {


    public Milk(Beverage beverage) {
        super(beverage);
    }


    @Override
    public String getDescription() {
        return beverage.getDescription() +",Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}
