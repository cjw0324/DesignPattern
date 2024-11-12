//자바 프로그래밍2 1분반 32148682 최재우 24.11.12
package app;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import programlaunchercommand.ProgramLauncherCommand;

import java.util.*;
import java.io.*;

public class ProgramLauncherCommandImporter {
    // JSON 파일에서 명령어 데이터를 로드하여 Map으로 반환하는 메서드
    public static Map<String, ProgramLauncherCommand> loadCommandsFromJson(String filePath) {
        // 명령어 이름을 키로, ProgramLauncherCommand 객체를 값으로 저장하는 Map 생성
        Map<String, ProgramLauncherCommand> commandsMap = new HashMap<>();

        // 파일 읽기 시도
        try (FileReader reader = new FileReader(filePath)) {
            JSONParser parser = new JSONParser(); // JSON 파서 생성
            JSONObject jsonObject = (JSONObject) parser.parse(reader); // 파일을 JSON 객체로 파싱

            // "commands"라는 배열을 가져옴
            JSONArray commandsArray = (JSONArray) jsonObject.get("commands");

            // 각 명령어 객체를 순회하면서 ProgramLauncherCommand로 변환
            for (Object obj : commandsArray) {
                JSONObject commandJson = (JSONObject) obj;

                // JSON 객체에서 명령어의 이름, 실행 파일 경로, 아이콘 경로를 가져옴
                String name = (String) commandJson.get("name");
                String executable = (String) commandJson.get("executable");
                String icon = (String) commandJson.get("icon");

                // ProgramLauncherCommand 객체를 생성
                ProgramLauncherCommand command = new ProgramLauncherCommand(executable, icon);

                // Map에 명령어 이름을 키로, ProgramLauncherCommand 객체를 값으로 저장
                commandsMap.put(name, command);
            }
        } catch (IOException | ParseException e) { // 파일 또는 JSON 파싱 오류 처리
            e.printStackTrace();
        }

        return commandsMap; // 완성된 명령어 Map 반환
    }
}
