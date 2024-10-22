package midterm.factory.factoryMethodPattern;

import java.util.*;
public class HyundaiStore {
    public static void main(String[] args) {
        HyundaiFactory avanteFactory = new AvanteFactory();
        HyundaiFactory grandureFactory = new GrandureFactory();

        ArrayList<Car> Cars = new ArrayList<>();

        Cars.add(avanteFactory.orderCar("no-option"));
        Cars.add(avanteFactory.orderCar("full-option"));

        Cars.add(grandureFactory.orderCar("full-option"));
        Cars.add(grandureFactory.orderCar("no-option"));

        for (Car car : Cars) {
            System.out.println(car.getDescription());
        }

    }
}
