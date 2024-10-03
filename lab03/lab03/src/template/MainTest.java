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

        // Load dailyfooddata
		List<DailyFoodData> dailyFoodDataList = new FileImporter<>(new DailyFoodDataParseStrategy(foodDataList)).loadCSV("src/csv/dailyfooddata.csv");

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

        manager.removeObserver(bo);

        // Add observers
        System.out.println("999");

        // Simulate health data updates with food integration
        new Thread(() -> {
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
        }).start();

    }
}
