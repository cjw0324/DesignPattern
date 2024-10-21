package midterm.decorator;

public abstract class HouseOption extends House {
    protected House house;

    public HouseOption(House house) {
        this.house = house;
    }
}
