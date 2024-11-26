// Lab07 자바프로그래밍2 1분반 32194692 최재우 24.11.19
// FileImporterLoaderAdapter 클래스는 FileImporter 인터페이스를 FileLoader 인터페이스로 변환하는 어댑터 클래스입니다.
// 어댑터 패턴을 사용하여 FileImporter 기능을 FileLoader로 사용할 수 있도록 합니다.
package importer;

import java.util.Map;

public class FileImporterLoaderAdapter<T> implements FileLoader<T> {
    // FileImporter 객체를 포함하여 어댑터에서 사용
    private final FileImporter<T> importer;

    /**
     * FileImporterLoaderAdapter 생성자.
     * FileImporter 객체를 받아 어댑터로 사용합니다.
     *
     * @param importer FileImporter 인터페이스를 구현한 객체
     */
    public FileImporterLoaderAdapter(FileImporter<T> importer) {
        this.importer = importer;
    }

    /**
     * FileLoader 인터페이스의 load 메서드를 구현.
     * 내부적으로 FileImporter의 importFile 메서드를 호출하여 데이터를 가져옵니다.
     *
     * @param filepath 데이터를 읽어올 파일 경로
     * @return Map<String, T> 형태로 데이터를 반환
     */
    @Override
    public Map<String, T> load(String filepath) {
        return importer.importFile(filepath); // FileImporter의 importFile 메서드 호출
    }

    /**
     * FileLoader 인터페이스의 save 메서드를 구현.
     * 내부적으로 FileImporter의 exportFile 메서드를 호출하여 데이터를 저장합니다.
     *
     * @param filepath 데이터를 저장할 파일 경로
     * @param map 데이터를 저장할 Map<String, T>
     */
    @Override
    public void save(String filepath, Map<String, T> map) {
        importer.exportFile(filepath, map); // FileImporter의 exportFile 메서드 호출
    }
}
