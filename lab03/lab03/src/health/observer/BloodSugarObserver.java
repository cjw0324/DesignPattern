//Lab03, 자바프로그래밍2, 1분반, 2024-10-01, 최재우
package health.observer;

import template.DailyHealthData;

public class BloodSugarObserver implements Observer {
    private double bloodSugarThreshold;


    public BloodSugarObserver(double bloodSugarThreshold) {
        this.bloodSugarThreshold = bloodSugarThreshold;
    }
    @Override
    public void update(DailyHealthData d) {
        if (d.getBloodSugarLevel() > this.bloodSugarThreshold) {
            System.out.println("WARNING : 혈당이 높습니다");
        }
        System.out.println("Updated blood sugar level: " + d.getBloodSugarLevel());
    }
}
