package midterm.decorator;

public class Window extends HouseOption{

    public Window(House house) {
        super(house);
    }

    @Override
    public String getDescription() {
        return house.getDescription() + ", 창문을 추가합니다";
    }

    @Override
    public double roomSize() {
        return house.roomSize();
    }

    @Override
    public double cost() {
        return house.cost() + 50;
    }
}
