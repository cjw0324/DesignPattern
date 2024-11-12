package midterm.last.factory.abstractFactory;

public class Pizza1 extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    public Pizza1(PizzaIngredientFactory pizzaIngredientFactory) {
        this.ingredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println(name +" pizza 1 입니다");
    }
}
