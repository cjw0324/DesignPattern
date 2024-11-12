package midterm.last.factory.abstractFactory;

public class Store1IngredientFactory implements PizzaIngredientFactory{
    @Override
    public String createName() {
        return "store1 공장 재료 추가";
    }
}
