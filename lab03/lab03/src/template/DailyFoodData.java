//Lab03, 자바프로그래밍2, 1분반, 2024-10-01, 최재우
package template;
import java.util.List;

public class DailyFoodData {
    private String date;
    private List<FoodData> foods;

    // Constructor to add data for a specific date
    public DailyFoodData(String date, List<FoodData> foods) {
        this.date = date;
        this.foods = foods;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<FoodData> getFoods() {
        return this.foods;
    }

    public void setFoods(List<FoodData> foods) {
        this.foods = foods;
    }


    @Override
    public String toString() {
        return "{" +
            " date='" + getDate() + "'" +
            ", foods='" + getFoods() + "'" +
            "}";
    }

}
