package midterm.decorator;

public class HalfUndergroundRoom extends House{
    @Override
    public String getDescription() {
        return "원룸보다 넓지만 습한 반지하 방 입니다";
    }
    @Override
    public double roomSize() {
        return 15;
    }

    @Override
    public double cost() {
        return 500;
    }
}
