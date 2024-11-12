package midterm.last.decorator;

public class DecoratorMain {
    public static void main(String[] args) {
        Component component1 = new ConcreteComponent1();
        System.out.println(component1.getDescription() + "," + component1.cost());

        Component component = null;
        component = new ConcreteDecorator2(new ConcreteDecorator1(new ConcreteComponent1()));
        System.out.println(component.getDescription() + " , " + component.cost());


    }
}
