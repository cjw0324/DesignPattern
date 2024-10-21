package midterm.strategy;

public class Maltese{
    private Dog dog;
    private String name;

    public Maltese(String name){
        this.name = name;
    }

    public void setAge(Dog dog){
        this.dog = dog;
    }

    public void IntroduceMyMaltese(){
        System.out.println("My dog name is : " + name);
        dog.eat();
        dog.walk();
    }
}
