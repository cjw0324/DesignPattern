// Lab07 자바프로그래밍2 1분반 32194692 최재우 24.11.19
// ProgramLauncherCommandCSVFileLoader 클래스는 CSV 파일을 읽고 쓰는 기능을 구현한 클래스입니다.
// FileLoader 인터페이스를 구현하여 데이터를 로드(load)하고 저장(save)할 수 있습니다.
package importer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ProgramLauncherCommandCSVFileLoader implements FileLoader<ProgramLauncherCommand> {
    /**
     * CSV 파일에서 데이터를 읽어 Map 형태로 반환합니다.
     *
     * @param filepath 데이터를 로드할 CSV 파일 경로
     * @return Map<String, ProgramLauncherCommand> 형태로 데이터 반환
     */
    @Override
    public Map<String, ProgramLauncherCommand> load(String filepath) {
        Map<String, ProgramLauncherCommand> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            // 파일의 각 줄을 읽어 데이터 파싱
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                // CSV의 각 행은 "name,executable,icon" 형식이어야 함
                if (parts.length == 3) {
                    map.put(parts[0], new ProgramLauncherCommand(parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            // 파일 읽기 중 발생한 예외 처리
            e.printStackTrace();
        }
        return map; // 로드한 데이터를 Map 형태로 반환
    }

    /**
     * Map 데이터를 CSV 파일에 저장합니다.
     *
     * @param filepath 데이터를 저장할 CSV 파일 경로
     * @param map Map<String, ProgramLauncherCommand> 데이터를 저장
     */
    @Override
    public void save(String filepath, Map<String, ProgramLauncherCommand> map) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            // Map의 각 엔트리를 CSV 형식으로 저장
            for (Map.Entry<String, ProgramLauncherCommand> entry : map.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue().getExecutable() + "," + entry.getValue().getIcon());
                writer.newLine(); // 줄 바꿈
            }
        } catch (IOException e) {
            // 파일 쓰기 중 발생한 예외 처리
            e.printStackTrace();
        }
    }
}
