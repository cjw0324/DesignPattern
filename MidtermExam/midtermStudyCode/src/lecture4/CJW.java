package lecture4;

public class CJW implements Observer{
    private String name;
    private double price;

    public CJW() {
        this.name = "cjw";
    }

    @Override
    public void update(double stockPrice, String item) {
        this.price = stockPrice;
        display(item);
    }

    public void display(String item) {
        System.out.println(name + " received updated" + item + " price : " + price);
    }
}
