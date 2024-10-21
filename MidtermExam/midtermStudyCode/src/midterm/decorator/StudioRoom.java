package midterm.decorator;

public class StudioRoom extends House {
    @Override
    public String getDescription() {
        return "반지하 보다 살기 좋지만, 더 좁고, 더 비싼 원룸 입니다";
    }

    @Override
    public double roomSize() {
        return 7.5;
    }

    @Override
    public double cost() {
        return 1000;
    }
}
