package midterm.decorator;

public class MainHouse {
    public static void main(String[] args) {
        House studio = new StudioRoom();
        House apt = new Apartment();
        House under = new HalfUndergroundRoom();

        System.out.println(studio.getDescription()+ ", 가격 : "+ studio.cost());

        studio = new Window(studio);
        System.out.println(studio.getDescription()+ ", 가격 : "+ studio.cost());

        studio = new Window(studio);
        System.out.println(studio.getDescription()+ ", 가격 : "+ studio.cost());

        studio = new Room(studio);
        System.out.println(studio.getDescription()+ ", 가격 : "+ studio.cost());

        studio = new Floor(studio, 3);
        System.out.println(studio.getDescription()+ ", 가격 : "+ studio.cost());


        System.out.println(apt.getDescription() + ", 가격 : " + apt.cost());

        apt = new Floor(apt, 15);
        System.out.println(apt.getDescription() + ", 가격 : " + apt.cost());
        apt = new Room(apt);
        System.out.println(apt.getDescription() + ", 가격 : " + apt.cost());
        apt = new Room(apt);
        System.out.println(apt.getDescription() + ", 가격 : " + apt.cost());

        under = new Floor(under, 3);
        System.out.println(under.getDescription() + ", 가격 : " + under.cost());
    }
}
