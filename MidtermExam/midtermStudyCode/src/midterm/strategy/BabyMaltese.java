package midterm.strategy;

public class BabyMaltese implements Dog{
    @Override
    public void eat(){
        System.out.println("아기 말티즈가 식사함");
    }
    @Override
    public void walk(){
        System.out.println("아기 말티즈는 많이 못걸음");
    }
}
