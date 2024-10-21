package lecture7.threadSafe;

public class EagerSingleton {
    private static EagerSingleton inst = new EagerSingleton();
    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return inst;
    }
}
