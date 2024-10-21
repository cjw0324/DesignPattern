package lecture6.abstractFactory;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public String createDough() {
        return "Thin Crust Dough";
    }
    @Override
    public String createSauce() {
        return "Marinara Sauce";
    }
    @Override
    public String createCheese() {
        return "Reggiano Cheese";
    }
    @Override
    public String createPepperoni() {
        return "ny style Pepperoni";
    }
}
