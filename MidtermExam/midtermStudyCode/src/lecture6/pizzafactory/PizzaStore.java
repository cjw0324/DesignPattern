package lecture6.pizzafactory;

public abstract class PizzaStore {
    abstract Pizza createPizza(String type);

    void prepareToBoxing(Pizza pizza) {
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type);
        prepareToBoxing(pizza);
        return pizza;
    }

}
