package observers;

public class User implements Observer{
    private String name;
    private String chat;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(Object item) {
        chat = String.valueOf(item);
    }

    private void display() {
        System.out.println("[" + name + "]");
        System.out.println(chat);
    }
}
