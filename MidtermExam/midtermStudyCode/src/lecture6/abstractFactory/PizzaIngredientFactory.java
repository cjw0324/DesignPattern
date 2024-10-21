package lecture6.abstractFactory;

public interface PizzaIngredientFactory {
    String createDough();

    String createSauce();

    String createCheese();

    String createPepperoni();
}
