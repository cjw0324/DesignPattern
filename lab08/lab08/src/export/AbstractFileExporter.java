package export;

/*
 * 자바프로그래밍2 1분반 Lab08
 * 32184682 최재우
 * 2024-11-26
 */

import java.util.List;

/**
 * AbstractFileExporter
 * 데이터를 특정 포맷으로 파일에 저장하기 위한 추상 클래스입니다.
 * 템플릿 메서드 패턴을 사용하여 저장 과정을 정의합니다.
 */
public abstract class AbstractFileExporter {

    /**
     * exportToFile
     * 데이터를 지정된 경로에 파일로 저장합니다.
     * @param data 저장할 데이터 리스트
     * @param filePath 저장할 파일 경로
     */
    public final void exportToFile(List<?> data, String filePath) {
        // 데이터를 특정 포맷으로 변환
        String formattedData = formatData(data);

        // 변환된 데이터를 파일로 저장
        saveToFile(formattedData, filePath);
    }

    /**
     * 데이터를 특정 포맷으로 변환하는 추상 메서드
     * @param data 저장할 데이터 리스트
     * @return 포맷팅된 데이터 문자열
     */
    protected abstract String formatData(List<?> data);

    /**
     * 데이터를 파일로 저장하는 공통 메서드
     * @param formattedData 포맷팅된 데이터 문자열
     * @param filePath 저장할 파일 경로
     */
    private void saveToFile(String formattedData, String filePath) {
        try (java.io.FileWriter writer = new java.io.FileWriter(filePath)) {
            writer.write(formattedData);
            System.out.println("Data successfully saved to " + filePath);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}

