//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package models.Items;

import Interface.PublishDateGenerator;
import models.AbstractClass.LibraryItem;

import java.time.LocalDate;

public class Newspaper extends LibraryItem implements PublishDateGenerator {

    // 신문의 헤드라인을 저장하는 필드
    private String headLine;

    // 신문의 발행일을 저장하는 필드
    private LocalDate publishDate;

    // 생성자: 신문의 제목과 헤드라인을 초기화하고, 발행일을 생성
    public Newspaper(String title, String headLine) {
        super(title);  // 상위 클래스 LibraryItem의 생성자를 호출하여 제목을 설정
        this.headLine = headLine;  // 신문의 헤드라인을 설정
        this.publishDate = generatePublishDate();  // 발행일을 생성하여 설정
    }

    // PublishDateGenerator 인터페이스의 메서드를 구현하여 발행일을 생성
    @Override
    public LocalDate generatePublishDate() {
        // 발행일을 현재 날짜로 설정
        publishDate = LocalDate.now();
        return publishDate;  // 생성된 발행일을 반환
    }

    // ReportGenerator 인터페이스의 메서드를 오버라이드하여 신문에 대한 보고서 생성
    @Override
    public void generateReport() {
        // 신문의 제목, 발행일, 헤드라인을 출력
        System.out.println("NEWSPAPER : " + getTitle() + ", DATE : " + publishDate + ", HeadLine : " + headLine);
    }
}
