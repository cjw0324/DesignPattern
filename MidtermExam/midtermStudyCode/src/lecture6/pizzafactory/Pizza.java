package lecture6.pizzafactory;

import java.util.*;
public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    ArrayList toppings = new ArrayList();

    void prepare() {
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce");
        for (Object topping : toppings) {
            System.out.println(topping.toString());
        }
    }

    void bake() {
        System.out.println("Baek for 25 minutes at 30");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices");
    }

    void box() {
        System.out.println("Place pizza in official Pizza Store Box");
    }

    public String getName() {
        return name;
    }
}
