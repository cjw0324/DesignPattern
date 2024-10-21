package midterm.observer;


import java.util.*;
public class NewsPaperSubject implements Subject{
    List<Observer> newsObservers;

    private NewsPaper news;

    public NewsPaperSubject(){
        this.newsObservers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer){
        newsObservers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer){
        newsObservers.remove(observer);
    }

    @Override
    public void notifyObservers(){
        for (Observer newsObserver : newsObservers) {
            newsObserver.update(news);
        }
    }

    public void setNews(NewsPaper todayNews) {
        this.news = todayNews;
        notifyObservers();
    }
}
