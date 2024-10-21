package midterm.decorator;

public class Floor extends HouseOption{
    private int floor;

    public Floor(House house, int floor) {
        super(house);
        this.floor = floor;
    }
    @Override
    public String getDescription() {
        return house.getDescription() +", "+ Integer.toString(floor) + " 층 입니다.";
    }

    @Override
    public double roomSize() {
        return house.roomSize();
    }

    @Override
    public double cost() {
        // 데코레이터를 거쳐 원래 객체의 타입을 확인하는 재귀 메서드 호출
        if (isInstanceOf(house, Apartment.class)) {
            System.out.println("apt!");
            return house.cost() + floor * 100;
        } else if (isInstanceOf(house, StudioRoom.class)) {
            System.out.println("studio!");
            return house.cost() - floor * 50;
        } else if (isInstanceOf(house, HalfUndergroundRoom.class)) {
            System.out.println("반지하!");
            return house.cost();
        }
        System.out.println("none");
        return house.cost();
    }

    // 재귀적으로 내부 객체 타입을 확인하는 메서드
    private boolean isInstanceOf(House house, Class<?> clazz) {
        if (clazz.isInstance(house)) {
            return true;
        } else if (house instanceof HouseOption) {
            return isInstanceOf(((HouseOption) house).house, clazz);
        }
        return false;
    }
}
