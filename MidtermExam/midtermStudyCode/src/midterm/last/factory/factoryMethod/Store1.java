package midterm.last.factory.factoryMethod;

public class Store1 extends PizzaStore {

    @Override
    public Pizza makePizza(String option) {
        if (option.equals("1")) {
            return new Pizza1();
        } else if (option.equals("2")) {
            return new Pizza2();
        } else {
            return null;
        }
    }
}
