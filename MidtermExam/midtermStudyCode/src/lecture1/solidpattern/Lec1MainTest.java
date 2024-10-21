package lecture1.solidpattern;

public class Lec1MainTest {
    public static void main(String[] args) {
        Bird bird = new Bird();
        FlyingBird flyingBird = new FlyingBird();
        Ostrich ostrich = new Ostrich();
        Sparrow sparrow = new Sparrow();

        bird.makeSound();
        flyingBird.fly();
        flyingBird.makeSound();
        ostrich.makeSound();
        sparrow.makeSound();
        sparrow.fly();
    }
}
