//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package models.Items;

import models.AbstractClass.LibraryItem;

public class CD extends LibraryItem {
    // CD의 아티스트 이름을 저장하는 필드
    private String artist;

    // 생성자: CD의 제목과 아티스트를 초기화
    public CD(String title, String artist) {
        super(title);  // 상위 클래스 LibraryItem의 생성자를 호출하여 제목을 설정
        this.artist = artist;  // 아티스트 이름을 설정
    }

    // ReportGenerator 인터페이스의 generateReport 메서드를 오버라이드하여 CD에 대한 보고서 생성
    @Override
    public void generateReport() {
        // CD의 제목과 아티스트 정보를 출력
        System.out.println("CD : " + getTitle() + ", Artist : " + artist);
    }
}
