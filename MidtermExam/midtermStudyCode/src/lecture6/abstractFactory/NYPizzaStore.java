package lecture6.abstractFactory;

public class NYPizzaStore extends PizzaStore{
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (type.equals("cheese")) {
            pizza = new NYStyleCheesePizza(ingredientFactory);
            pizza.name = "NewYork style cheese pizza";
        } else if (type.equals("pepperoni")) {
            pizza = new NYStylePepperoniPizza(ingredientFactory);
            pizza.name = "NewYork style peperoni pizza";
        }
        return pizza;
    }
}
