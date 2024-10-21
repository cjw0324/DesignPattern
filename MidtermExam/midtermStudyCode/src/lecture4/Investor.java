package lecture4;

public class Investor implements Observer{
    private String name;
    private double stockPrice;

    public Investor(String name){
        this.name = name;
    }


    @Override
    public void update(double stockPrice, String item) {
        this.stockPrice = stockPrice;
        display(item);

    }

    public void display(String item) {
        System.out.println(name + " received updated" + item + " price : " + stockPrice);
    }
}
