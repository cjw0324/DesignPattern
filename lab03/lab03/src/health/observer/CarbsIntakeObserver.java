package health.observer;

import template.DailyHealthData;

public class CarbsIntakeObserver implements Observer {
    private double carbsIntakeThreshold;

    public CarbsIntakeObserver(double carbsIntakeThreshold) {
        this.carbsIntakeThreshold = carbsIntakeThreshold;
    }

    @Override
    public void update(DailyHealthData d) {
        if (d.getCarbsIntake() > this.carbsIntakeThreshold) {
            System.out.println("WARNING : 탄수화물 섭취 수치가 높습니다");
        }
        System.out.println("Updated carbs intake level: " + d.getCarbsIntake());
    }
}
