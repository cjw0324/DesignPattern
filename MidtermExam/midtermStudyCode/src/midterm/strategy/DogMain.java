package midterm.strategy;
import java.util.*;
public class DogMain {
    public static void main(String[] args){
        List<Maltese> dogs = new ArrayList<>();
        Maltese dog;
        dog = new Maltese("ppopie");
        dog.setAge(new AdultMaltese());
        dogs.add(dog);

        dog = new Maltese("moka");
        dog.setAge(new BabyMaltese());
        dogs.add(dog);

        for(Maltese mydog : dogs){
            mydog.IntroduceMyMaltese();
        }
    }
}
