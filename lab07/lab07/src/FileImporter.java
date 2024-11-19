import java.util.Map;

public interface FileImporter<T> {
    Map<String, T> importFile(String filepath);
    void exportFile(String filepath, Map<String, T> map);
}