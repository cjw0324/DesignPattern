package health.subject;

import health.observer.Observer;
import template.DailyHealthData;

import java.util.ArrayList;
import java.util.List;

public class DiabetesManager implements Subject {
    private List<Observer> observers;
    private DailyHealthData dailyHealthData;

    public DiabetesManager() {
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(dailyHealthData);
        }
    }
    public void addDailyHealthData(DailyHealthData data) {
        this.dailyHealthData = data;
        notifyObservers();
    }
}
