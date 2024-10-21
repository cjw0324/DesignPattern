//Lab03, 자바프로그래밍2, 1분반, 2024-10-01, 최재우
package template;

import health.observer.WaterIntakeHealthDataObserver;
import health.parsingStrategy.*;
import health.subject.DiabetesManager;
import health.observer.BloodSugarObserver;
import health.observer.CarbsIntakeObserver;
import health.observer.InsulinObserver;

import java.util.List;

public class MainTest {

    public MainTest() {

        System.out.println();

        // Load fooddata
		List<FoodData> foodDataList = new FileImporter<>(new FoodDataParseStrategy()).loadCSV("src/csv/fooddata.csv");
<<<<<<< HEAD

        // Load dailyfooddata
		List<DailyFoodData> dailyFoodDataList = new FileImporter<>(new DailyFoodDataParseStrategy(foodDataList)).loadCSV("src/csv/dailyfooddata.csv");

=======
        // Load dailyfooddata
		List<DailyFoodData> dailyFoodDataList = new FileImporter<>(new DailyFoodDataParseStrategy(foodDataList)).loadCSV("src/csv/dailyfooddata.csv");
>>>>>>> 1489ad45a514b9537c0a5277a4b24b509f895233
        // Load dailyhealthdata
        List<DailyHealthData> dailyHealthDataList = new FileImporter<>(new DailyHealthDataParseStrategy()).loadCSV("src/csv/dailyhealthdata.csv");

        // Subject
        DiabetesManager manager = new DiabetesManager();
        // Observer
        BloodSugarObserver bo = new BloodSugarObserver(150);
        CarbsIntakeObserver co = new CarbsIntakeObserver(70);
        InsulinObserver io = new InsulinObserver(10);
        manager.addObserver(bo);
        manager.addObserver(co);
        manager.addObserver(io);

        //my Observer create & add
        WaterIntakeHealthDataObserver wo = new WaterIntakeHealthDataObserver(2.0);
        manager.addObserver(wo);

        System.out.println("BloodSugar / Carbs / Insulin / Water observer");
        for (DailyHealthData h : dailyHealthDataList) {

            DailyFoodData f = dailyFoodDataList.stream().filter(e ->
                    e.getDate().equals(h.getDate())).findAny().orElse(null);
            double totalCarbs = f.getFoods().stream().mapToDouble(e ->
                    e.getCarbs()).sum();
            totalCarbs += h.getCarbsIntake();
            h.setCarbsIntake(totalCarbs);
            double insulinDose = (h.getInsulinDose() + totalCarbs) / 10.0;
            h.setInsulinDose(insulinDose);
            manager.addDailyHealthData(h);

            try {
                Thread.sleep(100); // Wait for 1 second before the next update
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n\n\n");
        }

        manager.removeObserver(co);
        manager.removeObserver(wo);

        System.out.println("BloodSugar / Insulin observer");
        for (DailyHealthData h : dailyHealthDataList) {

            DailyFoodData f = dailyFoodDataList.stream().filter(e ->
                    e.getDate().equals(h.getDate())).findAny().orElse(null);
            double totalCarbs = f.getFoods().stream().mapToDouble(e ->
                    e.getCarbs()).sum();
            totalCarbs += h.getCarbsIntake();
            h.setCarbsIntake(totalCarbs);
            double insulinDose = (h.getInsulinDose() + totalCarbs) / 10.0;
            h.setInsulinDose(insulinDose);
            manager.addDailyHealthData(h);

            try {
                Thread.sleep(100); // Wait for 1 second before the next update
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n\n\n");
        }
    }
}
