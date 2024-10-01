//Lab03, 자바프로그래밍2, 1분반, 2024-10-01, 최재우
package health.parsingStrategy;

import template.DailyFoodData;
import template.FoodData;

import java.util.ArrayList;
import java.util.List;

public class DailyFoodDataParseStrategy implements ParserStrategy<DailyFoodData> {
    private List<FoodData> allFoodData;  // 전체 음식 데이터 리스트를 참조

    public DailyFoodDataParseStrategy(List<FoodData> allFoodData) {
        this.allFoodData = allFoodData;
    }

    @Override
    public DailyFoodData parse(String line) {
        // 첫 번째 쉼표에서 날짜를 분리
        String[] parts = line.split(",", 2);

        if (parts.length < 2) {
            throw new IllegalArgumentException("잘못된 데이터 형식: " + line);
        }

        String date = parts[0];  // 날짜 정보
        String foodList = parts[1].replaceAll("\"", "");  // 따옴표 제거 후 음식 목록

        // 음식 이름들을 쉼표 기준으로 분리하여 FoodData 리스트로 변환
        String[] foodNames = foodList.split(",");
        List<FoodData> dailyFoods = new ArrayList<>();

        for (String foodName : foodNames) {
            // foodName을 사용하여 FoodData 객체 생성 (예: 이름만으로 기본 FoodData 생성)
            dailyFoods.add(new FoodData(foodName.trim(), 0.0, 0.0));  // 실제 칼로리, 탄수화물 값은 0으로 설정
        }

        return new DailyFoodData(date, dailyFoods);
    }
}
