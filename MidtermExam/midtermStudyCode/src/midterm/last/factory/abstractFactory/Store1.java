package midterm.last.factory.abstractFactory;

public class Store1 extends PizzaStore{
    @Override
    Pizza createPizza(int option) {
        PizzaIngredientFactory ingredientFactory = new Store1IngredientFactory();
        Pizza pizza;
        if (option == 1) {
            pizza = new Pizza1(ingredientFactory);
            pizza.name = "p1";
        } else {
            pizza = new Pizza2(ingredientFactory);
            pizza.name = "p2";
        }
        return pizza;
    }
}
