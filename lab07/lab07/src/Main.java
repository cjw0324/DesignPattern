// Lab07 자바프로그래밍2 1분반 32194692 최재우 24.11.19
// Main 클래스는 프로그램의 진입점으로, JSON, XML, CSV 파일 간 데이터 변환 및 저장을 테스트합니다.
import importer.*;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {
            // 1. JSON Importer 테스트
            System.out.println("Starting JSON Importer Test...");
            FileImporter<ProgramLauncherCommand> jsonImporter = new ProgramLauncherCommandJSONFileImporter();

            // commands.json 파일에서 데이터 읽기
            Map<String, ProgramLauncherCommand> map = jsonImporter.importFile("commands.json");

            // 데이터를 확인 및 출력
            if (map.isEmpty()) {
                System.out.println("Map is empty after JSON import. Check the JSON file.");
            } else {
                System.out.println("Imported Commands from JSON:");
                for (Map.Entry<String, ProgramLauncherCommand> entry : map.entrySet()) {
                    System.out.println("Name: " + entry.getKey() +
                            ", Executable: " + entry.getValue().getExecutable() +
                            ", Icon: " + entry.getValue().getIcon());
                }
            }

            // 데이터를 새로운 JSON 파일로 저장
            jsonImporter.exportFile("commands2.json", map);
            System.out.println("Exported to commands2.json");

            // 2. 어댑터를 사용하여 XML 파일로 저장
            System.out.println("\nSaving to XML file using adapter...");
            FileLoader<ProgramLauncherCommand> xmlLoader = new FileImporterLoaderAdapter<>(new ProgramLauncherCommandXMLFileImporter());

            // commands2.xml 파일로 저장
            xmlLoader.save("commands2.xml", map);
            System.out.println("Exported to commands2.xml");

            // 3. 어댑터를 사용하여 CSV 파일로 저장
            System.out.println("\nSaving to CSV file using adapter...");
            FileImporter<ProgramLauncherCommand> csvImporter = new FileLoaderImporterAdapter<>(new ProgramLauncherCommandCSVFileLoader());

            // commands2.csv 파일로 저장
            csvImporter.exportFile("commands2.csv", map);
            System.out.println("Exported to commands2.csv");

        } catch (Exception e) {
            // 실행 중 발생한 예외를 처리
            e.printStackTrace();
        }
    }
}
