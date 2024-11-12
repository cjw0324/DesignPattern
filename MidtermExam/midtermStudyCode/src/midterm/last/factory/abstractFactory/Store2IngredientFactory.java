package midterm.last.factory.abstractFactory;

public class Store2IngredientFactory implements PizzaIngredientFactory{
    @Override
    public String createName() {
        return "store2 공장 재료 추가";
    }
}
