package midterm.observer;

import java.util.*;
public class YoutubeSubject implements Subject {
    private Youtube video;
    private List<Observer> observers;

    public YoutubeSubject() {
        this.observers = new ArrayList<>();
    }


    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(video);
        }
    }

    public void setYoutube(Youtube newVideo) {
        this.video = newVideo;
        notifyObservers();
    }
}
