package app;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import programlaunchercommand.ProgramLauncherCommand;


import java.util.*;
import java.io.*;

public class ProgramLauncherCommandImporter {
    public static Map<String, ProgramLauncherCommand> loadCommandsFromJson(String filePath) {
        Map<String, ProgramLauncherCommand> commandsMap = new HashMap<>();

        try (FileReader reader = new FileReader(filePath)) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            // "commands" 배열 가져오기
            JSONArray commandsArray = (JSONArray) jsonObject.get("commands");

            // 각 명령을 파싱하여 ProgramLauncherCommand 객체로 생성
            for (Object obj : commandsArray) {
                JSONObject commandJson = (JSONObject) obj;

                String name = (String) commandJson.get("name");
                String executable = (String) commandJson.get("executable");
                String icon = (String) commandJson.get("icon");

                // ProgramLauncherCommand 객체 생성
                ProgramLauncherCommand command = new ProgramLauncherCommand(executable, icon);

                // commandsMap에 추가
                commandsMap.put(name, command);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return commandsMap;
    }
}
