// Lab07 자바프로그래밍2 1분반 32194692 최재우 24.11.19
// ProgramLauncherCommandJSONFileImporter 클래스는 JSON 파일을 읽고 쓰는 기능을 구현합니다.
// FileImporter 인터페이스를 구현하여 JSON 데이터를 가져오고(import), 저장(export)할 수 있습니다.
package importer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProgramLauncherCommandJSONFileImporter implements FileImporter<ProgramLauncherCommand> {

    /**
     * JSON 파일에서 데이터를 읽어 Map 형태로 반환합니다.
     *
     * @param filepath 데이터를 읽어올 JSON 파일 경로
     * @return Map<String, ProgramLauncherCommand> 형태로 데이터 반환
     */
    @Override
    public Map<String, ProgramLauncherCommand> importFile(String filepath) {
        Map<String, ProgramLauncherCommand> map = new HashMap<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filepath)) {
            // JSON 파일 파싱
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // "commands" 배열 가져오기
            JSONArray commandsArray = (JSONArray) jsonObject.get("commands");

            // 배열 내 각 명령 객체를 Map에 추가
            for (Object obj : commandsArray) {
                JSONObject commandJson = (JSONObject) obj;

                // JSON에서 값 추출
                String name = (String) commandJson.get("name");
                String executable = (String) commandJson.get("executable");
                String icon = (String) commandJson.get("icon");

                // ProgramLauncherCommand 객체 생성 후 Map에 추가
                map.put(name, new ProgramLauncherCommand(executable, icon));
            }
        } catch (IOException | ParseException e) {
            // 파일 읽기 또는 JSON 파싱 중 발생한 예외 처리
            e.printStackTrace();
        }

        return map; // 읽어온 데이터를 반환
    }

    /**
     * Map 데이터를 JSON 파일로 저장합니다.
     *
     * @param filepath 데이터를 저장할 JSON 파일 경로
     * @param map Map<String, ProgramLauncherCommand> 데이터를 저장
     */
    @Override
    public void exportFile(String filepath, Map<String, ProgramLauncherCommand> map) {
        JSONObject jsonObject = new JSONObject();
        JSONArray commandsArray = new JSONArray();

        // Map의 각 엔트리를 JSON 형식으로 변환
        for (Map.Entry<String, ProgramLauncherCommand> entry : map.entrySet()) {
            JSONObject commandJson = new JSONObject();
            commandJson.put("name", entry.getKey());
            commandJson.put("executable", entry.getValue().getExecutable());
            commandJson.put("icon", entry.getValue().getIcon());
            commandsArray.add(commandJson);
        }

        // JSON 객체에 "commands" 배열 추가
        jsonObject.put("commands", commandsArray);

        try (FileWriter writer = new FileWriter(filepath)) {
            // JSON 데이터를 파일로 저장
            writer.write(jsonObject.toJSONString());
        } catch (IOException e) {
            // 파일 저장 중 발생한 예외 처리
            e.printStackTrace();
        }
    }
}
