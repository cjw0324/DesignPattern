//Lab07 자바프로그래밍2 1분반 32194692 최재우 24.11.19
package importer;
import java.util.Map;

// FileImporter 인터페이스는 파일을 읽고(import) 쓰는(export) 작업을 추상화한 인터페이스입니다.
// 제네릭 타입 T를 사용하여 다양한 데이터 형식을 처리할 수 있습니다.
public interface FileImporter<T> {
    /**
     * 파일에서 데이터를 읽어와 Map 형태로 반환합니다.
     *
     * @param filepath 읽을 파일의 경로
     * @return 파일 데이터를 Map<String, T> 형태로 반환
     */
    Map<String, T> importFile(String filepath);

    /**
     * 데이터를 파일에 저장합니다.
     *
     * @param filepath 저장할 파일의 경로
     * @param map 데이터를 저장할 Map<String, T>
     */
    void exportFile(String filepath, Map<String, T> map);
}