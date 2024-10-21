package lecture5.cafe.ConcreteDecorator;

import lecture5.cafe.Decorator.CondimentDecorator;
import lecture5.cafe.component.Beverage;

public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ",Mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.7;
    }
}
