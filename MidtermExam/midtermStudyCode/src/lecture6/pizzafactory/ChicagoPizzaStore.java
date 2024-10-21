package lecture6.pizzafactory;

public class ChicagoPizzaStore extends PizzaStore{
    @Override
    Pizza createPizza(String type) {
        if (type.equals("cheese")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStyleCheesePizza();
        } else {
            return new ChicagoStyleCheesePizza();
        }
    }
}
