package observer;

// Subject 인터페이스는 옵저버 패턴에서 주제 역할을 하는 객체가 구현해야 하는 인터페이스입니다.
public interface Subject {
    // 옵저버를 주제에 첨부하는 메소드
    void attachObserver(Observer observer);

    // 옵저버를 주제에서 제거하는 메소드
    void detachObserver(Observer observer);

    // 모든 첨부된 옵저버들에게 상태 변화를 알리는 메소드
    void notifyObservers();
}
