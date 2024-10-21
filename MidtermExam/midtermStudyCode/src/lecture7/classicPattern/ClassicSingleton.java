package lecture7.classicPattern;

public class ClassicSingleton {
    private static ClassicSingleton uniqueInstance;

    private ClassicSingleton() {

    }

    public static ClassicSingleton getInstance() {
        if (uniqueInstance == null) {
            return new ClassicSingleton();
        } else {
            return uniqueInstance;
        }
    }
}
