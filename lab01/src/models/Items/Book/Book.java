//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package models.Items.Book;

import models.AbstractClass.LibraryItem;

public class Book extends LibraryItem {
    // 책의 저자를 저장하는 필드
    private String author;

    // 생성자: 책의 제목과 저자를 초기화
    public Book(String title, String author) {
        super(title);  // 부모 클래스인 LibraryItem의 생성자를 호출하여 제목을 설정
        this.author = author;  // 저자 정보 설정
    }

    // 저자를 반환하는 메서드
    public String getAuthor() {
        return author;  // 책의 저자를 반환
    }

    // ReportGenerator 인터페이스의 메서드를 오버라이드하여 책에 대한 보고서 생성
    @Override
    public void generateReport() {
        // 책의 제목과 저자를 출력
        System.out.println("Book : " + getTitle() + ", Author : " + author);
    }
}
