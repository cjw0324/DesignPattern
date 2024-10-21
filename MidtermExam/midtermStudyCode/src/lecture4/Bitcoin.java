package lecture4;
import java.util.*;
public class Bitcoin implements Subject{
    List<Observer> bitObserver;
    private double bitPrice;

    public Bitcoin(){
        bitObserver = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer){
        bitObserver.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        bitObserver.remove(observer);
    }


    @Override
    public void notifyObservers(){
        for (Observer observer : bitObserver) {
            observer.update(bitPrice, "Bitcoin");
        }
    }

    public void updateBitPrice(double bitPrice) {
        this.bitPrice = bitPrice;
        notifyObservers();
    }

}
