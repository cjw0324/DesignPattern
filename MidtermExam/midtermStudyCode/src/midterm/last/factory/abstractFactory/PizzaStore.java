package midterm.last.factory.abstractFactory;

public abstract class PizzaStore {
    abstract Pizza createPizza(int option);

    public void makePizza(Pizza pizza) {
        pizza.prepare();
    }

    public Pizza orderPizza(int option) {
        Pizza pizza = createPizza(option);
        makePizza(pizza);
        return pizza;
    }
}
