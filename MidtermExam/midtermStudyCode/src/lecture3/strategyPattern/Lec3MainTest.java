package lecture3.strategyPattern;

public class Lec3MainTest {
    public static void main(String[] args) {
        Ramen ramen = new Ramen();

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                ramen.setRecipe(new RamenWithoutBrothRecipe());
            }
            if (i == 1) {
                ramen.setRecipe(new GeneralRamenRecipe());
            }
            ramen.performCook();
        }

    }
}
