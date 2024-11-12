package midterm.last.factory.factoryMethod;

public abstract class PizzaStore {
    abstract Pizza makePizza(String option);

    public Pizza orderPizza(String option) {
        Pizza pizza = makePizza(option);
        return pizza;
    }
}
