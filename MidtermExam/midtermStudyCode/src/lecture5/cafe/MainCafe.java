package lecture5.cafe;

import lecture5.cafe.ConcreteComponent.Espresso;
import lecture5.cafe.ConcreteComponent.HouseBlend;
import lecture5.cafe.ConcreteDecorator.Milk;
import lecture5.cafe.component.Beverage;

public class MainCafe {
    public static void main(String[] args){
        Beverage espresso = new Espresso();
        Beverage houseBlend = new HouseBlend();

        espresso = new Milk(espresso);
        System.out.println(espresso.getDescription());
        System.out.println(espresso.cost());

        espresso = new Milk(espresso);
        System.out.println(espresso.getDescription());
        System.out.println(espresso.cost());

        houseBlend = new Milk(houseBlend);
        System.out.println(houseBlend.getDescription());
        System.out.println(houseBlend.cost());
    }
}
