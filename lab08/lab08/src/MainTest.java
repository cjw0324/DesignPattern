/*
 * 자바프로그래밍2 1분반 Lab08
 * 32184682 최재우
 * 2024-11-26
 */

import crawl.AbstractWebCrawler;
import crawl.CGVCrawler;
import crawl.Recipe10000Crawler;

import static export.ExportType.*;

/**
 * MainTest
 * 템플릿 메서드 패턴을 구현한 웹 크롤러를 테스트하는 클래스입니다.
 * Recipe10000Crawler와 CGVCrawler 인스턴스를 생성하여 각 크롤링 동작을 실행합니다.
 */
public class MainTest {
    public static void main(String[] args) {
        // 10000 Recipes 웹사이트를 크롤링하는 Recipe10000Crawler 객체 생성
        AbstractWebCrawler crawler = new Recipe10000Crawler("https://www.10000recipe.com", JSON);
        // Recipe10000Crawler의 크롤링 작업 실행
        crawler.crawlWebsite();

        // CGV 웹사이트를 크롤링하는 CGVCrawler 객체 생성
        crawler = new CGVCrawler("http://www.cgv.co.kr/movies/?lt=1&ft=0", XML);
        // CGVCrawler의 크롤링 작업 실행
        crawler.crawlWebsite();
    }
}
