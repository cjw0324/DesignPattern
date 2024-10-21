package lecture5.cafe.Decorator;

import lecture5.cafe.component.Beverage;

public abstract class CondimentDecorator extends Beverage {
    protected Beverage beverage;

    public CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}
