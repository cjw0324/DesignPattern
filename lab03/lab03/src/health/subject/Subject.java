//Lab03, 자바프로그래밍2, 1분반, 2024-10-01, 최재우
package health.subject;

import health.observer.Observer;

public interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
