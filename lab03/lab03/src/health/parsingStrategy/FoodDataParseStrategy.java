package health.parsingStrategy;

import template.FoodData;

public class FoodDataParseStrategy implements ParserStrategy<FoodData> {
    @Override
    public FoodData parse(String line) {
        String[] fields = line.split(",");
        String name = fields[0];
        double carbs = Double.parseDouble(fields[1]);
        double calories = Double.parseDouble(fields[2]);

        return new FoodData(name, carbs, calories);
    }
}
