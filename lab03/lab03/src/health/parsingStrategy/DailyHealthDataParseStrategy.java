package health.parsingStrategy;

import template.DailyHealthData;

public class DailyHealthDataParseStrategy implements ParserStrategy<DailyHealthData>{
    @Override
    public DailyHealthData parse(String line) {
        String[] fields = line.split(",");  // CSV 파일의 각 라인은 콤마로 구분
        String date = fields[0];
        double bloodSugarLevel = Double.parseDouble(fields[1]);
        double insulinDose = Double.parseDouble(fields[2]);
        double carbsIntake = Double.parseDouble(fields[3]);
        double waterIntake = Double.parseDouble(fields[4]);

        return new DailyHealthData(date, bloodSugarLevel, insulinDose, carbsIntake, waterIntake);
    }
}
