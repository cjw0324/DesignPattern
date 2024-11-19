package importer;
import programlaunchercommand.ProgramLauncherCommand;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ProgramLauncherCommandCSVFileLoader implements FileLoader<ProgramLauncherCommand> {
    @Override
    public Map<String, ProgramLauncherCommand> load(String filepath) {
        Map<String, ProgramLauncherCommand> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    map.put(parts[0], new ProgramLauncherCommand(parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public void save(String filepath, Map<String, ProgramLauncherCommand> map) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
            for (Map.Entry<String, ProgramLauncherCommand> entry : map.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue().getExecutable() + "," + entry.getValue().getIcon());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
