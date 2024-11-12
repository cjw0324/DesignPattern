package midterm.last.factory.abstractFactory;

public class Pizza4 extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    public Pizza4(PizzaIngredientFactory pizzaIngredientFactory) {
        this.ingredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println(name +" pizza 4 입니다");
    }
}
