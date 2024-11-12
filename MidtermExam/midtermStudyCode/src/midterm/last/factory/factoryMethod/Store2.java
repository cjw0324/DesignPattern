package midterm.last.factory.factoryMethod;

public class Store2 extends PizzaStore{
    @Override
    public Pizza makePizza(String option) {
        if (option.equals("3")) {
            return new Pizza3();
        } else if (option.equals("4")) {
            return new Pizza4();
        } else {
            return null;
        }
    }
}
