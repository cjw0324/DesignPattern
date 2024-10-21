//Lab03, 자바프로그래밍2, 1분반, 2024-10-01, 최재우
package health.observer;


import template.DailyHealthData;
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
