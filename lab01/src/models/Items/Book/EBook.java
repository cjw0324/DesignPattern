//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package models.Items.Book;

import Interface.Downloadable;

public class EBook extends Book implements Downloadable {
    // EBook은 Book 클래스를 상속받고, Downloadable 인터페이스를 구현함.
    // Book을 상속받음으로서 ReportGenerator와 LibraryItem 인터페이스도 간접적으로 상속받음.

    // 생성자: EBook의 제목과 저자를 초기화
    public EBook(String title, String author) {
        super(title, author);  // 상위 클래스 Book의 생성자를 호출하여 제목과 저자를 초기화
    }

    // ReportGenerator 인터페이스의 generateReport 메서드를 오버라이드하여 EBook에 대한 보고서 생성
    @Override
    public void generateReport() {
        // EBook의 제목과 저자를 출력
        System.out.println("EBook : " + getTitle() + ", Author : " + getAuthor());
    }

    // Downloadable 인터페이스의 download 메서드를 오버라이드하여 EBook 다운로드 기능 구현
    @Override
    public void download() {
        // EBook의 제목을 출력하고 다운로드 메시지 표시
        System.out.println("EBook : " + getTitle() + " Downloading ... ");
    }
}
