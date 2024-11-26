package export;
/*
 * 자바프로그래밍2 1분반 Lab08
 * 32184682 최재우
 * 2024-11-26
 */

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.List;

/**
 * JsonFileExporter
 * 데이터를 JSON 형식으로 변환하여 저장하는 클래스입니다.
 */
public class JsonFileExporter extends AbstractFileExporter {

    @Override
    protected String formatData(List<?> data) {
        JSONArray jsonArray = new JSONArray();

        for (Object item : data) {
            // 데이터를 Key-Value 형태로 파싱
            String raw = item.toString();
            JSONObject jsonObject = new JSONObject();

            // "Title: ..., Description: ..., Image: ..., Link: ..." 형식의 데이터를 파싱
            for (String part : raw.split(", ")) {
                String[] keyValue = part.split(": ", 2);
                if (keyValue.length == 2) {
                    jsonObject.put(keyValue[0].trim(), keyValue[1].trim());
                }
            }

            jsonArray.add(jsonObject);
        }

        // JSON 문자열을 들여쓰기 4로 포맷팅
        return jsonArray.toJSONString().replace(",", ",\n").replace("{", "{\n").replace("}", "\n}");
    }
}

