package lecture6.pizzafactory;

import org.codehaus.groovy.transform.SourceURIASTTransformation;

public class PizzaTest {
    public static void main(String[] args) {
        PizzaStore nyStyle = new NYPizzaStore();
        PizzaStore chicagoStyle = new ChicagoPizzaStore();

        Pizza pizza = nyStyle.createPizza("cheese");
        System.out.println(pizza.getName());
        pizza.cut();
        pizza = chicagoStyle.createPizza("pepperoni");
        System.out.println(pizza.getName());
        pizza.cut();


        //dependent style. not factory pattern
        Pizza dependentPizza = new NYStyleCheesePizza();
        System.out.println(dependentPizza.getName());
        dependentPizza.cut();
    }
}
