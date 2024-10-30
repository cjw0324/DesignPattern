import decorator.DecoratorTest;
import factorybuilder.FactoryBuilderTest;
import observer.ObserverTest;
import strategy.StrategyTest;
import template.MainTest;

public class Main {
    public static void main(String[] args) {
        //문제 1 : 실행
        new MainTest();

        //문제 2 : Decorator pattern 실행
        new DecoratorTest();

        //문제 3 : Factory Builder pattern 실행
        new FactoryBuilderTest();

        //문제 4 : Strategy pattern 실행
        new StrategyTest();

        //문제 5 : Observer pattern 실행
        new ObserverTest();
    }

}