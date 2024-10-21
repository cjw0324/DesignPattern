package lecture6.abstractFactory;

public class AbstractPizzaTest {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza nyCheese = nyStore.orderPizza("cheese");
        Pizza chPepperoni = chicagoStore.orderPizza("pepperoni");

        System.out.println(nyCheese.getName());
        System.out.println(chPepperoni.getName());
    }
}
