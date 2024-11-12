package midterm.last.factory.abstractFactory;

public class Store2 extends PizzaStore{
    @Override
    public Pizza createPizza(int option) {
        PizzaIngredientFactory ingredientFactory = new Store2IngredientFactory();
        Pizza pizza;
        if (option == 3) {
            pizza = new Pizza3(ingredientFactory);
            pizza.name = "p3";
        } else {
            pizza = new Pizza4(ingredientFactory);
            pizza.name = "p4";
        }
        return pizza;
    }
}
