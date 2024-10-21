package midterm.observer;

public class DKUObserver implements Observer {
    private String name;
    private Object item;

    public DKUObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(Object item) {
        this.item = item;
        display();
    }

    public void display() {
        System.out.println("DKU 구독자 : " + name);
        System.out.println("내용 : " + item.toString());
    }
}
