package lecture3.strategyPattern;

public class Ramen {
    Recipe recipe = new GeneralRamenRecipe();

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    public void performCook() {
        recipe.cook();
    }
}
