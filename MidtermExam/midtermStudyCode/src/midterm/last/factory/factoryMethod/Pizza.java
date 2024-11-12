package midterm.last.factory.factoryMethod;

public abstract class Pizza {
    public String name;

    void prepare() {
        System.out.println(name + "준비");
    }
    void making() {
        System.out.println("만드는중");
    }
    void boxing() {
        System.out.println("포장중");
    }
}
