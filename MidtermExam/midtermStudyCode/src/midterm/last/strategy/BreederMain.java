package midterm.last.strategy;

public class BreederMain {

    public static void main(String[] args) {
        Breeder breeder1 = new Breeder(new Siamese());
        Breeder breeder2 = new Breeder(new BritishShortHair());
        System.out.println(breeder1.introduce().whoAmI());
        System.out.println(breeder2.introduce().whoAmI());
    }




}
