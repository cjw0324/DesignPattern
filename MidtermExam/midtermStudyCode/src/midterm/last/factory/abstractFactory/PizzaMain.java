package midterm.last.factory.abstractFactory;

public class PizzaMain {
    public static void main(String[] args) {
        PizzaStore pizzaStore1 = new Store1();
        PizzaStore pizzaStore2 = new Store2();

        pizzaStore1.orderPizza(1);
        pizzaStore2.orderPizza(4);
    }
}
