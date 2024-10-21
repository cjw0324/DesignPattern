package lecture4;

public class lec4MainTest {
    public static void main(String[] args){
        Stock stock = new Stock();
        Bitcoin bitcoin = new Bitcoin();
        Investor investor1 = new Investor("hello1");
        Investor investor2 = new Investor("hello2");
        CJW cjw1 = new CJW();
        CJW cjw2 = new CJW();

        stock.addObserver(investor1);
        stock.addObserver(investor2);
        stock.addObserver(cjw1);
        stock.addObserver(cjw2);

        bitcoin.addObserver(cjw1);
        bitcoin.addObserver(investor1);

        stock.setStockPrice(100.5);

        bitcoin.updateBitPrice(890304.23);

        stock.setStockPrice(55.1);

        bitcoin.updateBitPrice(9383.112);

        stock.removeObserver(investor2);
        stock.removeObserver(cjw2);

        stock.setStockPrice(158.9);


    }
}
