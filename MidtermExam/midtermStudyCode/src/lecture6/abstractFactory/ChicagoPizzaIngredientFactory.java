package lecture6.abstractFactory;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory{
    @Override
    public String createDough() {
        return "Thick Crust Dough";
    }
    @Override
    public String createSauce() {
        return "Plum Tomato Sauce";
    }
    @Override
    public String createCheese() {
        return "Mozzarella Cheese";
    }
    @Override
    public String createPepperoni() {
        return "chicago style pepperoni";
    }
}
