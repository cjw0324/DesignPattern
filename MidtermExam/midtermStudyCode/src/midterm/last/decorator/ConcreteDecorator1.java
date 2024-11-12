package midterm.last.decorator;

public class ConcreteDecorator1 extends Decorator{
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    @Override
    public String getDescription() {
        return component.getDescription() + "and concrete decorator1";
    }

    @Override
    public int cost() {
        return component.cost() + 1;
    }
}
