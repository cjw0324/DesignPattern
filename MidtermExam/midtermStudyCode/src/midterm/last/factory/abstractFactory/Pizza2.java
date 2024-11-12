package midterm.last.factory.abstractFactory;

public class Pizza2 extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    public Pizza2(PizzaIngredientFactory pizzaIngredientFactory) {
        this.ingredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println(name +" pizza 2 입니다");
    }
}
