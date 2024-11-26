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
 * Recipe10000Crawler
 * 10000 Recipes 웹사이트에서 데이터를 크롤링하는 클래스입니다.
 */
public class Recipe10000Crawler extends AbstractWebCrawler {

    private String url;
    private List<String> searchResults; // 검색 결과를 문자열로 저장

    public Recipe10000Crawler(String url, ExportType exportType) {
        this.url = url;
        this.searchResults = new ArrayList<>();
        this.exportType = exportType;
    }

    @Override
    public void connectToWebsite() {
        System.out.println("Connecting to 10000 Recipes website...");
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
            System.out.println("Parsing 10000 Recipes website...");
            Elements recipes = document.select(".common_sp_list_ul li");
            for (Element recipe : recipes) {
                // 검색 결과 문자열로 생성
                String result = String.format("Title: %s, Description: %s, Image: %s, Link: %s",
                        recipe.select(".common_sp_caption_tit.line2").text(),
                        recipe.select(".common_sp_caption_rv").text(),
                        recipe.select(".common_sp_thumb img").attr("src"),
                        recipe.select("a").attr("href"));

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
        System.out.println("Processing recipe data...");
    }

    @Override
    void exportFile(ExportType exportType) {
        if (exportType.equals(JSON)) {
            JsonFileExporter jsonFileExporter = new JsonFileExporter();
            jsonFileExporter.exportToFile(searchResults, "recipes.json");
        } else {
            XmlFileExporter xmlFileExporter = new XmlFileExporter();
            xmlFileExporter.exportToFile(searchResults, "recipes.xml");
        }
    }
}
