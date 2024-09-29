package template;

public class DailyHealthData {
    private String date;
    private double bloodSugarLevel;
    private double insulinDose;
    private double carbsIntake;
    private double waterIntake;

    public DailyHealthData(String date, double bloodSugarLevel, double insulinDose, double carbsIntake, double waterIntake) {
        this.date = date;
        this.bloodSugarLevel = bloodSugarLevel;
        this.insulinDose = insulinDose;
        this.carbsIntake = carbsIntake;
        this.waterIntake = waterIntake;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getBloodSugarLevel() {
        return this.bloodSugarLevel;
    }

    public void setBloodSugarLevel(double bloodSugarLevel) {
        this.bloodSugarLevel = bloodSugarLevel;
    }

    public double getInsulinDose() {
        return this.insulinDose;
    }

    public void setInsulinDose(double insulinDose) {
        this.insulinDose = insulinDose;
    }

    public double getCarbsIntake() {
        return this.carbsIntake;
    }

    public void setCarbsIntake(double carbsIntake) {
        this.carbsIntake = carbsIntake;
    }

    public double getWaterIntake() {
        return waterIntake;
    }

    public DailyHealthData setWaterIntake(double waterIntake) {
        this.waterIntake = waterIntake;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " date='" + date + "'" +
                ", bloodSugarLevel='" + bloodSugarLevel + "'" +
                ", insulinDose='" + insulinDose + "'" +
                ", carbsIntake='" + carbsIntake + "'" +
                "}";
    }
}
