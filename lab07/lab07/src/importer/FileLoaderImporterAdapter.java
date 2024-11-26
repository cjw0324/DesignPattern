//Lab07 자바프로그래밍2 1분반 32194692 최재우 24.11.19
package importer;
import java.util.Map;

// FileLoaderImporterAdapter 클래스는 FileLoader 인터페이스를 FileImporter 인터페이스로 변환하는 어댑터 클래스입니다.
// 어댑터 패턴을 사용하여 FileLoader 기능을 FileImporter로 사용할 수 있도록 합니다.
public class FileLoaderImporterAdapter<T> implements FileImporter<T> {
    // FileLoader 객체를 포함하여 어댑터에서 사용
    private final FileLoader<T> loader;

    /**
     * FileLoaderImporterAdapter 생성자.
     * FileLoader 객체를 받아 어댑터로 사용합니다.
     *
     * @param loader FileLoader 인터페이스를 구현한 객체
     */
    public FileLoaderImporterAdapter(FileLoader<T> loader) {
        this.loader = loader;
    }

    /**
     * FileImporter 인터페이스의 importFile 메서드를 구현.
     * 내부적으로 FileLoader의 load 메서드를 호출하여 데이터를 가져옵니다.
     *
     * @param filepath 데이터를 읽어올 파일 경로
     * @return Map<String, T> 형태로 데이터를 반환
     */
    @Override
    public Map<String, T> importFile(String filepath) {
        return loader.load(filepath);
    }

    /**
     * FileImporter 인터페이스의 exportFile 메서드를 구현.
     * 내부적으로 FileLoader의 save 메서드를 호출하여 데이터를 저장합니다.
     *
     * @param filepath 데이터를 저장할 파일 경로
     * @param map 데이터를 저장할 Map<String, T>
     */
    @Override
    public void exportFile(String filepath, Map<String, T> map) {
        loader.save(filepath, map);
    }
}
