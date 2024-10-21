package lecture6.abstractFactory;

public class ChicagoPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new ChicagoPizzaIngredientFactory();
        if (type.equals("cheese")) {
            pizza = new ChicagoStyleCheesePizza(ingredientFactory);
            pizza.name = "Chicago style cheese pizza";
        } else if (type.equals("pepperoni")) {
            pizza = new ChicagoStylePepperoniPizza(ingredientFactory);
            pizza.name = "Chicago style pepperoni pizza";
        }
        return pizza;
    }
}
