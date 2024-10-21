package midterm.strategy;

public class AdultMaltese implements Dog{
    @Override
    public void eat(){
        System.out.println("어른 말티즈가 식사함");
    }

    @Override
    public void walk(){
        System.out.println("어른 말티즈는 많이 걸을 수 있음");
    }
}
