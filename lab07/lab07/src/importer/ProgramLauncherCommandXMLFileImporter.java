// Lab07 자바프로그래밍2 1분반 32194692 최재우 24.11.19
// ProgramLauncherCommandXMLFileImporter 클래스는 XML 파일을 읽고 쓰는 기능을 구현합니다.
// FileImporter 인터페이스를 구현하여 XML 데이터를 가져오고(import), 저장(export)할 수 있습니다.
package importer;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ProgramLauncherCommandXMLFileImporter implements FileImporter<ProgramLauncherCommand> {

    /**
     * XML 파일에서 데이터를 읽어 Map 형태로 반환합니다.
     *
     * @param filepath 데이터를 읽어올 XML 파일 경로
     * @return Map<String, ProgramLauncherCommand> 형태로 데이터 반환
     */
    @Override
    public Map<String, ProgramLauncherCommand> importFile(String filepath) {
        Map<String, ProgramLauncherCommand> map = new HashMap<>();

        try {
            // XML 파싱을 위한 DocumentBuilder 생성
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(filepath));

            // 루트 엘리먼트 가져오기
            Element root = document.getDocumentElement();
            NodeList commandNodes = root.getElementsByTagName("command");

            // 각 <command> 엘리먼트를 Map에 저장
            for (int i = 0; i < commandNodes.getLength(); i++) {
                Node commandNode = commandNodes.item(i);

                if (commandNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element commandElement = (Element) commandNode;

                    // XML에서 데이터 추출
                    String name = commandElement.getElementsByTagName("name").item(0).getTextContent();
                    String executable = commandElement.getElementsByTagName("executable").item(0).getTextContent();
                    String icon = commandElement.getElementsByTagName("icon").item(0).getTextContent();

                    // ProgramLauncherCommand 객체 생성 후 Map에 추가
                    map.put(name, new ProgramLauncherCommand(executable, icon));
                }
            }
        } catch (Exception e) {
            // 파일 읽기 또는 XML 파싱 중 발생한 예외 처리
            e.printStackTrace();
        }

        return map; // 읽어온 데이터를 반환
    }

    /**
     * Map 데이터를 XML 파일로 저장합니다.
     *
     * @param filepath 데이터를 저장할 XML 파일 경로
     * @param map Map<String, ProgramLauncherCommand> 데이터를 저장
     */
    @Override
    public void exportFile(String filepath, Map<String, ProgramLauncherCommand> map) {
        try {
            // XML Document 생성
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            // 루트 엘리먼트 생성
            Element root = document.createElement("commands");
            document.appendChild(root);

            // Map의 데이터를 <command> 엘리먼트로 변환
            for (Map.Entry<String, ProgramLauncherCommand> entry : map.entrySet()) {
                Element commandElement = document.createElement("command");

                // <name> 엘리먼트 생성 및 값 설정
                Element nameElement = document.createElement("name");
                nameElement.setTextContent(entry.getKey());
                commandElement.appendChild(nameElement);

                // <executable> 엘리먼트 생성 및 값 설정
                Element executableElement = document.createElement("executable");
                executableElement.setTextContent(entry.getValue().getExecutable());
                commandElement.appendChild(executableElement);

                // <icon> 엘리먼트 생성 및 값 설정
                Element iconElement = document.createElement("icon");
                iconElement.setTextContent(entry.getValue().getIcon());
                commandElement.appendChild(iconElement);

                // <command> 엘리먼트를 루트에 추가
                root.appendChild(commandElement);
            }

            // XML 파일로 저장
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); // 파일을 읽기 쉽게 들여쓰기 설정
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

        } catch (Exception e) {
            // 파일 쓰기 중 발생한 예외 처리
            e.printStackTrace();
        }
    }
}
