package importer;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import programlaunchercommand.ProgramLauncherCommand;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ProgramLauncherCommandJSONFileImporter implements FileImporter<ProgramLauncherCommand> {

    @Override
    public Map<String, ProgramLauncherCommand> importFile(String filepath) {
        Map<String, ProgramLauncherCommand> map = new HashMap<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filepath)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // "commands" 배열 가져오기
            JSONArray commandsArray = (JSONArray) jsonObject.get("commands");

            for (Object obj : commandsArray) {
                JSONObject commandJson = (JSONObject) obj;

                // JSON에서 값 추출
                String name = (String) commandJson.get("name");
                String executable = (String) commandJson.get("executable");
                String icon = (String) commandJson.get("icon");

                // Map에 추가
                map.put(name, new ProgramLauncherCommand(executable, icon));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return map;
    }

    @Override
    public void exportFile(String filepath, Map<String, ProgramLauncherCommand> map) {
        JSONObject jsonObject = new JSONObject();
        JSONArray commandsArray = new JSONArray();

        for (Map.Entry<String, ProgramLauncherCommand> entry : map.entrySet()) {
            JSONObject commandJson = new JSONObject();
            commandJson.put("name", entry.getKey());
            commandJson.put("executable", entry.getValue().getExecutable());
            commandJson.put("icon", entry.getValue().getIcon());
            commandsArray.add(commandJson);
        }

        jsonObject.put("commands", commandsArray);

        try (FileWriter writer = new FileWriter(filepath)) {
            writer.write(jsonObject.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
