package midterm.factory.mycode;

public class myCarTest {
    public static void main(String[] args) {
        Factory avanteFactory = new AvanteFactory();
        Factory grandureFactory = new GrandureFactory();

        System.out.println(avanteFactory.orderCar("no-option").getDescription());
        System.out.println(grandureFactory.orderCar("full-option").getDescription());
    }
}
