package health.observer;


import template.DailyHealthData;
import template.DailyWaterData;

public class WaterIntakeHealthDataObserver implements Observer {
    private double waterThreshold;

    public WaterIntakeHealthDataObserver(double waterThreshold) {
        this.waterThreshold = waterThreshold;
    }

    @Override
    public void update(DailyHealthData d) {
        double waterIntake = d.getWaterIntake();
        if (waterIntake < this.waterThreshold) {
            System.out.println("WARNING : 물 섭취량이 너무 적습니다!");
        } else {
            System.out.println("Updated water intake level: " + d.getWaterIntake());
        }
    }

}
