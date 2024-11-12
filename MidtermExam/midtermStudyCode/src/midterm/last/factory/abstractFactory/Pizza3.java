package midterm.last.factory.abstractFactory;

public class Pizza3 extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    public Pizza3(PizzaIngredientFactory pizzaIngredientFactory) {
        this.ingredientFactory = pizzaIngredientFactory;
    }

    @Override
    void prepare() {
        System.out.println(name +" pizza 3 입니다");
    }
}
