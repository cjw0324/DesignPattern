package midterm.last.factory.factoryMethod;

public class PizzaMain {
    public static void main(String[] args) {
        PizzaStore store1 = new Store1();
        PizzaStore store2 = new Store2();

        Pizza pizza1 = store1.orderPizza("1");
        Pizza pizza2 = store1.orderPizza("2");
        Pizza pizza3 = store2.orderPizza("3");
        Pizza pizza4 = store2.orderPizza("4");

        pizza1.prepare();
        pizza1.making();
        pizza1.boxing();
    }
}
