package lecture7.threadSafe;

public class SingletonInnerStatic {
    private static class SingletonHolder{
        static final SingletonInnerStatic instance = new SingletonInnerStatic();
    }
    private SingletonInnerStatic() {

    }

    public static SingletonInnerStatic getInstance() {
        return SingletonHolder.instance;
    }
}
