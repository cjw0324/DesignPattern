//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package models.AbstractClass;

import Interface.ReportGenerator;

public abstract class LibraryItem implements ReportGenerator {
    // 항목의 제목을 저장하는 필드
    private String title;

    // 생성자: LibraryItem 객체를 생성할 때 제목을 초기화
    public LibraryItem(String title) {
        this.title = title;  // 항목의 제목을 설정
    }

    // 제목을 반환하는 메서드
    public String getTitle() {
        return title;  // 항목의 제목을 반환
    }
}
