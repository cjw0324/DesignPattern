//Lab07 자바프로그래밍2 1분반 32194692 최재우 24.11.19
package importer;

import java.util.Map;

// FileLoader 인터페이스는 파일 데이터를 로드(load)하고 저장(save)하는 기능을 추상화합니다.
// 제네릭 타입 T를 사용하여 다양한 데이터 형식에 적용할 수 있습니다.
public interface FileLoader<T> {
    /**
     * 파일에서 데이터를 로드하여 Map 형태로 반환하는 메서드.
     *
     * @param filepath 데이터를 로드할 파일 경로
     * @return Map<String, T> 형태로 데이터를 반환 (키: 데이터 이름, 값: 데이터 객체)
     */
    Map<String, T> load(String filepath);

    /**
     * Map 데이터를 파일에 저장하는 메서드.
     *
     * @param filepath 데이터를 저장할 파일 경로
     * @param map Map<String, T> 형태의 데이터를 파일로 저장
     */
    void save(String filepath, Map<String, T> map);
}
