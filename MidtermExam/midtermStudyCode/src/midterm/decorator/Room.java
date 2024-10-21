package midterm.decorator;

public class Room extends HouseOption{
    public Room(House house) {
        super(house);
    }

    @Override
    public String getDescription() {
        return house.getDescription() + " 방이 추가되었습니다";
    }

    @Override
    public double roomSize() {
        return house.roomSize() + 7;
    }

    @Override
    public double cost() {
        return house.cost() + 1000;
    }
}
