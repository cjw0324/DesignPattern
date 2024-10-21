package lecture3.strategyPattern;

public class GeneralRamenRecipe implements Recipe{
    @Override
    public void cook() {
        System.out.println("일반 조리법");
    }
}
