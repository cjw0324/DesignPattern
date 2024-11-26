package crawl;
/*
 * 자바프로그래밍2 1분반 Lab08
 * 32184682 최재우
 * 2024-11-26
 */
import export.ExportType;
import org.jsoup.nodes.Document;

import java.util.List;

/**
 * AbstractWebCrawler
 * 템플릿 메서드 패턴을 기반으로 웹 크롤링 작업의 공통 로직을 구현하는 추상 클래스입니다.
 * 개별 크롤러 클래스는 이 클래스를 상속하여 각 단계의 세부 동작을 정의해야 합니다.
 */
public abstract class AbstractWebCrawler {
    // Jsoup 라이브러리가 사용하는 HTML 문서를 저장하기 위한 변수
    protected Document document;
    protected List<String> searchResults;
    protected ExportType exportType;
    /**
     * crawlWebsite()
     * 템플릿 메서드로 웹 크롤링 작업의 전체 순서를 정의합니다.
     * 각 단계는 하위 클래스에서 구현됩니다.
     * 순서: 연결 -> 페이지 가져오기 -> 페이지 파싱 -> 처리 -> 연결 해제
     */
    public final void crawlWebsite() {
        connectToWebsite();  // 웹사이트에 연결
        fetchPage();         // HTML 페이지를 가져오기
        parsePage();         // HTML 페이지 파싱
        process();           // 파싱된 데이터 처리
        exportFile(exportType); //MyCode - exportType 에 따른 파일 추출 형식 설정
        disconnectFromWebsite(); // 연결 해제
    }

    // 웹사이트에 연결하는 메서드 (하위 클래스에서 구현)
    abstract void connectToWebsite();

    // HTML 페이지를 가져오는 메서드 (하위 클래스에서 구현)
    abstract void fetchPage();

    // HTML 페이지를 파싱하는 메서드 (하위 클래스에서 구현)
    abstract void parsePage();

    // 파싱된 데이터를 처리하는 메서드 (하위 클래스에서 구현)
    abstract void process();

    abstract void exportFile(ExportType exportType);

    /**
     * disconnectFromWebsite()
     * 웹사이트와의 연결을 해제하는 메서드입니다.
     * 공통 동작으로, 하위 클래스에서 변경하지 않습니다.
     */
    public void disconnectFromWebsite() {
        System.out.println("disconnect"); // 연결 해제 메시지 출력
    }
}
