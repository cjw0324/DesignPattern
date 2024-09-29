package health.parsingStrategy;

import template.DailyWaterData;

public class WaterDataParseStrategy implements ParserStrategy<DailyWaterData> {
    @Override
    public DailyWaterData parse(String line) {
        String[] fields = line.split(",",2);
        String date = fields[0];
        double waterIntake = Double.parseDouble(fields[1]);

        return new DailyWaterData(date, waterIntake);
    }
}
