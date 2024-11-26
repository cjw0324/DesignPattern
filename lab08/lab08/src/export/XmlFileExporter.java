package export;
/*
 * 자바프로그래밍2 1분반 Lab08
 * 32184682 최재우
 * 2024-11-26
 */

import java.util.List;

/**
 * XmlFileExporter
 * 데이터를 XML 형식으로 변환하여 저장하는 클래스입니다.
 */
public class XmlFileExporter extends AbstractFileExporter {

    @Override
    protected String formatData(List<?> data) {
        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<items>\n");

        for (Object item : data) {
            xmlBuilder.append("  <item>").append(item.toString()).append("</item>\n");
        }

        xmlBuilder.append("</items>");
        return xmlBuilder.toString(); // XML 문자열 반환
    }
}
