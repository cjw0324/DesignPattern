package importer;
import java.util.Map;

public class FileLoaderImporterAdapter<T> implements FileImporter<T> {
    private final FileLoader<T> loader;

    public FileLoaderImporterAdapter(FileLoader<T> loader) {
        this.loader = loader;
    }

    @Override
    public Map<String, T> importFile(String filepath) {
        return loader.load(filepath);
    }

    @Override
    public void exportFile(String filepath, Map<String, T> map) {
        loader.save(filepath, map);
    }
}
