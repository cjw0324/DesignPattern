package lecture6.abstractFactory;

import java.util.*;

public abstract class Pizza {
    String name;
    String dough;
    String sauce;
    String cheese;
    String pepperoni;
    ArrayList<String> toppings = new ArrayList<>();

    abstract void prepare();
    void bake() {
        System.out.println("Baking for 25 minutes at 350 degrees.");
    }

    void cut() {
        System.out.println("Cutting the pizza into diagonal slices.");
    }

    void box() {
        System.out.println("Place pizza in official PizzaStore box.");
    }

    public String getName() {
        return name;
    }
}
