package lecture3.strategyPattern;

public class RamenWithoutBrothRecipe implements Recipe{
    @Override
    public void cook() {
        System.out.println("물을 적게 넣고 끓이기");
    }
}
