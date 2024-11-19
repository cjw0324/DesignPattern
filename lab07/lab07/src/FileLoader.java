import java.util.Map;

public interface FileLoader<T> {
    Map<String, T> load(String filepath);
    void save(String filepath, Map<String, T> map);
}
