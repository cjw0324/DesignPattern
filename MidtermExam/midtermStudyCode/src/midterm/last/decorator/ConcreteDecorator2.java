package midterm.last.decorator;

public class ConcreteDecorator2 extends Decorator{

    public ConcreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public String getDescription() {
        return component.getDescription() + " and concrete decorator 2";
    }

    @Override
    public int cost() {
        return component.cost() + 2;
    }
}
