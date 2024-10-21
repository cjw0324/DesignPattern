//Lab03, 자바프로그래밍2, 1분반, 2024-10-01, 최재우
package template;

public class DailyWaterData {
    private String date;
    private double waterIntake;

    public DailyWaterData(String date, double waterIntake) {
        this.date = date;
        this.waterIntake = waterIntake;
    }

    public String getDate() {
        return date;
    }

    public DailyWaterData setDate(String date) {
        this.date = date;
        return this;
    }

    public double getWaterIntake() {
        return waterIntake;
    }

    public DailyWaterData setWaterIntake(double waterIntake) {
        this.waterIntake = waterIntake;
        return this;
    }

    @Override
    public String toString() {
        return "DailyWaterData [date=" + date + ", waterIntake=" + waterIntake + "]";
    }
}
