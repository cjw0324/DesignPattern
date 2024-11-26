package crawl;
/*
 * 자바프로그래밍2 1분반 Lab08
 * 32184682 최재우
 * 2024-11-26
 */
import export.ExportType;
import export.JsonFileExporter;
import export.XmlFileExporter;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

import static export.ExportType.JSON;

/**
 * CGVCrawler
 * CGV 웹사이트에서 데이터를 크롤링하는 클래스입니다.
 */
public class CGVCrawler extends AbstractWebCrawler {

    private String url;
    private List<String> searchResults; // 검색 결과를 문자열로 저장

    public CGVCrawler(String url, ExportType exportType) {
        this.url = url;
        this.searchResults = new ArrayList<>();
        this.exportType = exportType;
    }

    @Override
    public void connectToWebsite() {
        System.out.println("Connecting to CGV website...");
    }

    @Override
    public void fetchPage() {
        try {
            document = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void parsePage() {
        if (document != null) {
            System.out.println("Parsing CGV website...");
            Elements movieElements = document.select(".sect-movie-chart .box-contents");
            for (Element movie : movieElements) {
                // 검색 결과 문자열로 생성
                String result = String.format("Title: %s, Release Date: %s, Rating: %s, Image: %s",
                        movie.select(".title").text(),
                        movie.select(".txt-info strong").text(),
                        movie.select(".percent span").text(),
                        movie.select(".thumb-image img").attr("src"));

                // 결과 저장
                searchResults.add(result);
            }
        }
    }

    public List<String> getSearchResults() {
        return searchResults; // 검색 결과 반환
    }

    @Override
    public void process() {
        System.out.println("Processing movie data...");
    }

    @Override
    void exportFile(ExportType exportType) {
        if (exportType.equals(JSON)) {
            JsonFileExporter jsonFileExporter = new JsonFileExporter();
            jsonFileExporter.exportToFile(searchResults, "cgv_movies.json");
        } else {
            XmlFileExporter xmlFileExporter = new XmlFileExporter();
            xmlFileExporter.exportToFile(searchResults, "cgv_movies.xml");
        }
    }
}
