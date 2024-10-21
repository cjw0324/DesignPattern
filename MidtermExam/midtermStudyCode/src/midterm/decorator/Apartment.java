package midterm.decorator;

public class Apartment extends House{
    @Override
    public String getDescription() {
        return "살기좋은 아파트 입니다";
    }

    @Override
    public double roomSize() {
        return 32;
    }

    @Override
    public double cost() {
        return 100000;
    }
}
