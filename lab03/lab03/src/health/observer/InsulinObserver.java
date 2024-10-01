//Lab03, 자바프로그래밍2, 1분반, 2024-10-01, 최재우
package health.observer;

import template.DailyHealthData;

public class InsulinObserver implements Observer {

    private double insulinThreshold;

    public InsulinObserver(double insulinThreshold) {
        this.insulinThreshold = insulinThreshold;
    }

    @Override
    public void update(DailyHealthData d) {
        if (d.getInsulinDose() > this.insulinThreshold) {
            System.out.println("WARNING : 인슐린 수치가 높습니다");
        }
        System.out.println("Updated insulin level: " + d.getInsulinDose());
    }
}
